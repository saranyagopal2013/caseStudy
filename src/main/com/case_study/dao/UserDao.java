package com.case_study.dao;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.case_study.model.User;



public class UserDao {
	
	
	
	//******************Get all user ************************
	
	public  List<User> getAllUser() throws SQLException, IOException {
	 Connection conn=null;
	  Statement st=null;
	  ResultSet rs=null;
	 List<User> allUser=null;
	 

		try {
			MySqlConnection mysql=new MySqlConnection();
			conn=mysql.getConnection();
			st=conn.createStatement();
			String query="SELECT * FROM user";
			rs=st.executeQuery(query);
			allUser=new ArrayList<User>();
			
			while(rs.next())
			{
				User user=new User();
				user.setUser_id(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAdmin_role(rs.getString(4));
				allUser.add(user);
				
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
		return allUser;
	}
	
	
	
	//*******************Register new user******************************
	
	
	public int registerUser(User us) throws IOException, SQLException
	{
		 Connection conn=null;
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  int ID=-1;
		  try {  
	        String query="INSERT INTO user(user_name,password,admin_role) VALUES(?,?,?)";// ? denotes no of columns
			
			String[] COL= {"user_id"};
			 MySqlConnection mysql=new MySqlConnection();
			 conn=mysql.getConnection();
			 st=conn.prepareStatement(query,COL);
			 // set string num 123 denotes insert statement value
			st.setString(1,us.getUser_name());	
			st.setString(2, us.getPassword());
			st.setString(3, us.getAdmin_role());
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
	
	//*************Login Customer using username and password***********************************
		public User loginUser(String user_name,String password) {
		    Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet result = null;
		    User user = new User();
		    
		    String SAVE = "SELECT * FROM user WHERE user_name =? AND password=?";
		    MySqlConnection mysql = new MySqlConnection();
		    
		    try
		    {
		        conn = mysql.getConnection();
		        stmt = conn.prepareStatement(SAVE);
		        stmt.setString(1,user_name);
		        stmt.setString(2,password);
		        
		        result = stmt.executeQuery();
		        if (result.next()) {
		        	user.setUser_id(result.getInt(1));
		        	user.setUser_name(result.getString(2));
		        	user.setPassword(result.getString(3));
		        	user.setAdmin_role(result.getString(4));
		        }
		    }
		    catch (ClassNotFoundException | IOException | SQLException e)
		    {
		        e.printStackTrace();
		    }
		    return user;
		}
		
	//*************Remove the particular user using user object***********************************
	
	public int removeUser(User us) throws IOException, SQLException
	{
		 Connection conn=null;
		  PreparedStatement st=null;
		  
	
		  int result=-1;
		  try {  
	        String query="DELETE FROM user WHERE user_name= ?";// ? denotes no of columns
			
			MySqlConnection mysql=new MySqlConnection();
			 conn=mysql.getConnection();
			 st=conn.prepareStatement(query);
			 st.setString(1,us.getUser_name());
			 result=st.executeUpdate();
			
			 
			  }
		  catch(ClassNotFoundException | SQLException e)
			{
					e.printStackTrace();
				}
		  finally
			{
				
				if(st!=null)
				{
					st.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}
			
		return result;
	}
	
	//*********Get a particular User Details Using userName****************
	
	public User getUserByUserName(String name) throws SQLException, IOException {
		 Connection conn=null;
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  User User=null;
		  
		  String query="SELECT * FROM user where user_name= ?";
		  MySqlConnection mysql=new MySqlConnection();
		 

			try {
				
				conn=mysql.getConnection();
				st=conn.prepareStatement(query);
				st.setString(1,name);
				rs=st.executeQuery();
				
				  User=new User();
				 if(rs.next())
				{
				   
					User.setUser_id(rs.getInt(1));
					User.setUser_name(rs.getString(2));
					User.setPassword(rs.getString(3));
					User.setAdmin_role(rs.getString(4));
					
					
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
			return User;
		}
	
	
	


	
}
