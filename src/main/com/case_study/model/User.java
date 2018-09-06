package com.case_study.model;

public class User{
        
       private int user_id;
       private String user_name;
       private String password;
       private String admin_role;
      
       
       public User()
       {
    	   this.user_id=0;
    	   this.user_name="";
    	   this.password="";
    	   this.admin_role="user";
       }
       
	public User(int user_id, String user_name, String password, String admin_role) 
	{
		this();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.admin_role = admin_role;
	}
	public User(String user_name, String password) 
	{
		this();
		this.user_name =user_name;
		this.password = password;
		//this.admin_role="user";
	
	}
	public User(User u)
	{
		this.user_id = u.user_id;
		this.user_name =u.user_name;
		this.password =u.password;
		this.admin_role = u.admin_role;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdmin_role() {
		return admin_role;
	}
	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}

       
}
