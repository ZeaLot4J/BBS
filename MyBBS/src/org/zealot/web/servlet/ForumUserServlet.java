package org.zealot.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zealot.bean.ForumPost;
import org.zealot.bean.ForumUser;
import org.zealot.biz.ForumBiz;
import org.zealot.biz.ForumUserBiz;
import org.zealot.biz.impl.ForumBizImpl;
import org.zealot.biz.impl.ForumUserBizImpl;
import org.zealot.util.ServletUtils;
import org.zealot.web.model.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class ForumUserServlet extends HttpServlet {
	private String op;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		op = req.getParameter("op");
		switch (op) {
		case "displayUserInfo":
			displayUserInfo(req, resp);
			break;
		case "displayPersonalPosts":
			displayPersonalPosts(req, resp);
			break;
		}
	}

	private void displayPersonalPosts(HttpServletRequest req, HttpServletResponse resp) {
		String userId = req.getParameter("userId");
		String startNum = req.getParameter("startNum");
		String pageSize = req.getParameter("pageSize");
		
		ForumBiz fb = new ForumBizImpl();
		List<ForumPost> postList = fb.getPostsByUserId(userId, Integer.parseInt(startNum), Integer.parseInt(pageSize));
		Model model = new Model(1, "", postList);
		ServletUtils.printJson(resp, model);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		op = req.getParameter("op");
		switch (op) {
		case "":

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		op = req.getParameter("op");
		switch (op) {
		case "uploadAvator":
			uploadAvator(req, resp);
			break;
		
		}
	}

	private void displayUserInfo(HttpServletRequest req, HttpServletResponse resp) {
		ForumUserBiz fub = new ForumUserBizImpl();
		String username = req.getParameter("username");
		ForumUser fu = new ForumUser();
		fu.setUsername(username);
		Model model = fub.getCurrentUserInfo(fu);
		ServletUtils.printJson(resp, model);
	}

	private void uploadAvator(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 存相对路径
		String userId = req.getParameter("userId");
		StringBuilder filePath = new StringBuilder();
		Date today = new Date();
		filePath.append(req.getServletContext().getRealPath("/")).append("../upload").append(File.separator)
				.append(today.getYear() + 1900).append(File.separator).append(today.getMonth() + 1)
				.append(File.separator).append(today.getDate()).append(File.separator).append(userId);
		System.out.println(filePath);// 输出存放上传文件所到的路径
		File uploadPath = new File(filePath.toString());
		// 检查文件夹是否存在 不存在 创建一个
		if (!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		// 文件最大容量 10M
		int fileMaxSize = 10 * 1024 * 1024;
		// 文件名
		String fileName = null;
		// 上传文件
		MultipartRequest mulit = new MultipartRequest(req, filePath.toString(), fileMaxSize, "UTF-8",
				new FileRenamePolicy() {
					@Override
					public File rename(File file) {
						String fileName = file.getName();
						String extName = fileName.substring(fileName.indexOf("."));
						return new File(file.getParent(), new Date().getTime() + extName);
					}
				});

		Enumeration filesname = mulit.getFileNames();// 取得上传的所有文件(相当于标识)
		while (filesname.hasMoreElements()) {
			String name = (String) filesname.nextElement();// 标识
			System.out.println(name);
			fileName = mulit.getFilesystemName(name); // 取得文件名
			String contentType = mulit.getContentType(name);// 工具标识取得的文件类型
		}
		String avator = ".."+File.separator+filePath.substring(filePath.indexOf("../upload"))+File.separator+fileName;
		ForumUser fu =new ForumUser();
		fu.setAvator(avator);
		fu.setUserId(Integer.parseInt(userId));
		updateForumUserAvator(fu, resp);
	}
	
	private void updateForumUserAvator(ForumUser fu, HttpServletResponse resp){
		ForumUserBiz fub = new ForumUserBizImpl();
		Model model = new Model();
		if(fub.updateForumUserAvator(fu) > 0){
			model.setCode(1);
			model.setMessage("修改成功");
			model.setData(fu);
		}else{
			model.setCode(0);
			model.setMessage("修改失败");
		}
		ServletUtils.printJson(resp, model);
	}
	
}
