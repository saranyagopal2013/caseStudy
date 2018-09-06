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
import com.case_study.model.User_Location;

public class LocationDao 
{//register a new location
	public int registerLocation(User_Location location) throws IOException, SQLException
	{
		 Connection conn=null;
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  int ID=-1;
		  try {  
	        String query="INSERT INTO user_location(residence_type,address_line_1,address_line_2,state,city,zipcode,residence_use,user_user_id) VALUES(?,?,?,?,?,?,?,?)";// ? denotes no of columns
			
			String[] COL= {"location_id"};
			 MySqlConnection mysql=new MySqlConnection();
			 conn=mysql.getConnection();
			 st=conn.prepareStatement(query,COL);
			 // set string num 123 denotes insert statement value
			st.setString(1,location.getResidence_Type());	
			st.setString(2,location.getAddress_line_1());
			st.setString(3,location.getAddress_line_2());
			st.setString(4,location.getState());
			st.setString(5,location.getCity());
			st.setInt(6, location.getZipcode());
			st.setString(7,location.getResidence_use());
			st.setInt(8,location.getUser_id());
			
			st.executeUpdate();
			  rs=st.getGeneratedKeys();
			  if(rs!=null && rs.next())
			  {   // i denotes column name in table
				  ID=rs.getInt(1);
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
			
		return ID;
	}
	//get all location details
	public  List<User_Location> getAllLocation() throws SQLException, IOException {
		 Connection conn=null;
		  Statement st=null;
		  ResultSet rs=null;
		 List<User_Location> allLocation=null;
		 

			try {
				MySqlConnection mysql=new MySqlConnection();
				conn=mysql.getConnection();
				st=conn.createStatement();
				String query="SELECT * FROM user_location";
				rs=st.executeQuery(query);
				allLocation=new ArrayList<User_Location>();
				
				while(rs.next())
				{
					User_Location location=new User_Location();
					location.setLocation_id(rs.getInt(1));
					location.setResidence_Type(rs.getString(2));
					location.setAddress_line_1(rs.getString(3));
					location.setAddress_line_2(rs.getString(4));
					location.setState(rs.getString(5));
					location.setCity(rs.getString(6));
					location.setZipcode(rs.getInt(7));
					location.setResidence_use(rs.getString(8));
					allLocation.add(location);
				
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
			return allLocation;
		}
	
	//to get a particular location using user id
	public List<User_Location> getLocationByUserId(int userId) throws SQLException, IOException {
		 Connection conn=null;
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  User_Location location;
		  List<User_Location> loc=null;
		  
		  String query="SELECT * FROM user_location where user_user_id= ?";
		  MySqlConnection mysql=new MySqlConnection();
		 
			try {
				
				conn=mysql.getConnection();
				st=conn.prepareStatement(query);
				st.setInt(1,userId);
				rs=st.executeQuery();
				
				 
				 if(rs.next())
				{
					  
					 location=new User_Location();
					 location.setLocation_id(rs.getInt(1));
					 location.setResidence_Type(rs.getString(2));
					 location.setAddress_line_1(rs.getString(3));
					 location.setAddress_line_2(rs.getString(4));
					 location.setState(rs.getString(5));
					 location.setCity(rs.getString(6));
					 location.setZipcode(rs.getInt(7));
					 location.setResidence_use(rs.getString(8));
					 location.setUser_id(rs.getInt(9));
					 loc.add(location);
					
					
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
			return loc;
		}
	

}
