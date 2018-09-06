package com.case_study.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.case_study.dao.LocationDao;
import com.case_study.model.User_Location;

public class User_LocationBo 
{
	public int registerLocation(User_Location loc) throws IOException, SQLException
	{
		LocationDao location=new LocationDao();
		int locationId=location.registerLocation(loc);
			return locationId;
}
	
	public List<User_Location> getLocationByUserId(int userId) throws SQLException, IOException 
	{
		LocationDao location=new LocationDao();
		List<User_Location> loc=location.getLocationByUserId(userId);
		return loc;
	
	
	}
	
	
}