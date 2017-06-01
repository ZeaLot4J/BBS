package org.zealot.util;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 单例SqlSessionFactory工厂
 * @author ZeaLot
 *
 */
public class MyBatisUtils {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			sqlSessionFactory= new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 建立一次SQL会话
	 * @return
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	private MyBatisUtils(){}
}
