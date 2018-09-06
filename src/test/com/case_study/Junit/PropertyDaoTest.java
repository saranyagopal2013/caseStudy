package com.case_study.Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import com.case_study.dao.PropertyDetailsDao;
import com.case_study.model.Property_Details;

import junit.framework.Assert;

public class PropertyDaoTest 
{
	PropertyDetailsDao property = new PropertyDetailsDao();
	
	@Test
	public void GetAllPropertiesSucccessTest() throws SQLException, IOException 
	{
		List<Property_Details> expected = new ArrayList<Property_Details>();
		
		expected.add(new Property_Details(250000.0,2008,4000,"singlestorey","concrete","Attached",2,2,false,24));
		expected.add(new Property_Details(250000.0,2016,2000,"singlestorey","concrete","Attached",1,1,false,51));
		
		List<Property_Details> actual= property.getAllProperty();
		
	
		for(Property_Details expected1:expected) {
			
			for(Property_Details actual1:actual) {
				if(expected1.getProperty_id()==actual1.getProperty_id()) {
				
					assertEquals(expected,actual);
				}
			}
			
		}
	
	}
	@Test
	public void GetPropertiesFailTest() throws SQLException, IOException 
	{
		List<Property_Details> expected = new ArrayList<Property_Details>();
		
		expected.add(new Property_Details(250000.0,2016,4000,"singlestorey","concrete","Attached",2,2,false,24));
		expected.add(new Property_Details(250000.0,2016,3500,"singlestorey","concrete","Attached",3,1,false,51));
		
		List<Property_Details> actual= property.getAllProperty();
		
		
		for(Property_Details expected1:expected) {
			for(Property_Details actual1:actual) {
				if(expected1.getProperty_id()==actual1.getProperty_id()) {
				assertThat(expected1.getProperty_market_value(),is(actual1.getProperty_market_value()));
				assertTrue(expected1.getProperty_roof_material().equals(actual1.getProperty_roof_material()));
				}
			}
		}
	
	}
	
	
	@Test
	public void GetPropertyByPropertyIdSuccess() throws SQLException, IOException 
	{
		
		Property_Details expected = new Property_Details(50000.0,2003,3000,"singlestorey","concrete","Attached",1,1,false,27);

		Property_Details actual =property.getPropertyDetailsrByPropertyId(expected.getProperty_id());
		
		assertThat(expected.getProperty_market_value(),is(actual.getProperty_market_value()));
		assertTrue(expected.getProperty_garage_type().equals(actual.getProperty_garage_type()));
	}
	
	
	@Test
	public void GetPropertyByPropertyIdFailTest() throws SQLException, IOException 
	
	{
		
		
		Property_Details expected = new Property_Details(50000.0,2014,3000,"singlestorey","concrete","Attached",1,1,true,27);

		Property_Details actual =property.getPropertyDetailsrByPropertyId(1);
		
		assertThat(expected.getLocation_id(),is(not(actual.getLocation_id())));
		assertFalse(expected.getProperty_garage_type().equals(actual.getProperty_garage_type()));

	}
	

	@Test
	public void RegisterPropertySucessTest() throws SQLException, IOException 
	{  
		
		Property_Details expected = new Property_Details(50000.0,2003,3000,"singlestorey","concrete","Attached",1,1,false,27);
		int propertyId=property.registerPropertyDetails(expected);
	
		assertThat(propertyId, is(not(-1)));
		
	}
	
	
	
	@Test
	public void RegisterPropertyFailTest() throws SQLException, IOException 
	
	{
		Property_Details expected = new Property_Details(0.0,2003,3000,"singlestorey","concrete","Attached",1,1,false,27);
		int propertyId=property.registerPropertyDetails(expected);
	
		assertThat(propertyId, is(-1));
	}
	
	@Test
	public void RegisterPropertyFailTest2() throws SQLException, IOException {
		Property_Details expected = new Property_Details(35000.0,2003,3000,null,"concrete","Attached",1,1,false,27);
		int propertyId=property.registerPropertyDetails(expected);
	
		assertThat(propertyId, is(-1));
	}
	
	
}
