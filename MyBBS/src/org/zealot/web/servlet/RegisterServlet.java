package org.zealot.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zealot.bean.ForumUser;
import org.zealot.biz.RegisterBiz;
import org.zealot.biz.impl.RegisterBizImpl;
import org.zealot.util.ServletUtils;
import org.zealot.web.model.Model;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		register(req, resp);
	}
	
	
	/**
	 * 注册
	 * @param req
	 * @param resp
	 */
	private void register(HttpServletRequest req, HttpServletResponse resp){
		ForumUser fu = ServletUtils.parseRequest(req, ForumUser.class);
		RegisterBiz rb = new RegisterBizImpl();
		Model model = rb.register(fu);
		ServletUtils.printJson(resp, model);
	}
}
