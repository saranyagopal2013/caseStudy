package com.case_study.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.case_study.model.Quote_Details;
import com.case_study.model.User_Location;
import com.case_study.model.policy_confirmation;



public class QuoteDetailsDao {

		

		// get new Quote Details information
		public int registerQuoteDetails(Quote_Details quote) throws IOException, SQLException
		{
			 Connection conn=null;
			  PreparedStatement st=null;
			  ResultSet rs=null;
			  int ID=-1;
			  try {  
				  
				 
		        String query="INSERT INTO Quote_Details(quote_id,monthly_preminum,dwelling_coverage,detached_structure,personal_property,living_expense,medical_expense,deductible,user_location_location_id) VALUES(?,?,?,?,?,?,?,?,?)";// ? denotes no of columns
				
				String[] COL= {"quote_id"};
				 MySqlConnection mysql=new MySqlConnection();
				 conn=mysql.getConnection();
				 st=conn.prepareStatement(query,COL);
				 // set string num 123 denotes insert statement value
			 st.setInt(1,quote.getQuote_id());
				 st.setDouble(2,quote.getMonthly_preminum());
				 st.setDouble(3,quote.getDwelling_coverage());
				 st.setDouble(4,quote.getDetached_structure());
				 st.setDouble(5,quote.getPersonal_property());
				 st.setDouble(6,quote.getLiving_expense());
				 st.setDouble(7,quote.getMedical_expense());
				 st.setDouble(8,quote.getDeductible());
				 st.setInt(9,quote.getUser_location_location_id());
				 
				 
				 st.executeUpdate();
				  rs=st.getGeneratedKeys();
				  if(rs!=null && rs.next())
				  {   // i denotes column name in table
					  ID=rs.getInt(1);
				  }
				  System.out.println(ID);
				  }
			  catch(ClassNotFoundException | SQLException e)
				{
						e.printStackTrace();
					}
			  finally
				{
					if(rs!=null)
					{
						rs.close();
					}
					if(st!=null)
					{
						st.close();
					}
					if(conn!=null)
					{
						conn.close();
					}
				}
				
			return ID;
		}
		
		
		// to get a particular Quote details based on USER ID
		public HashMap<Integer,User_Location> getQuoteDetailsByUserId(int userId) throws SQLException, IOException {
			 Connection conn=null;
			  PreparedStatement st=null;
			  ResultSet rs=null;
			  
			 Quote_Details quote=null;
			 User_Location location=null;
			  HashMap<Integer,User_Location> l = new HashMap<Integer,User_Location>();
			
			  String query = "SELECT Q.quote_id,L.residence_type,L.address_line_1,L.city,L.state,L.zipcode,L.residence_use FROM quote_details Q " + 
		                "JOIN user_location L " + 
		                "ON Q.user_location_location_id = L.location_id " + 
		                "JOIN (select *from user where user_id ="+userId+")U " + 
		                "ON L.user_user_id =U.user_id";
			    
			 

				try {
					 MySqlConnection mysql=new MySqlConnection();
					conn=mysql.getConnection();
					st=conn.prepareStatement(query);
					//st.setInt(1,userId);
					rs=st.executeQuery();
					
					quote=new Quote_Details();
					location=new User_Location();
					
					 while(rs.next())
					{
						 
						 quote.setQuote_id(rs.getInt(1));
						 location.setResidence_Type(rs.getString(2));
						 location.setAddress_line_1(rs.getString(3));
						 location.setCity(rs.getString(4));
						 location.setState(rs.getString(5));
						 location.setZipcode(rs.getInt(6));
						 location.setResidence_use(rs.getString(7));
						l.put(quote.getQuote_id(), location) ;
						 
						 
						 
//						 
					}
					
				}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(rs!=null)
					{
						rs.close();
					}
					if(st!=null)
					{
						st.close();
					}
					if(conn!=null)
					{
						conn.close();
					}
				}
				return l;
			}
	
		
		
	
	}



