package org.zealot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * 处理java servlet的一些工具
 * 1、以JSON格式返回响应数据 2、将Request中数据注入javabean
 * 
 * @author ZeaLot
 *
 */
public class ServletUtils {
	private static Gson gson = new Gson();

	/**
	 * 将JSON格式化后的数据响应到前端
	 * 
	 * @param resp
	 * @param t
	 */
	public static <T> void printJson(HttpServletResponse resp, T t) {
		resp.setContentType("application/json;charset=utf-8");
		try (PrintWriter out = resp.getWriter();) {
			out.print(gson.toJson(t));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 只能封装简单的bean, 嵌套对象成员和数组成员无法完成 
	 * 解析Request中的参数将其封装成指定的javabean
	 * 
	 * @param req
	 * @param t
	 * @return
	 */
	public static <T> T parseRequest(HttpServletRequest req, Class<T> c) {
		Map<String, String[]> params = req.getParameterMap();
		T bean = null;
		try {
			bean = c.newInstance();
			Field[] fields = c.getDeclaredFields();
			for (Field field : fields) {
				String[] fieldValue = params.get(field.getName());
				/* 如果只有一个值则直接注入，多个值无法完成 */
				if (fieldValue != null) {
					if (fieldValue.length == 1) {
						String fieldName = field.getName();
						String fieldType = field.getType().getName();
						Method setMethod = c.getDeclaredMethod(
								"set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1),
								field.getType());
						switch(fieldType){
						case "int":
						case "java.lang.Integer":
							setMethod.invoke(bean, Integer.parseInt(fieldValue[0]));							
							break;
						case "float":
						case "java.lang.Float":
							setMethod.invoke(bean, Float.parseFloat(fieldValue[0]));
							break;
						case "double":
						case "java.lang.Double":
							setMethod.invoke(bean, Double.parseDouble(fieldValue[0]));
							break;
						case "boolean":
						case "java.lang.Boolean":
							setMethod.invoke(bean, Boolean.parseBoolean(fieldValue[0]));
							break;
						case "java.lang.String":
							setMethod.invoke(bean, fieldValue[0]);
							break;
						default: break;
						}
					}
				}
			}
		} catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException
				| SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
