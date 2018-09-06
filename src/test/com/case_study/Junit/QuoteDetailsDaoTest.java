package com.case_study.Junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import org.junit.Test;

import com.case_study.dao.QuoteDetailsDao;
import com.case_study.model.Quote_Details;
import com.case_study.model.User_Location;

public class QuoteDetailsDaoTest 
{
	QuoteDetailsDao quote=new QuoteDetailsDao();
	
	
	@Test
	public void RegisterQuoteDetailsSuccessTest() throws IOException, SQLException
	{
		Quote_Details expected=new Quote_Details(33, 60,156500,15650,93900,31300,5000,250,38);
		int quoteId=quote.registerQuoteDetails(expected);
		assertThat(quoteId, is(not(-1)));
		

	}
	
	@Test// all fields are mandatory
	public void RegisterQuoteDetailsFailTest() throws IOException, SQLException
	{
		Quote_Details expected=new Quote_Details(34, 60,0,15650,93900,31300,5000,250,38);
		int quoteId=quote.registerQuoteDetails(expected);
		assertThat(quoteId, is(not(-1)));
		

	}
	
	@Test
	public void GetQuoteDetailsByUserIdSuccessTest() throws ParseException, SQLException, IOException
	{
		Quote_Details expected=new Quote_Details(31, 60,156500,15650,93900,31300,5000,250,38);
		HashMap<Integer,User_Location> actual =quote.getQuoteDetailsByUserId(1);
		
		assertTrue(actual.containsKey(expected.getQuote_id()));//assert that we have the correct key
		
	}
	@Test
	public void GetQuoteDetailsByUserIdFailTest() throws ParseException, SQLException, IOException
	{
		Quote_Details expected=new Quote_Details(25, 60,156500,15650,93900,31300,5000,250,38);
		HashMap<Integer,User_Location> actual =quote.getQuoteDetailsByUserId(1);
		
		assertFalse(actual.containsKey(expected.getQuote_id()));//assert that we have the correct key
		
	}
	
	
		
}
