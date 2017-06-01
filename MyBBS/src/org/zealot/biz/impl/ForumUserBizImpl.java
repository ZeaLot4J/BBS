package org.zealot.biz.impl;

import java.util.List;

import org.zealot.bean.ForumUser;
import org.zealot.biz.ForumUserBiz;
import org.zealot.dao.MyBatisDao;
import org.zealot.dao.impl.MyBatisDaoImpl;
import org.zealot.web.model.Model;

public class ForumUserBizImpl implements ForumUserBiz {

	@Override
	public Model getCurrentUserInfo(ForumUser fu) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		List<ForumUser> userList = mbd.get(fu, "selectForumUserByUsername");
		Model model = new Model();
		if(userList.size() > 0){
			model.setCode(1);
			model.setData(userList.get(0));
			model.setMessage("");
		}else{
			model.setCode(0);
			model.setMessage("用户状态异常");
		}
		return model;
	}

	@Override
	public int updateForumUserAvator(ForumUser fu) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		return mbd.update(fu, "updateForumUserAvator");
	}

	@Override
	public int updateUsername(ForumUser fu) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		return mbd.update(fu, "updateUsername");
	}
}
