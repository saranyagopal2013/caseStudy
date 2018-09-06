package com.case_study.Junit;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.case_study.dao.PolicyConfirmationDao;
import com.case_study.model.policy_confirmation;

public class PolicyConfirmationDaoTest 
{
	
		PolicyConfirmationDao policy = new PolicyConfirmationDao();
		
		
		@Test
		public void GetPolicyByUserIdSuccessTest() throws ParseException, SQLException, IOException{
			
			policy_confirmation expected = new policy_confirmation(5,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),1,"Active",23);
		
			policy_confirmation actual =policy.getPolicyDetailsrByUserId(1);
			
			assertTrue(expected.getPolicy_status().equals(actual.getPolicy_status()));
			assertThat(expected.getPolicy_effective_date(),is(actual.getPolicy_effective_date()));
		}
		
		@Test
		public void GetPolicyByUserIdFailTest() throws ParseException, SQLException, IOException
		{
			policy_confirmation expected = new policy_confirmation(5,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-03-13").getTime()),new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),3,"Active",28);
			
			policy_confirmation actual =policy.getPolicyDetailsrByUserId(4);
			
			assertFalse(expected.getPolicy_status().equals(actual.getPolicy_status()));
			assertThat(expected.getPolicy_effective_date(),is(not(actual.getPolicy_effective_date())));
			
		}
		
		@Test
		public void UpdatePolicySuccessTest() throws ParseException, SQLException, IOException {
			//new policy sample data
			policy_confirmation expected = new policy_confirmation(5,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),1,"Active",23);
			
			policy.UpdatePolicy(expected);//update Policy
			
			policy_confirmation actual =policy.getPolicyDetailsrByUserId(1);
			//assert that the policy has been updated
		
			assertEquals(expected.getPolicy_status(),actual.getPolicy_status());
		}
		
		@Test
		public void UpdatePolicyFailTest() throws ParseException, SQLException, IOException {
			//new policy sample data
			policy_confirmation expected = new policy_confirmation(7,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),1,"Active",23);
			
			policy.UpdatePolicy(expected);//update Policy
			
			policy_confirmation actual =policy.getPolicyDetailsrByUserId(1);
			//assert that the policy has been updated
		
			assertNotEquals(expected.getPolicy_status(),actual.getPolicy_status());
			
			
			
		}
		@Test
		public void RegisterPolicySuccessTest() throws ParseException, SQLException, IOException 
		{
			policy_confirmation expected = new policy_confirmation(8,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-03-13").getTime()),new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),1,"Active",28);
			int propertyId = policy.registerPolicy(expected);
			assertThat(propertyId, is(not(-1)));
		}
		
		@Test// policyId null
		public void RegisterPolicyFailTest() throws ParseException, SQLException, IOException 
		{
			policy_confirmation expected = new policy_confirmation(0,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-03-13").getTime()),new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),1,"Active",28);
			int propertyId = policy.registerPolicy(expected);
			assertThat(propertyId, is(-1));
		}
		
		
		
		@Test//policy term 0(all fields are mandatory)
		public void RegisterPolicyFailTest1() throws ParseException, SQLException, IOException {
			
			policy_confirmation expected = new policy_confirmation(9,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-03-13").getTime()),new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse("2018-08-29").getTime()),0,"Active",28);
			int propertyId = policy.registerPolicy(expected);
			assertThat(propertyId, is(-1));
			
		}
		
		
}
