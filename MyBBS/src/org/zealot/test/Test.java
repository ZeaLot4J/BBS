package org.zealot.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zealot.bean.ForumPost;
import org.zealot.bean.ForumUser;
import org.zealot.dao.MyBatisDao;
import org.zealot.dao.impl.MyBatisDaoImpl;
import org.zealot.util.MyBatisUtils;

public class Test {
	@org.junit.Test
	public void testApp1(){
		MyBatisDao mbd = new MyBatisDaoImpl();
		ForumUser fu = new ForumUser();
		fu.setUsername("zealot");
		List<ForumUser> userList = mbd.get(fu, "selectForumUserByUsername");
		System.out.println(userList);
	}
}
