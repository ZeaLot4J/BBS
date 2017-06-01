package org.zealot.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ForumPost implements Serializable {
	private static final long serialVersionUID = 5798415839424161615L;
	private Integer postId;
	private String postTitle;
	private String postContent;
	private String postPublishTime;
	private String postModifyTime;
	private String postEndTime;
	private ForumUser forumUser;
	private ForumBoard forumBoard;
	private List<PostReply> replyList;
	private Integer replyNum;

	public Integer getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}

	public List<PostReply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<PostReply> replyList) {
		this.replyList = replyList;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostPublishTime() {
		return postPublishTime;
	}

	public void setPostPublishTime(String postPublishTime) {
		this.postPublishTime = postPublishTime;
	}

	public String getPostModifyTime() {
		return postModifyTime;
	}

	public void setPostModifyTime(String postModifyTime) {
		this.postModifyTime = postModifyTime;
	}

	public String getPostEndTime() {
		return postEndTime;
	}

	public void setPostEndTime(String postEndTime) {
		this.postEndTime = postEndTime;
	}

	public ForumUser getForumUser() {
		return forumUser;
	}

	public void setForumUser(ForumUser forumUser) {
		this.forumUser = forumUser;
	}

	public ForumBoard getForumBoard() {
		return forumBoard;
	}

	public void setForumBoard(ForumBoard forumBoard) {
		this.forumBoard = forumBoard;
	}

	@Override
	public String toString() {
		return "ForumPost [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postPublishTime=" + postPublishTime + ", postModifyTime=" + postModifyTime + ", postEndTime="
				+ postEndTime + ", forumUser=" + forumUser + ", forumBoard=" + forumBoard + ", replyList=" + replyList
				+ ", replyNum=" + replyNum + "]";
	}

}
