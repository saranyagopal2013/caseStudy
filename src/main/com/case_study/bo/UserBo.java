package com.case_study.bo;

import java.io.IOException;
import java.sql.SQLException;

import com.case_study.dao.UserDao;
import com.case_study.model.User;


public class UserBo {
	
	public User getUserByUserName(String name) throws SQLException, IOException {
		
		UserDao usdao=new UserDao();
		User obj=usdao.getUserByUserName(name);
		return obj;
	
	
	}
	
	
	
	public User loginUser(String username,String password)throws SQLException, IOException
	{
		User us=new User(username,password);
		UserDao usdao=new UserDao();
		User obj=usdao.loginUser(username, password);
		return obj;
	}
	
	public int registerUser(User user) throws SQLException, IOException
	{
		
		UserDao us1=new UserDao();
		int ID=us1.registerUser(user);
		return ID;
	}
	
}
