package com.syu.supporter.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao{
	String ns ="com.syu.supporter.login.LoginDao.";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(LoginInfo loginInfo) {
		int count = Integer.parseInt(sqlSession.selectOne(ns+"loginCheck", loginInfo).toString()),
				totalCount = sqlSession.selectOne(ns+"totalAccount");
		
		if(totalCount>0) {
			if(count>0) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

}
