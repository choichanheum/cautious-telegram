package com.syu.supporter.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public boolean loginCheck(LoginInfo loginInfo) {
		return loginDao.loginCheck(loginInfo);
	}


}
