package org.zealot.bean;

import java.io.Serializable;
import java.util.Date;

public class ReplyComment implements Serializable {
	private static final long serialVersionUID = 4153855361840492103L;
	private Integer commentId;
	private String commentContent;
	private String commentPublishTime;
	private String commentModifyTime;
	private ForumUser forumUser;
	private PostReply postReply;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentPublishTime() {
		return commentPublishTime;
	}

	public void setCommentPublishTime(String commentPublishTime) {
		this.commentPublishTime = commentPublishTime;
	}

	public String getCommentModifyTime() {
		return commentModifyTime;
	}

	public void setCommentModifyTime(String commentModifyTime) {
		this.commentModifyTime = commentModifyTime;
	}

	public ForumUser getForumUser() {
		return forumUser;
	}

	public void setForumUser(ForumUser forumUser) {
		this.forumUser = forumUser;
	}

	public PostReply getPostReply() {
		return postReply;
	}

	public void setPostReply(PostReply postReply) {
		this.postReply = postReply;
	}

	@Override
	public String toString() {
		return "ReplyComment [commentId=" + commentId + ", commentContent=" + commentContent + ", commentPublishTime="
				+ commentPublishTime + ", commentModifyTime=" + commentModifyTime + ", forumUser=" + forumUser
				+ ", postReply=" + postReply + "]";
	}

	
}
