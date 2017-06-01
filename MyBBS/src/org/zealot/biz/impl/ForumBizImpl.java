package org.zealot.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.zealot.bean.ForumBoard;
import org.zealot.bean.ForumPost;
import org.zealot.bean.ForumUser;
import org.zealot.bean.PostReply;
import org.zealot.bean.ReplyComment;
import org.zealot.biz.ForumBiz;
import org.zealot.dao.MyBatisDao;
import org.zealot.dao.impl.MyBatisDaoImpl;
import org.zealot.web.model.Model;

public class ForumBizImpl implements ForumBiz {
	@Override
	public List<ForumBoard> getAllBoards() {
		MyBatisDao mbd = new MyBatisDaoImpl();
		return mbd.get(new ForumBoard(), "selectAllBoards");
	}

	@Override
	public List<ForumPost> getPostsByPaging(String boardId, Integer startNum, Integer pageSize) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		Map<String, Object> params = new HashMap<>();
		params.put("startNum", startNum);
		params.put("pageSize", pageSize);
		params.put("boardId", boardId);
		return mbd.get(new ForumPost(), params, "selectPostsByPaging");
	}
	@Override
	public List<ForumPost> getPostsByUserId(String userId, Integer startNum, Integer pageSize) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		Map<String, Object> params = new HashMap<>();
		params.put("startNum", startNum);
		params.put("pageSize", pageSize);
		params.put("userId", userId);
		return mbd.get(new ForumPost(), params, "selectPostsByUserId");
	}

	@Override
	public Model publishPost(ForumPost fp, String username, Integer boardId) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		Integer userId = mbd.getOnePrimitive(new ForumUser(), username, "selectUserIdByUsername");
		ForumUser forumUser = new ForumUser();
		forumUser.setUserId(userId);
		fp.setForumUser(forumUser);
		ForumBoard forumBoard = new ForumBoard();
		forumBoard.setBoardId(boardId);
		fp.setForumBoard(forumBoard);
		Model model = new Model();
		if (mbd.add(fp, "insertOneForumPost") <= 0) {
			model.setCode(0);
			model.setMessage("发贴失败，请重新发布");
			return model;
		}
		model.setCode(1);
		model.setMessage("发贴成功");
		return model;
	}

	@Override
	public ForumPost getPostDetails(Integer postId, HttpServletRequest req) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		Map<String, Integer> param = new HashMap<>();
		param.put("postId", postId);
		List<ForumPost> postList = mbd.get(new ForumPost(), param, "selectPostByPostId");
		ForumPost fp = postList.get(0);
		StringBuilder defaultAvator = new StringBuilder();
		List<PostReply> replyList = mbd.get(new PostReply(), param, "selectAllRepliesByPostId");
		fp.setReplyList(replyList);
		for (PostReply pr : replyList) {
			param.put("replyId", pr.getReplyId());
			List<ReplyComment> commentList = mbd.get(new ReplyComment(), param, "selectAllCommentsByReplyId");
			pr.setCommentList(commentList);
		}
		return fp;
	}

	@Override
	public Model publishReply(String replyContent, Integer postId, String username) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		ForumUser fu = new ForumUser();
		fu.setUsername(username);
		List<ForumUser> userList = mbd.get(fu, "selectForumUserByUsername");
		Model model = new Model();
		if (userList.size() > 0) {
			fu = userList.get(0);
			PostReply reply = new PostReply();
			reply.setForumUser(fu);
			reply.setReplyContent(replyContent);
			ForumPost fp = new ForumPost();
			fp.setPostId(postId);
			reply.setForumPost(fp);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			reply.setReplyPublishTime(sdf.format(new Date()));
			if (mbd.add(reply, "insertOneReply") > 0) {
				model.setCode(1);
				model.setData(reply);
				model.setMessage("");
			} else {
				model.setCode(0);
				model.setMessage("回贴发表失败");
			}
		} else {
			model.setCode(0);
			model.setMessage("当前用户状态出现异常，请重新登录");
		}
		return model;
	}

	@Override
	public Model publishComment(String commentContent, Integer replyId, String username) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		ForumUser fu = new ForumUser();
		fu.setUsername(username);
		List<ForumUser> userList = mbd.get(fu, "selectForumUserByUsername");
		Model model = new Model();
		if (userList.size() > 0) {
			fu = userList.get(0);
			ReplyComment comment = new ReplyComment();
			comment.setForumUser(fu);
			comment.setCommentContent(commentContent);
			PostReply pr = new PostReply();
			pr.setReplyId(replyId);
			comment.setPostReply(pr);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			comment.setCommentPublishTime(sdf.format(new Date()));
			if (mbd.add(comment, "insertOneComment") > 0) {
				model.setCode(1);
				model.setData(comment);
				model.setMessage("");
			} else {
				model.setCode(0);
				model.setMessage("评论发表失败");
			}
		}
		return model;
	}
}
