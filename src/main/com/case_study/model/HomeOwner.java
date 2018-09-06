package com.case_study.model;

import java.sql.Date;

public class HomeOwner {
	
	 private int homeOwner_id;
     private String first_name;
     private String last_name;
     private Date birth_date;
     private String retired;
     private int ssn;
     private String email_id;
     private int user_id;
     
     public HomeOwner()
     {
    	 this.homeOwner_id=0;
    	 this.first_name="";
    	 this.last_name="";
    	 this.birth_date=null;
    	 this.retired="";
    	 this.ssn=0;
    	 this.email_id=null;
    	 this.user_id=0;
    	 
     }
     
	
	public HomeOwner(String first_name, String last_name, Date birth_date, String retired, int ssn,
			String email_id,int user_id) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.birth_date = birth_date;
		this.retired = retired;
		this.ssn = ssn;
		this.email_id = email_id;
		this.user_id=user_id;
	}
	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getHomeOwner_id() {
		return homeOwner_id;
	}
	public void setHomeOwner_id(int homeOwner_id) {
		this.homeOwner_id = homeOwner_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getRetired() {
		return retired;
	}
	public void setRetired(String retired) {
		this.retired = retired;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
     
     
     
}
