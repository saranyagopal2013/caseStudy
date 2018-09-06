package com.case_study.Junit;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.case_study.dao.HomeOwnerDao;
import com.case_study.model.HomeOwner;

public class HomeOwnerDaoTest {
	
	HomeOwnerDao home = new HomeOwnerDao();
	
	@Test//
	public void  GetAllHomeOwnersSuccessTest() throws ParseException, SQLException, IOException 
	{
		List<HomeOwner> expected = new ArrayList<HomeOwner>();//sample data list
		


		expected.add(new HomeOwner("saranya","gopal",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1990-03-12").getTime()),"on",987654321,"sara3@gmail.com",1));
		expected.add(new HomeOwner("saranya","saravanan",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1990-03-12").getTime()),"on",2898989,"saranya@gmail.com",1));
		
		
		//list of actual data
		List<HomeOwner> actual = home.getAllHomeOwner();
		
		
		for(HomeOwner expected1:expected) {
		
			for(HomeOwner actual1:actual) {
				if(expected1.getEmail_id().equals(actual1.getEmail_id())){
					assertThat(expected,is(actual));
				
				}
			}
		
		}
	
	}
	@Test// invalid data 
	public void  GetAllHomeOwnersFailTest() throws ParseException, SQLException, IOException 
	{
		List<HomeOwner> expected = new ArrayList<HomeOwner>();//sample data list
		
		expected.add(new HomeOwner("saranya","goal",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1990-03-12").getTime()),"on",987655621,"sara312@gmail.com",1));
		expected.add(new HomeOwner("sara","saravanan",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1990-03-12").getTime()),"on",2898677,"saranya1@gmail.com",1));
		
		
		//list of actual data
		List<HomeOwner> actual = home.getAllHomeOwner();
		
		
		for(HomeOwner expected1:expected) {
		
			for(HomeOwner actual1:actual) {
				if(expected1.getEmail_id().equals(actual1.getEmail_id())){
					assertThat(expected,is(actual));
				
				}
			}
		
		}
	
	
	}
	
	
	@Test
	public void  getHomeOwnerByHomeOwnerIdSuccessTest() throws SQLException, IOException, ParseException {
		
		
		HomeOwner expected =new HomeOwner("saranya","gopal",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1990-03-12").getTime()),"on",987654321,"sara3@gmail.com",1);
		HomeOwner home1 = home.getHomeOwnerByHomeOwnerId(expected.getHomeOwner_id());
	
		assertNotNull("valid data",home1);
		assertEquals("valid data",expected,home1);
		
	}
	@Test
	public void  getHomeOwnerByHomeOwnerIdFailTest() throws SQLException, IOException, ParseException 
	{

		HomeOwner expected =new HomeOwner("sarany","gopal",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1990-04-12").getTime()),"on",987654321,"sara567@gmail.com",1);
		HomeOwner homefalse = home.getHomeOwnerByHomeOwnerId(expected.getHomeOwner_id());
	
		assertNull("Invalid data",homefalse);
		assertNotEquals("Invalid data",expected,homefalse);
	}
	
	
	
	
	
	@Test
	public void  RegisterHomeOwnerSuccessTest() throws ParseException, SQLException, IOException 
	{
		
		HomeOwner testData =new HomeOwner("siddhu","saran",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2014-03-12").getTime()),"on",98767889,"siddhu123@gmail.com",1);
		int homeOwnerId =home.registerHomeOwner(testData);
		assertThat(homeOwnerId, is(not(-1)));
		
		//to check the homeOwner got registered
		HomeOwner testing = home.getHomeOwnerByHomeOwnerId(homeOwnerId);
		assertNotNull("valid data",testing);
		
	}
	@Test//Home Owner first name  null(all fields are mandatory)
	public void  RegisterHomeOwnerFailTest() throws ParseException, SQLException, IOException 
	{
		
		
		HomeOwner testData =new HomeOwner(null,"saran",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2014-03-12").getTime()),"on",98767889,"siddhu123@gmail.com",1);
		int homeOwnerId =home.registerHomeOwner(testData);
		assertThat(homeOwnerId, is(-1));
		
		//to check the homeOwner got registered
		HomeOwner testing = home.getHomeOwnerByHomeOwnerId(homeOwnerId);
		assertNull("valid data",testing);
		
	}
	@Test//email Id should be unique
	public void  RegisterHomeOwnerFailTest2() throws ParseException, SQLException, IOException 
	{
		HomeOwner testData =new HomeOwner("aru","saran",new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2014-03-12").getTime()),"on",98767889,"siddhu123@gmail.com",1);
		int homeOwnerId =home.registerHomeOwner(testData);
		assertThat(homeOwnerId, is(-1));
		
		//to check the homeOwner got registered
		HomeOwner testing = home.getHomeOwnerByHomeOwnerId(homeOwnerId);
		assertNull("valid data",testing);
		
	}
	

}
