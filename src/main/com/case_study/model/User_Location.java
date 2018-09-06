package com.case_study.model;

public class User_Location {
	          private int location_id;
	          private String residence_Type;
	          private String address_line_1;
	          private String address_line_2;
	          private String state;
	          private String city;
	          private int zipcode;
	          private String residence_use;
	          private int user_id;
	          
	          
	          public User_Location()
	          {
	        	  this.location_id=0;
	        	  this.residence_Type="";
	        	  this.address_line_1="";
	        	  this.state="";
	        	  this.city="";
	        	  this.zipcode=0;
	        	  this.residence_use="";
	        	  this.user_id=0;
	          }
	          
	          public User_Location(String residence_Type, String address_line_1, String address_line_2,
					String state, String city, int zipcode,String residence_use,int user_id) {
				super();
				
				this.residence_Type = residence_Type;
				this.address_line_1 = address_line_1;
				this.address_line_2 = address_line_2;
				this.state = state;
				this.city = city;
				this.zipcode = zipcode;
				this.residence_use=residence_use;
				this.user_id=user_id;
			}
	          
	          
			public int getUser_id() {
				return user_id;
			}

			public void setUser_id(int user_id) {
				this.user_id = user_id;
			}

			public int getLocation_id() {
				return location_id;
			}
			public void setLocation_id(int location_id) {
				this.location_id = location_id;
			}
			public String getResidence_Type() {
				return residence_Type;
			}
			public void setResidence_Type(String residence_Type) {
				this.residence_Type = residence_Type;
			}
			public String getAddress_line_1() {
				return address_line_1;
			}
			public void setAddress_line_1(String address_line_1) {
				this.address_line_1 = address_line_1;
			}
			public String getAddress_line_2() {
				return address_line_2;
			}
			public void setAddress_line_2(String address_line_2) {
				this.address_line_2 = address_line_2;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public int getZipcode() {
				return zipcode;
			}
			public void setZipcode(int zipcode) {
				this.zipcode = zipcode;
			}

			public String getResidence_use() {
				return residence_use;
			}

			public void setResidence_use(String residence_use) {
				this.residence_use = residence_use;
			}
			
	          
	          
	          

}
