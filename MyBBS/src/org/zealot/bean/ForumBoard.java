package org.zealot.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForumBoard implements Serializable {
	private static final long serialVersionUID = -7120001837515612980L;
	private Integer boardId;
	private String boardName;
	private String boardCreateTime;
	private ForumUser boardOwner;

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardCreateTime() {
		return boardCreateTime;
	}

	public void setBoardCreateTime(String boardCreateTime) {
		this.boardCreateTime = boardCreateTime;
	}

	public ForumUser getBoardOwner() {
		return boardOwner;
	}

	public void setBoardOwner(ForumUser boardOwner) {
		this.boardOwner = boardOwner;
	}

	@Override
	public String toString() {
		return "ForumBoard [boardId=" + boardId + ", boardName=" + boardName + ", boardCreateTime=" + boardCreateTime
				+ ", boardOwner=" + boardOwner + "]";
	}

}
