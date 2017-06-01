package org.zealot.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zealot.bean.ForumUser;
import org.zealot.biz.LoginBiz;
import org.zealot.biz.impl.LoginBizImpl;
import org.zealot.util.ServletUtils;
import org.zealot.web.model.Model;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logout(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response){
		ForumUser fu = ServletUtils.parseRequest(request, ForumUser.class);
		HttpSession session = request.getSession();
		String verifycode = (String) session.getAttribute("verifycode");
		Model model = new Model();
		String vc = request.getParameter("verifycode");
		if(verifycode.equalsIgnoreCase(request.getParameter("verifycode"))){
			LoginBiz lb = new LoginBizImpl();
			model = lb.loginCheck(fu);
			if(model.getCode()==1)
				session.setAttribute("forumUser", fu.getUsername());
			ServletUtils.printJson(response, model);
		}else
			ServletUtils.printJson(response, new Model(0,"验证码错误",null));
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.invalidate();
		ServletUtils.printJson(response, 1);
	}
}
