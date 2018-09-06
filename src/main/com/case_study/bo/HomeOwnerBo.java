package com.case_study.bo;

import java.io.IOException;
import java.sql.SQLException;
import com.case_study.dao.HomeOwnerDao;
import com.case_study.model.HomeOwner;

//adding comment
public class HomeOwnerBo {
	public int registerHomeOwner(HomeOwner owner) throws IOException, SQLException
	{
		HomeOwnerDao homeowner=new HomeOwnerDao();
		int homeOwnerId=homeowner.registerHomeOwner(owner);
			return homeOwnerId;

}
}
