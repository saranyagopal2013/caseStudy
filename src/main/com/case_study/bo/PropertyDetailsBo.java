package com.case_study.bo;

import java.io.IOException;
import java.sql.SQLException;


import com.case_study.dao.PropertyDetailsDao;
import com.case_study.model.Property_Details;

public class PropertyDetailsBo {
	public int registerPropertyDetails(Property_Details property) throws IOException, SQLException
	{
		PropertyDetailsDao propertyDao=new PropertyDetailsDao();
		int propertyId=propertyDao.registerPropertyDetails(property);
			return propertyId;

}

}
