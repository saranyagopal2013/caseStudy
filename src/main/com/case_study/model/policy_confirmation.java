package com.case_study.model;

import java.util.Date;

public class policy_confirmation {
	
	private int policy_id;
	private Date policy_effective_date;
	private Date policy_end_date;
	private int policy_term;
	private String policy_status;
	private int quote_details_quote_id;
	
	
	public policy_confirmation()
	{
		this.policy_id=0;
		this.policy_effective_date=null;
		this.policy_end_date=null;
		this.policy_term=1;
		this.policy_status="Active";
		this.quote_details_quote_id=0;
	}
	
	public policy_confirmation(int policy_id, Date policy_effective_date, Date policy_end_date, int policy_term,
			String policy_status,int quote_details_quote_id) {
		super();
		this.policy_id = policy_id;
		this.policy_effective_date = policy_effective_date;
		this.policy_end_date = policy_end_date;
		this.policy_term =1;
		this.policy_status ="Active";
		this.quote_details_quote_id=quote_details_quote_id;
	}
	
	public policy_confirmation(Date policy_effective_date, Date policy_end_date,int quote_details_quote_id) {
		super();
		this.policy_effective_date = policy_effective_date;
		this.policy_end_date = policy_end_date;
		this.policy_term =1;
		this.policy_status ="Active";
		this.quote_details_quote_id=quote_details_quote_id;
		
	}
	public int getQuote_details_quote_id() {
		return quote_details_quote_id;
	}

	public void setQuote_details_quote_id(int quote_details_quote_id) {
		this.quote_details_quote_id = quote_details_quote_id;
	}

	public int getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}
	public Date getPolicy_effective_date() {
		return policy_effective_date;
	}
	public void setPolicy_effective_date(Date policy_effective_date) {
		this.policy_effective_date = policy_effective_date;
	}
	public Date getPolicy_end_date() {
		return policy_end_date;
	}
	public void setPolicy_end_date(Date policy_end_date) {
		this.policy_end_date = policy_end_date;
	}
	public int getPolicy_term() {
		return policy_term;
	}
	public void setPolicy_term(int policy_term) {
		this.policy_term = policy_term;
	}
	public String getPolicy_status() {
		return policy_status;
	}
	public void setPolicy_status(String policy_status) {
		this.policy_status = policy_status;
	}
	
	

}
