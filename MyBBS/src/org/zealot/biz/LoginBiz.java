package org.zealot.biz;

import org.zealot.bean.ForumUser;
import org.zealot.web.model.Model;

public interface LoginBiz {
	Model loginCheck(ForumUser fu);
}
