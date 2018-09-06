package com.case_study.model;

public class Property_Details {
	 private int property_id;
     private Double property_market_value;
     private int property_year_built;
     private int property_square_footage;
     private String property_dwelling_style;
     private String property_roof_material;
     private String property_garage_type;
     private int property_number_of_full_bath;
     private int property_number_of_half_bath;
     private boolean property_swimming_pool;
     
     private int location_id;
     
     
     public Property_Details()
     {
    	 this.property_id=0;
    	 this.property_market_value=0.0;
    	 this.property_year_built=0;
    	 this.property_square_footage=0;
    	 this.property_dwelling_style="";
    	 this.property_roof_material="";
    	 this.property_garage_type="";
    	 this.property_number_of_full_bath=0;
    	 this.property_number_of_half_bath=0;
    	 this.property_swimming_pool=false;
    	 this.location_id=0;
    	 
     }
     
     
     public Property_Details(int property_id, Double property_markt_value, int property_year_built,int property_square_footage,
			String property_dwelling_style, String property_roof_material, String property_garage_type,
			int property_number_of_full_bath, int property_number_of_half_bath, boolean property_swimming_pool) {
		super();
		this.property_id = property_id;
		this.property_market_value = property_markt_value;
		this.property_year_built = property_year_built;
		this.property_square_footage=property_square_footage;
		this.property_dwelling_style = property_dwelling_style;
		this.property_roof_material = property_roof_material;
		this.property_garage_type = property_garage_type;
		this.property_number_of_full_bath = property_number_of_full_bath;
		this.property_number_of_half_bath = property_number_of_half_bath;
		this.property_swimming_pool = property_swimming_pool;
	}
	public Property_Details(Double property_markt_value, int property_year_built,int property_square_footage,
			String property_dwelling_style, String property_roof_material, String property_garage_type,
			int property_number_of_full_bath, int property_number_of_half_bath, boolean property_swimming_pool,int location_id) {
		super();
		
		this.property_market_value = property_markt_value;
		this.property_year_built = property_year_built;
		this.property_square_footage=property_square_footage;
		this.property_dwelling_style = property_dwelling_style;
		this.property_roof_material = property_roof_material;
		this.property_garage_type = property_garage_type;
		this.property_number_of_full_bath = property_number_of_full_bath;
		this.property_number_of_half_bath = property_number_of_half_bath;
		this.property_swimming_pool = property_swimming_pool;
		this.location_id=location_id;
	}
	
	
	
	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public Double getProperty_market_value() {
		return property_market_value;
	}
	public void setProperty_market_value(Double property_market_value) {
		this.property_market_value = property_market_value;
	}
	public int getProperty_year_built() {
		return property_year_built;
	}
	public void setProperty_year_built(int property_year_built) {
		this.property_year_built = property_year_built;
	}
	public int getProperty_square_footage() {
		return property_square_footage;
	}
public void setProperty_square_footage(int property_square_footage) {
		this.property_square_footage = property_square_footage;
	}


public String getProperty_dwelling_style() {
		return property_dwelling_style;
	}
	public void setProperty_dwelling_style(String property_dwelling_style) {
		this.property_dwelling_style = property_dwelling_style;
	}
	public String getProperty_roof_material() {
		return property_roof_material;
	}
	public void setProperty_roof_material(String property_roof_material) {
		this.property_roof_material = property_roof_material;
	}
	public String getProperty_garage_type() {
		return property_garage_type;
	}
	public void setProperty_garage_type(String property_garage_type) {
		this.property_garage_type = property_garage_type;
	}
	public int getProperty_number_of_full_bath() {
		return property_number_of_full_bath;
	}
	public void setProperty_number_of_full_bath(int property_number_of_full_bath) {
		this.property_number_of_full_bath = property_number_of_full_bath;
	}
	public int getProperty_number_of_half_bath() {
		return property_number_of_half_bath;
	}
	public void setProperty_number_of_half_bath(int property_number_of_half_bath) {
		this.property_number_of_half_bath = property_number_of_half_bath;
	}
	public boolean getProperty_swimming_pool() {
		return property_swimming_pool;
	}
	public void setProperty_swimming_pool(boolean property_swimming_pool) {
		this.property_swimming_pool = property_swimming_pool;
	}
     
     

}
