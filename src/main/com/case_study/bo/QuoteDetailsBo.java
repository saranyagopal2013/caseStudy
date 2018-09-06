package com.case_study.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import com.case_study.dao.QuoteDetailsDao;
import com.case_study.model.Quote_Details;
import com.case_study.model.User_Location;

public class QuoteDetailsBo 
{
	public int registerQuoteDetails(Quote_Details quote) throws IOException, SQLException
	{
		QuoteDetailsDao dao=new QuoteDetailsDao();
		int quoteId=dao.registerQuoteDetails(quote);
		return quoteId;

}
	
	public HashMap<Integer,User_Location> getQuoteDetailsByUserId(int userId) throws SQLException, IOException 
	{
	
		QuoteDetailsDao dao=new QuoteDetailsDao();
		HashMap<Integer,User_Location> quoteMap=dao.getQuoteDetailsByUserId(userId);
		return quoteMap;
		
	
	}
}

