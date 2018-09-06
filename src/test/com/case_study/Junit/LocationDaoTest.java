package com.case_study.Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.case_study.dao.LocationDao;
import com.case_study.model.User_Location;

import junit.framework.Assert;

public class LocationDaoTest {
	
	LocationDao location = new LocationDao();
	@Test//
	public void  GetAllLocationSucessTest() throws SQLException, IOException {
		List<User_Location> expected = new ArrayList<User_Location>();//sample data list
		//add some sample data
		expected.add(new User_Location("singel","1234bold","mac arthuy","texasa","irving",75063,"Primary",2));
		expected.add(new User_Location("Townhouse","1054 south","ridge blvd","texas","irving",75064,"Primary",2));
		expected.add(new User_Location("singel","1234 bold","mac arthuy","texasa","irving",75063,"Primary",	2));
		
		//list of all stored data
		List<User_Location> actual =location.getAllLocation();
		
		
		for(User_Location expected1:expected) {
			
			for(User_Location actual1:actual) {
				if((expected1.getResidence_Type()).equals(actual1.getResidence_Type())){
					assertEquals(expected1.getState(),actual1.getState());
					
				}
			}
			
		}
	
	}
	
	@Test//
	public void  GetAllLocationFailTest() throws SQLException, IOException {
		List<User_Location> expected = new ArrayList<User_Location>();//sample data list
		//add some sample data
		expected.add(new User_Location("Townhouse","1234bold","mac arthuy","texasa","irving",75063,"Primary",2));
		expected.add(new User_Location("Townhouse","1054 south","ridge blvd","dallas","irving",75064,"Primary",2));
		expected.add(new User_Location("singel","1234 bold","mac arthuy","newYork","irving",75063,"Primary",	2));
		
		//list of all stored data
		List<User_Location> actual =location.getAllLocation();
		
		
		for(User_Location expected1:expected) {
			
			for(User_Location actual1:actual) {
				if((expected1.getResidence_Type()).equals(actual1.getResidence_Type())){
					assertEquals(expected1.getState(),actual1.getState());
					
				}
			}
			
		}
	
	}
	
	
	@Test
	public void  getLocationByUserIdSucessTest() throws SQLException, IOException
	{
		User_Location expected = new User_Location("singel","1234 bold","mac arthuy","texasa","irving",	75063,"Primary",2);
		List<User_Location> actual =location.getLocationByUserId(expected.getUser_id());
		assertTrue(actual.contains(expected.getAddress_line_1()));
		assertTrue(actual.contains(expected));
	}
	@Test
	public void  getLocationByUserIdFailTest() throws SQLException, IOException
	{
		User_Location expected = new User_Location("singel","1234 good","mac arthuy","mexico","irving",	75063,"Primary",2);
		List<User_Location> actual =location.getLocationByUserId(expected.getUser_id());
		assertTrue(actual.contains(expected.getAddress_line_1()));
		assertTrue(actual.contains(expected));
	}
	
	@Test
	public void  RegisterLocationSucessTest() throws SQLException, IOException {
		User_Location expected = new User_Location("singel","1813 north","maples shade","newjersey","edison",65234,"Primary",3);
		int locationId =location.registerLocation(expected);
		assertThat(locationId,is(not(-1)));
		
		
	}
	@Test//Location residence type is null
	public void  RegisterHomeOwnerFailTest1() throws SQLException, IOException 
	{
		User_Location expected = new User_Location(null,"1813 north","maples shade","newjersey","edison",65234,"Primary",3);
		int locationId =location.registerLocation(expected);
		assertThat(locationId,is((-1)));
		
	}
	@Test//State null
	public void  RegisterHomeOwnerFailTest2() throws SQLException, IOException 
	{
		User_Location expected = new User_Location("singel","1813 north",null,"newjersey","edison",65234,"Primary",3);
		int locationId =location.registerLocation(expected);
		assertThat(locationId,is((-1)));
		
	}
	@Test//foreign key is not valid
	public void  RegisterHomeOwnerFailTest3() throws SQLException, IOException 
	{
		User_Location expected = new User_Location("singel","1813 north","texas","newjersey","edison",65234,"Primary",0);
		int locationId =location.registerLocation(expected);
		assertThat(locationId,is((-1)));
		}
		
	
	
		
	}


