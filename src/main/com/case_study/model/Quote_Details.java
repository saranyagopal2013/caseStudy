package com.case_study.model;

public class Quote_Details 
{
	
	 private int quote_id;
     private double monthly_preminum;
     private double dwelling_coverage;
     private double detached_structure;
     private double personal_property;
     private double living_expense;
     private double medical_expense;
     private double deductible;
     private int user_location_location_id;
     
     public Quote_Details()
     {
    	 this.quote_id=0;
    	 this.monthly_preminum=0.0;
    	 this.dwelling_coverage=0.0;
    	 this.detached_structure=0.0;
    	 this.personal_property=0.0;
    	 this.living_expense=0.0;
    	 this.medical_expense=0.0;
    	 this.deductible=0.0;
    	 this.user_location_location_id=0;
     }
	public Quote_Details(int quote_id,double monthly_preminum,double dwelling_coverage, double detached_structure,
			double personal_property, double living_expense, double medical_expense, double deductible,int user_location_location_id) 
	{
		super();
		this.quote_id = quote_id;
		this.monthly_preminum = monthly_preminum;
		this.dwelling_coverage = dwelling_coverage;
		this.detached_structure = detached_structure;
		this.personal_property = personal_property;
		this.living_expense = living_expense;
		this.medical_expense = medical_expense;
		this.deductible = deductible;
		 this.user_location_location_id=user_location_location_id;
	}
	
	public Quote_Details( double monthly_preminum, double dwelling_coverage, double detached_structure,
			double personal_property, double living_expense, double medical_expense, double deductible,int user_location_location_id) {
		super();
		
		this.monthly_preminum = monthly_preminum;
		this.dwelling_coverage = dwelling_coverage;
		this.detached_structure = detached_structure;
		this.personal_property = personal_property;
		this.living_expense = living_expense;
		this.medical_expense = medical_expense;
		this.deductible = deductible;
		this.user_location_location_id=user_location_location_id;
	}
	
	public int getUser_location_location_id() {
		return user_location_location_id;
	}
	public void setUser_location_location_id(int user_location_location_id) {
		this.user_location_location_id = user_location_location_id;
	}
	public int getQuote_id() {
		return quote_id;
	}
	public void setQuote_id(int quote_id) {
		this.quote_id = quote_id;
	}
	public double getMonthly_preminum() {
		return monthly_preminum;
	}
	public void setMonthly_preminum(double monthly_preminum) {
		this.monthly_preminum = monthly_preminum;
	}
	public double getDwelling_coverage() {
		return dwelling_coverage;
	}
	public void setDwelling_coverage(double dwelling_coverage) {
		this.dwelling_coverage = dwelling_coverage;
	}
	public double getDetached_structure() {
		return detached_structure;
	}
	public void setDetached_structure(double detached_structure) {
		this.detached_structure = detached_structure;
	}
	public double getPersonal_property() {
		return personal_property;
	}
	public void setPersonal_property(double personal_property) {
		this.personal_property = personal_property;
	}
	public double getLiving_expense() {
		return living_expense;
	}
	public void setLiving_expense(double living_expense) {
		this.living_expense = living_expense;
	}
	public double getMedical_expense() {
		return medical_expense;
	}
	public void setMedical_expense(double medical_expense) {
		this.medical_expense = medical_expense;
	}
	public double getDeductible() {
		return deductible;
	}
	public void setDeductible(double deductible) {
		this.deductible = deductible;
	}
     

}
