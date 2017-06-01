package org.zealot.biz.impl;

import java.util.List;

import org.zealot.bean.ForumUser;
import org.zealot.biz.LoginBiz;
import org.zealot.dao.MyBatisDao;
import org.zealot.dao.impl.MyBatisDaoImpl;
import org.zealot.util.EncryptUtils;
import org.zealot.web.model.Model;

public class LoginBizImpl implements LoginBiz {
	@Override
	public Model loginCheck(ForumUser fu) {
		MyBatisDao mbd = new MyBatisDaoImpl();
		fu.setPassword(EncryptUtils.md5(fu.getPassword()));
		List<ForumUser> resultList = mbd.get(fu, "checkOneLoginUser");
		Model model = new Model();
		if(resultList.size()<=0){
			model.setCode(0);
			model.setMessage("用户名或密码错误!");
		}else{
			model.setCode(1);
			model.setMessage("登录成功");
			model.setData(resultList.get(0));
		}
		return model;
	}
}
