package org.zealot.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zealot.bean.ForumBoard;
import org.zealot.bean.ForumPost;
import org.zealot.bean.ForumUser;
import org.zealot.biz.ForumBiz;
import org.zealot.biz.impl.ForumBizImpl;
import org.zealot.util.ServletUtils;
import org.zealot.web.model.Model;

public class ForumServlet extends HttpServlet {
	private String op;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		op = req.getParameter("op");
		switch (op) {
		case "displayBoard":
			displayBoard(req, resp);/* 查询所有版块信息 */
			break;
		case "displayPosts":
			String boardId = req.getParameter("boardId");
			Integer startNum, pageSize;
			if (boardId != null) { /* 如果有boardId，说明是查询某个版块的下的所有帖子 */
				startNum = Integer.parseInt(req.getParameter("startNum"));
				pageSize = Integer.parseInt(req.getParameter("pageSize"));
			} else { /* 没有boradId的话，就是查询最新的20个帖子 */
				startNum = 0;
				pageSize = 20;
			}
			displayPosts(boardId, startNum, pageSize, req, resp);
			break;
		case "displayPostDetailsByPostId":
			Integer postId = Integer.parseInt(req.getParameter("postId"));
			displayPostDetails(postId, req, resp);
			break;
		default:
			break;
		}

	}

	/* 显示某个帖子的所有信息 */
	private void displayPostDetails(Integer postId, HttpServletRequest req, HttpServletResponse resp) {
		ForumBiz fb = new ForumBizImpl();
		ForumPost fp = fb.getPostDetails(postId, req);
		Model model = new Model(1,"",fp);
		ServletUtils.printJson(resp, model);
	}

	/* 显示左边版块数据 */
	private void displayBoard(HttpServletRequest req, HttpServletResponse resp) {
		ForumBiz fb = new ForumBizImpl();
		List<ForumBoard> boardList = fb.getAllBoards();
		Model model = new Model(1, "", boardList);
		ServletUtils.printJson(resp, model);
	}

	/*
	 * 如果boardId==null,则显示右边最新的20条帖子 如果boardId!=null,则显示出某个版块下的所有贴子
	 */
	private void displayPosts(String boardId, Integer startNum, Integer pageSize, HttpServletRequest req,
			HttpServletResponse resp) {
		ForumBiz fb = new ForumBizImpl();
		List<ForumPost> postList = fb.getPostsByPaging(boardId, startNum, pageSize);
		if (postList != null) {
			StringBuilder defaultAvator = new StringBuilder();
			defaultAvator.append(req.getScheme()).append("://").append(req.getServerName()).append(":")
					.append(req.getServerPort()).append(req.getContextPath()).append(File.separator).append("img")
					.append(File.separator).append("zanwu.jpg");
			for (ForumPost fp : postList) 
				if (fp.getForumUser().getAvator() == null)
					fp.getForumUser().setAvator(defaultAvator.toString());
			
		}
		Model model = new Model(1, "", postList);
		ServletUtils.printJson(resp, model);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		op = req.getParameter("op");
		switch (op) {
		case "publishPost":
			publishPost(req, resp);
			break;
		case "publishReply":
			publishReply(req,resp);
			break;
		case "publishComment":
			publishComment(req,resp);
			break;
		default:
			break;
		}
	}
	
	/* 发布评论，同时返回此回评论的所有相关信息 */
	private void publishComment(HttpServletRequest req, HttpServletResponse resp) {
		String commentContent = req.getParameter("commentContent");
		Integer replyId = Integer.parseInt(req.getParameter("replyId"));
		String username = req.getParameter("username");
		ForumBiz fb = new ForumBizImpl();
		Model model = fb.publishComment(commentContent,replyId,username);
		ServletUtils.printJson(resp, model);
	}

	/* 发布回贴，同时返回此回贴的所有相关信息 */
	private void publishReply(HttpServletRequest req, HttpServletResponse resp) {
		String replyContent = req.getParameter("replyContent");
		Integer postId = Integer.parseInt(req.getParameter("postId"));
		String username = req.getParameter("username");
		ForumBiz fb = new ForumBizImpl();
		Model model = fb.publishReply(replyContent, postId, username);
		ServletUtils.printJson(resp, model);
	}

	/* 发布帖子 */
	private void publishPost(HttpServletRequest req, HttpServletResponse resp) {
		ForumPost fp = ServletUtils.parseRequest(req, ForumPost.class);
		String username = req.getParameter("username");
		Integer boardId = Integer.parseInt(req.getParameter("boardId"));
		ForumBiz fb = new ForumBizImpl();
		Model model = fb.publishPost(fp, username, boardId);
		ServletUtils.printJson(resp, model);
	}
}
