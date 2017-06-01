package org.zealot.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ForumUser implements Serializable {
	private static final long serialVersionUID = 1676383615123299393L;
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private String registerTime;
	private String avator;
	private int role;
	private List<ForumPost> postList;
	
	public List<ForumPost> getPostList() {
		return postList;
	}

	public void setPostList(List<ForumPost> postList) {
		this.postList = postList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getAvator() {
		return avator;
	}

	public void setAvator(String avator) {
		this.avator = avator;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ForumUser [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", registerTime=" + registerTime + ", avator=" + avator + ", role=" + role + ", postList=" + postList
				+ "]";
	}

}
