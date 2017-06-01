package org.zealot.bean;

import java.io.Serializable;
import java.util.List;

public class PostReply implements Serializable {
	private static final long serialVersionUID = -2809403167059569822L;
	private Integer replyId;
	private String replyContent;
	private String replyPublishTime;
	private String replyModifyTime;
	private ForumUser forumUser;
	private ForumPost forumPost;
	private List<ReplyComment> commentList;

	public List<ReplyComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<ReplyComment> commentList) {
		this.commentList = commentList;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyPublishTime() {
		return replyPublishTime;
	}

	public void setReplyPublishTime(String replyPublishTime) {
		this.replyPublishTime = replyPublishTime;
	}

	public String getReplyModifyTime() {
		return replyModifyTime;
	}

	public void setReplyModifyTime(String replyModifyTime) {
		this.replyModifyTime = replyModifyTime;
	}

	public ForumUser getForumUser() {
		return forumUser;
	}

	public void setForumUser(ForumUser forumUser) {
		this.forumUser = forumUser;
	}

	public ForumPost getForumPost() {
		return forumPost;
	}

	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
	}

	@Override
	public String toString() {
		return "PostReply [replyId=" + replyId + ", replyContent=" + replyContent + ", replyPublishTime="
				+ replyPublishTime + ", replyModifyTime=" + replyModifyTime + ", forumUser=" + forumUser
				+ ", forumPost=" + forumPost + ", commentList=" + commentList + "]";
	}

}
