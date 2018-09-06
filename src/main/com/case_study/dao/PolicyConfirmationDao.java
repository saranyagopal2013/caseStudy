package com.case_study.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.case_study.model.Property_Details;
import com.case_study.model.Quote_Details;
import com.case_study.model.policy_confirmation;

public class PolicyConfirmationDao {
	
	public int registerPolicy(policy_confirmation policy) throws IOException, SQLException
	{
		 Connection conn=null;
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  int ID=-1;
		  try {  
			 
	        String query="INSERT INTO policy_confirmation(policy_id,policy_effective_date,policy_end_date,policy_term,policy_status,quote_details_quote_id) VALUES(?,?,?,?,?,?)";// ? denotes no of columns
			
			String[] COL= {"policy_id"};
			 MySqlConnection mysql=new MySqlConnection();
			 conn=mysql.getConnection();
			 st=conn.prepareStatement(query,COL);
			 // set string num 123 denotes insert statement value
			 st.setInt(1,policy.getPolicy_id());
			 st.setDate(2,(java.sql.Date) policy.getPolicy_effective_date());
			 st.setDate(3,(java.sql.Date) policy.getPolicy_end_date());
	         st.setInt(4,policy.getPolicy_term());
			 st.setString(5,policy.getPolicy_status());
			 st.setInt(6,policy.getQuote_details_quote_id());
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
	
	
////to get a particular quote details using location id
		public policy_confirmation getPolicyDetailsrByUserId(int userId) throws SQLException, IOException {
			 Connection conn=null;
			  PreparedStatement st=null;
			  ResultSet rs=null;
			  
			 policy_confirmation policy=null;
			  
			
			  String query = "SELECT P.policy_id,P.policy_effective_date,P.policy_end_date,P.policy_term,P.policy_status,Q.quote_id FROM policy_confirmation P " + 
		                "JOIN quote_details Q " + 
		                "ON P.quote_details_quote_id = Q.quote_id " + 
		                "JOIN user_location L " + 
		                "ON L.location_id =Q.user_location_location_id " + 
		                "WHERE L.user_user_id =?";
			
			 

				try {
					 MySqlConnection mysql=new MySqlConnection();
					conn=mysql.getConnection();
					st=conn.prepareStatement(query);
					st.setInt(1,userId);
					rs=st.executeQuery();
					
					policy=new policy_confirmation();
					while(rs.next())
					{
						 
						 policy.setPolicy_id(rs.getInt(1));
						 policy.setPolicy_effective_date(rs.getDate(2));
						 policy.setPolicy_end_date(rs.getDate(3));
						 policy.setPolicy_term(rs.getInt(4));
						 policy.setPolicy_status(rs.getString(5));
						 policy.setQuote_details_quote_id(rs.getInt(6));
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
				return policy;
			}

//update the policy
		public void UpdatePolicy(policy_confirmation p) throws SQLException {
			
			Connection conn = null;
	        PreparedStatement stmt = null;
	        
	        String updatePolicy = "UPDATE policy_confirmation SET policy_status = '"+ p.getPolicy_status()+"' , policy_effective_date = date '"+p.getPolicy_effective_date()+ "' , policy_end_date= date '" +p.getPolicy_end_date()
	                + "' WHERE policy_id ="+p.getPolicy_id();
	        
	        try
	        {
	        	MySqlConnection connection = new MySqlConnection();
				conn = connection.getConnection();
	            stmt = conn.prepareStatement(updatePolicy);
	            stmt.executeUpdate();
	            
	        }
	        catch (ClassNotFoundException | IOException | SQLException e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        finally {
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
				 
			}
			
		}
}
