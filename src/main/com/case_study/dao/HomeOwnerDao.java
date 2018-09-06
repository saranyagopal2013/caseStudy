package com.case_study.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.case_study.model.HomeOwner;
import com.case_study.model.User_Location;

public class HomeOwnerDao {
	
	// get new HomeOwner information
	public int registerHomeOwner(HomeOwner owner) throws IOException, SQLException
	{
		 Connection conn=null;
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  int ID=-1;
		  try {  
				
	        String query="INSERT INTO homeowner(homeOwner_id,first_name,last_name,birth_date,retired,ssn,email_id,user_user_id) VALUES(?,?,?,?,?,?,?,?)";// ? denotes no of columns
			
			String[] COL= {"homeOwner_id"};
			 MySqlConnection mysql=new MySqlConnection();
			 conn=mysql.getConnection();
			 st=conn.prepareStatement(query,COL);
			 // set string num 123 denotes insert statement value
			 st.setInt(1,owner.getHomeOwner_id());
			 st.setString(2, owner.getFirst_name());
			 st.setString(3, owner.getLast_name());
			 st.setDate(4, owner.getBirth_date());
			 st.setString(5,owner.getRetired());
			 st.setInt(6,owner.getSsn());
			 st.setString(7,owner.getEmail_id());
			 st.setInt(8,owner.getUser_id());
			 
			
			
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
	
	
	//get all HomeOwner details
		public  List<HomeOwner> getAllHomeOwner() throws SQLException, IOException {
			 Connection conn=null;
			  Statement st=null;
			  ResultSet rs=null;
			 List<HomeOwner> allHome=null;
			 

				try {
					MySqlConnection mysql=new MySqlConnection();
					conn=mysql.getConnection();
					st=conn.createStatement();
					String query="SELECT * FROM homeowner";
					rs=st.executeQuery(query);
					allHome=new ArrayList<HomeOwner>();
					
					while(rs.next())
					{
						
						HomeOwner home=new HomeOwner();
						home.setHomeOwner_id(rs.getInt(1));
						home.setFirst_name(rs.getString(2));;
						home.setLast_name(rs.getString(3));
						home.setBirth_date(rs.getDate(4));
						home.setRetired(rs.getString(5));
						home.setSsn(rs.getInt(6));
						home.setEmail_id(rs.getString(7));
						home.setUser_id(rs.getInt(8));
						
						allHome.add(home);
					
					}
					conn.close();
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
				return allHome;
			}
////to get a particular homeowner id
	
	public HomeOwner getHomeOwnerByHomeOwnerId(int HomeOwnerId) throws SQLException, IOException {
		 Connection conn=null;
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  HomeOwner owner=null;
		  
		  String query="SELECT * FROM homeowner where homeowner_id= ?";
		  MySqlConnection mysql=new MySqlConnection();
		 

			try {
				
				conn=mysql.getConnection();
				st=conn.prepareStatement(query);
				st.setInt(1,HomeOwnerId);
				rs=st.executeQuery();
				
				   owner=new HomeOwner();
				 if(rs.next())
				{
				   owner.setHomeOwner_id(rs.getInt(1));
				   owner.setFirst_name(rs.getString(2));
				   owner.setLast_name(rs.getString(rs.getString(3)));
				   owner.setBirth_date(rs.getDate(4));
				   owner.setRetired(rs.getString(5));
				   owner.setSsn(rs.getInt(6));
				   owner.setEmail_id(rs.getString(7));
					
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
			return owner;
		}
}
