package org.zealot.biz;

import org.zealot.bean.ForumUser;
import org.zealot.web.model.Model;

public interface ForumUserBiz {

	Model getCurrentUserInfo(ForumUser fu);

	int updateForumUserAvator(ForumUser fu);

	int updateUsername(ForumUser fu);

}
