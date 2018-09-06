package com.case_study.Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.case_study.dao.UserDao;
import com.case_study.model.User;

public class userDaoTest {
	
	UserDao user=new UserDao();
	
	@Test
	public void getUserByNameSucessTest() throws SQLException, IOException {

		assertNotNull(user);
		String userName = "saravanan1";
		User obj=new User();
		obj=user.getUserByUserName(userName);
		assertEquals(userName,obj.getUser_name());

	}
	@Test
	public void getUserByNameFailureTest() throws SQLException, IOException {

		assertNotNull(user);
		String userName = "saran";
		assertNull(user.getUserByUserName(userName));
	}
	
	
	@Test
	public void getAllUserSucessTest() throws SQLException, IOException {
		List<User> userList = new ArrayList<User>();
			userList.add(new User("sara","sara123"));
			userList.add(new User("saravanan1","saravanan123"));
			userList.add(new User("siddhu","siddhu123"));
		
		List<User> ulist = new ArrayList<User>();
		ulist = user.getAllUser();
		assertFalse(ulist.isEmpty());
		
	
		
		//compare the actual with excepted list
		for(User expected:userList) {
			
			for(User actual:ulist) {
				if(expected.getUser_name().equals(actual.getUser_name())){
					assertThat(expected.getUser_id(),is(actual.getUser_id()));
					assertThat(expected.getPassword(),is(actual.getPassword()));
				}
			}
			
		}
	}
	@Test
	public void getAllUserNegTest() throws SQLException, IOException {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("aru", "556"));
		userList.add(new User("sanchu","123e"));
		userList.add(new User("good", "111"));
		userList.add(new User("selenium","123e"));

		List<User> ulist = new ArrayList<User>();
		ulist = user.getAllUser();
		assertFalse(ulist.isEmpty());
		for (User expected : userList) {
			for (User actual : ulist) {

				if (expected.getUser_name().equals(actual.getUser_name())) {
					assertThat(expected.getUser_id(), not(actual.getUser_id()));
					assertThat(expected.getPassword(), not(actual.getPassword()));
					
				}
			}
		}

	}
	
	@Test
	public void RegisterNewUserTest() throws SQLException, IOException, InterruptedException {
		User user1 = new User("siddharth","siddhu1234");
		int result =user.registerUser(user1);
		assertThat(result, is(not(-1)));
		Thread.sleep(3000);
		User obj=user.getUserByUserName(user1.getUser_name());
		assertEquals(user1.getUser_name(),obj.getUser_name());
		
		
		
	}
	
	@Test//existing user registered
	public void RegisterUserFailTest() throws SQLException, IOException {
		User userFail = new User("sara","sara123");
		int Id =user.registerUser(userFail);
		assertThat(Id, is(-1));
		}
	
	
	
	@Test//register  null username
	public void RegisterUserFailNullUsername() throws SQLException, IOException 
	{
		User fail = new User(null,"junit");
		int Id =user.registerUser(fail);
		assertThat(Id, is(-1));
	}
	
	@Test//register null Password
	public void RegisterUserNegTest3() throws SQLException, IOException {
		User passFail = new User("malarvizhi",null);
		int Id= user.registerUser(passFail);
		assertThat(Id, is(-1));
		
	
	}
	
	@Test// remove the user 
	public void RemoveUserSucessTest() throws SQLException, IOException {
		User user1 = user.getUserByUserName("siddharth");
		
		assertThat(user1, notNullValue());
		
		int Id = user.removeUser(user1);
		
		assertThat(Id, is(not(-1)));
		assertThat(Id, is(not(0)));
		assertThat(user.getUserByUserName(user1.getUser_name()), nullValue());
		if(Id > 0) {
			user.registerUser(user1);
		}
		
	}
	@Test 
	public void RemoveUserFailTest() throws SQLException, IOException {
		List<User> existing = user.getAllUser();
		
		User userFail =new User("fail","fail123");
		int Id = user.removeUser(userFail);
		
		assertThat(Id, is(0));
		assertThat(user.getUserByUserName(userFail.getUser_name()), nullValue());
		
		List<User> afterRemove = user.getAllUser();
		
		assertThat(existing.size(), is(afterRemove.size()));
		
	
		
		for(User before:existing) {
				
			for(User after:afterRemove) {
				if(before.getUser_name().equals(after.getUser_name())) {
					assertThat(before.getUser_id(),is(after.getUser_id()));
				
				}
			}
		
		}
			
	}
	
	


}
