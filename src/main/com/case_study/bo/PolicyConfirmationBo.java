package com.case_study.bo;

import java.io.IOException;
import java.sql.SQLException;

import com.case_study.dao.PolicyConfirmationDao;
import com.case_study.model.policy_confirmation;

public class PolicyConfirmationBo {
	
	public int registerPolicy(policy_confirmation policy) throws IOException, SQLException
	{
		PolicyConfirmationDao policyDao=new PolicyConfirmationDao();
		int policyId=policyDao.registerPolicy(policy);
			return policyId;

}
	public policy_confirmation getPolicyDetailsrByUserId(int userId) throws SQLException, IOException {
		PolicyConfirmationDao policyDao=new PolicyConfirmationDao();
		policy_confirmation policy =policyDao.getPolicyDetailsrByUserId(userId);
		return policy;

}
	
	public void UpdatePolicy(policy_confirmation p) throws SQLException {
		
		PolicyConfirmationDao policyDao=new PolicyConfirmationDao();
	     policyDao.UpdatePolicy(p);
		
	}
}