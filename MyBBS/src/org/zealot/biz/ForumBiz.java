package org.zealot.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.zealot.bean.ForumBoard;
import org.zealot.bean.ForumPost;
import org.zealot.web.model.Model;

public interface ForumBiz {
	List<ForumBoard> getAllBoards();

	Model publishPost(ForumPost fp, String username, Integer boardId);

	List<ForumPost> getPostsByPaging(String boardId, Integer startNum, Integer pageSize);

	ForumPost getPostDetails(Integer postId, HttpServletRequest req);

	Model publishReply(String replyContent, Integer postId, String username);

	Model publishComment(String commentContent, Integer replyId, String username);

	List<ForumPost> getPostsByUserId(String userId, Integer startNum, Integer pageSize);
}
