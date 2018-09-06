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
import com.case_study.model.Property_Details;


public class PropertyDetailsDao {
	

	// get new PropertyDetails information
	public int registerPropertyDetails(Property_Details property) throws IOException, SQLException
	{
		 Connection conn=null;
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  int ID=-1;
		  try {  
			 
	        String query="INSERT INTO property_details(property_id,property_market_value,property_year_built,property_square_footage,property_dwelling_style,property_roof_material,property_garage_type,property_number_of_full_bath,property_number_of_half_bath,property_swimming_pool,user_location_location_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";// ? denotes no of columns
			
			String[] COL= {"property_id"};
			 MySqlConnection mysql=new MySqlConnection();
			 conn=mysql.getConnection();
			 st=conn.prepareStatement(query,COL);
			 // set string num 123 denotes insert statement value
			 st.setInt(1,property.getProperty_id());
			 st.setDouble(2,property.getProperty_market_value());
			 st.setInt(3,property.getProperty_year_built());
			 st.setInt(4,property.getProperty_square_footage());
			 st.setString(5,property.getProperty_dwelling_style());
			 st.setString(6,property.getProperty_roof_material());
			 st.setString(7,property.getProperty_garage_type());
			 st.setInt(8,property.getProperty_number_of_full_bath());
			 st.setInt(9,property.getProperty_number_of_half_bath());
			 st.setBoolean(10,property.getProperty_swimming_pool());
			 st.setInt(11,property.getLocation_id());
			 
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
////to get a particular property id
	public Property_Details getPropertyDetailsrByPropertyId(int propertyId) throws SQLException, IOException {
		 Connection conn=null;
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  Property_Details property=null;
		  
		  String query="SELECT * FROM property_details where property_id= ?";
		  MySqlConnection mysql=new MySqlConnection();
		 

			try {
				
				conn=mysql.getConnection();
				st=conn.prepareStatement(query);
				st.setInt(1,propertyId);
				rs=st.executeQuery();
				
				   property=new Property_Details();
				 if(rs.next())
				{
				  property.setProperty_id(rs.getInt(1));
				  property.setProperty_market_value(rs.getDouble(2));
				  property.setProperty_year_built(rs.getInt(3));
				  property.setProperty_square_footage(rs.getInt(4));
				  property.setProperty_dwelling_style(rs.getString(5));
				  property.setProperty_roof_material(rs.getString(6));
				  property.setProperty_garage_type(rs.getString(7));
				  property.setProperty_number_of_full_bath(rs.getInt(8));
				  property.setProperty_number_of_half_bath(rs.getInt(9));
				  property.setProperty_swimming_pool(rs.getBoolean(10));
				  property.setLocation_id(rs.getInt(11));
				  
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
			return property;
		}
	
	//get all Property details
			public  List<Property_Details> getAllProperty() throws SQLException, IOException {
				 Connection conn=null;
				  Statement st=null;
				  ResultSet rs=null;
				 List<Property_Details> allProperty=null;
				 

					try {
						MySqlConnection mysql=new MySqlConnection();
						conn=mysql.getConnection();
						st=conn.createStatement();
						String query="SELECT * FROM property_details";
						rs=st.executeQuery(query);
						allProperty=new ArrayList<Property_Details>();
						
						while(rs.next())
						{	  Property_Details property=new Property_Details();
							  property.setProperty_id(rs.getInt(1));
							  property.setProperty_market_value(rs.getDouble(2));
							  property.setProperty_year_built(rs.getInt(3));
							  property.setProperty_square_footage(rs.getInt(4));
							  property.setProperty_dwelling_style(rs.getString(5));
							  property.setProperty_roof_material(rs.getString(6));
							  property.setProperty_garage_type(rs.getString(7));
							  property.setProperty_number_of_full_bath(rs.getInt(8));
							  property.setProperty_number_of_half_bath(rs.getInt(9));
							  property.setProperty_swimming_pool(rs.getBoolean(10));
							  property.setLocation_id(rs.getInt(11));
							
							allProperty.add(property);
						
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
					return allProperty;
				}
}
