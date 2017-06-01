package org.zealot.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zealot.bean.ForumUser;
import org.zealot.biz.RegisterBiz;
import org.zealot.dao.MyBatisDao;
import org.zealot.dao.impl.MyBatisDaoImpl;
import org.zealot.util.EncryptUtils;
import org.zealot.web.model.Model;

public class RegisterBizImpl implements RegisterBiz {
	MyBatisDao dao;
	
	@Override
	public Model register(ForumUser fu) {
		dao = new MyBatisDaoImpl();
		Model model = new Model();
		Map<String, String> param = new HashMap<>();
		param.put("username", fu.getUsername());
		List<ForumUser> fuList = dao.get(fu, param, "checkForumUsersExistence");
		if(fuList.size() > 0){
			model.setCode(0);
			model.setMessage("用户名已经存在!");
			return model;
		}
		fu.setPassword(EncryptUtils.md5(fu.getPassword()));
		int result = dao.add(fu, "insertOneForumUser");
		if(result <= 0){
			model.setCode(0);
			model.setMessage("注册失败");
			return model;
		}
		model.setCode(1);
		model.setMessage("注册成功");
		return model;
	}
}
