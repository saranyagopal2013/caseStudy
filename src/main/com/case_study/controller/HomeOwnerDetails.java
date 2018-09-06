package com.case_study.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.case_study.bo.HomeOwnerBo;
import com.case_study.bo.PolicyConfirmationBo;
import com.case_study.bo.PropertyDetailsBo;
import com.case_study.bo.QuoteDetailsBo;
import com.case_study.bo.UserBo;
import com.case_study.bo.User_LocationBo;
import com.case_study.dao.UserDao;
import com.case_study.model.HomeOwner;
import com.case_study.model.Property_Details;
import com.case_study.model.Quote_Details;
import com.case_study.model.User;
import com.case_study.model.User_Location;
import com.case_study.model.policy_confirmation;

/**
 * Servlet implementation class HomeOwnerDetails
 */
@WebServlet(urlPatterns = {"/","/HomeOwnerDetails"})
public class HomeOwnerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message = "";
	List<String> errors = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeOwnerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {

			case "/home":
				home(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/retrievequote":
				retrieveQuote(request, response);
				break;
			case "/saveLocationInfo":
				saveLocationInfo(request, response);
				break;
			case "/saveHomeOwnerInfo":
				saveHomeOwnerInfo(request,response);
				break;
			case "/savePropertyInfo":
				savePropertyInfo(request,response);
				break;
			case "/calculateCoverageDetails":
				calculateCoverageDetails(request,response);
				break;
			case "/QuoteDetails":
				quoteDetails(request,response);
				break;
			case "/DetailsPolicy":
				DetailsPolicy(request,response);
				break;
			case "/QuoteSummary":
				quoteSummary(request,response);
				break;
			case "/BuyPolicy":
				buyPolicy(request,response);
				break;
			case "/PolicyConfirmation":
				savePolicyInfo(request,response);
				break;
			case "/MyPolicies":
				myPolicy(request,response);
				break;
			case "/Renew":
				renewPolicy(request,response);
				break;
			case "/Cancel":
				cancelPolicy(request,response);
				break;
				
			default:
				RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException | ParseException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	
	//***********************************Renew Policy ***************************************************************************************
		
	private void renewPolicy(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			HttpSession session = request.getSession();
			if(session.getAttribute("currentSessionUser")!=null) 
			{
				policy_confirmation policy=(policy_confirmation) session.getAttribute("AdminPolicy");
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, -1);
				Date renew = cal.getTime();
		
				//if(policy.getPolicy_end_date().before(renew) && policy.getPolicy_status().equals("Active"))
			  int daysInmill = (30*24*60*60*1000);
			if(policy.getPolicy_end_date().getTime()-Calendar.getInstance().getTimeInMillis()<daysInmill&& policy.getPolicy_status().equals("Active"))
				{
					 RequestDispatcher rd=request.getRequestDispatcher("AdminPolicies.jsp");
			    	 request.setAttribute("errorMessage", "Policies can be renewed only 1 month before the policy end date ");
			 		  rd.include(request,response);
					
				}else
				{
					Calendar calendar = Calendar.getInstance();
					java.util.Date currentDate = calendar.getTime();
					
					java.sql.Date Startdate = new java.sql.Date(calendar.getTime().getTime()); 
					calendar.add(Calendar.YEAR, 1);
					java.sql.Date enddate = new java.sql.Date(calendar.getTime().getTime()); 
					policy.setPolicy_effective_date(Startdate);
					policy.setPolicy_end_date(enddate);
					policy.setPolicy_status("RENEWED");
					session.setAttribute("newStartDate",Startdate);
					session.setAttribute("newEndDate",enddate);
					session.setAttribute("newStatus",policy.getPolicy_status());
				    PolicyConfirmationBo bo=new PolicyConfirmationBo();
				    bo.UpdatePolicy(policy);
				    RequestDispatcher rd=request.getRequestDispatcher("AdminPolicyRenew.jsp");
				    rd.forward(request, response);
					
				}

				
			}
			else {
				response.sendRedirect("LoginPage.jsp");
			}
		}

	//***********************************Cancel Policy ***************************************************************************************
				private void cancelPolicy(HttpServletRequest request, HttpServletResponse response)
						throws SQLException, IOException, ServletException {
					HttpSession session = request.getSession();
					if(session.getAttribute("currentSessionUser")!=null) 
					
					{	
						policy_confirmation policy=(policy_confirmation) session.getAttribute("AdminPolicy");
						policy.setPolicy_status("CANCELLED");
					    PolicyConfirmationBo bo=new PolicyConfirmationBo();
					    bo.UpdatePolicy(policy);
					    session.setAttribute("newCancel",policy.getPolicy_status());
					    RequestDispatcher rd=request.getRequestDispatcher("AdminPolicyCancel.jsp");
					    rd.forward(request, response);
					}
					
				
				}
		
		
	//***********************************Quote Details ***************************************************************************************
				private void quoteDetails(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException 
				{
					HttpSession session = request.getSession();
					if(session.getAttribute("currentSessionUser")!=null) 
						{

						RequestDispatcher rd = request.getRequestDispatcher("QuoteDetails.jsp");
						rd.forward(request, response);
						}
					else {
						response.sendRedirect("LoginPage.jsp");
						}
				}
	
	
//***********************************Quote Summary***************************************************************************************
	private void quoteSummary(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		if(session.getAttribute("currentSessionUser")!=null) 
		{

			RequestDispatcher rd = request.getRequestDispatcher("QuoteSummary.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("LoginPage.jsp");
		}
	}
	//***********************************Buy Policy ***************************************************************************************
	
	private void buyPolicy(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		if(session.getAttribute("currentSessionUser")!=null) {
			
			
			RequestDispatcher rd = request.getRequestDispatcher("BuyPolicy.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("LoginPage.jsp");
		}

	}
	
	//*********************************** MyPolicy ***************************************************************************************
		private void myPolicy(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			HttpSession session = request.getSession();
			if(session.getAttribute("currentSessionUser")!=null) 
			{
				User current = (User) session.getAttribute("currentSessionUser");
				String username=request.getParameter("username");
				
				UserBo userbo =new UserBo();
			    User u= userbo.getUserByUserName(username);
				int userId=u.getUser_id();
				
				PolicyConfirmationBo bo=new PolicyConfirmationBo();
				policy_confirmation policy=bo.getPolicyDetailsrByUserId(userId);
				
				if(policy!=null)
				{
				session.setAttribute("policyKey",policy.getPolicy_id());
				session.setAttribute("quoteId",policy.getQuote_details_quote_id());
				session.setAttribute("startDate",policy.getPolicy_effective_date());
				session.setAttribute("endDate",policy.getPolicy_end_date());
				session.setAttribute("term",policy.getPolicy_term());
				session.setAttribute("status",policy.getPolicy_status());
				
				session.setAttribute("AdminPolicy",policy);
				       if(current.getAdmin_role().equals("admin"))
				           {
				    	   	RequestDispatcher rd = request.getRequestDispatcher("AdminPolicies.jsp");
				    	   	rd.forward(request, response);
				           }
				       else
				          {
				    	   RequestDispatcher rd = request.getRequestDispatcher("MyPolicies.jsp");
				    	   rd.forward(request, response);
				          }
				
				}
				
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("NoPolicy.jsp");
					rd.forward(request, response);
				}
			}
			else {
				response.sendRedirect("LoginPage.jsp");
			}
		}
	
	
	/******************** Register Policy * @throws ParseException ************/
		
	private void savePolicyInfo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException 
	{

		HttpSession session = request.getSession(false);
		Quote_Details quote = (Quote_Details)session.getAttribute("CurrentQuote");
		

		if(session.getAttribute("currentSessionUser")!=null)
		{
			String effectiveDate=request.getParameter("startDate");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date formatdb = formatter.parse(effectiveDate);
			java.sql.Date startDate = new java.sql.Date( formatdb.getTime());
			Calendar cal = Calendar.getInstance();
			cal.setTime(formatdb);
			cal.add(Calendar.YEAR, 1);
			formatdb = cal.getTime();
			java.sql.Date endDate = new java.sql.Date( formatdb.getTime());
			int quoteId=quote.getQuote_id();
			
			session.setAttribute("startDate",startDate);
			session.setAttribute("endDate",endDate);
			session.setAttribute("quoteId",quoteId);
			
			policy_confirmation policy=new policy_confirmation(startDate,endDate,quoteId);
			session.setAttribute("term",policy.getPolicy_term());
			session.setAttribute("status",policy.getPolicy_status());
			PolicyConfirmationBo bo=new PolicyConfirmationBo();

			try {
				int PolicyId=bo.registerPolicy(policy);
			

				if(PolicyId==0)
				{
					RequestDispatcher rd=request.getRequestDispatcher("BuyPolicy.jsp");
					request.setAttribute("errorMessage", "Invalid input");
					rd.include(request,response);
				}
				else
				{	policy.setPolicy_id(PolicyId);
					session.setAttribute("policyId",PolicyId);
					// HttpSession session = request.getSession(true);	    
					session.setAttribute("CurrentPolicy",policy); 
					response.sendRedirect("PolicyConfirmation.jsp");
				}

			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	}
		else
		{
			response.sendRedirect("LoginPage.jsp");
		}

	}

	/*****************************************
	 * home page
	 * 
	 * @throws ServletException
	 *************************/
	private void home(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		if (session.getAttribute("currentSessionUser") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);

		} else {
			response.sendRedirect("LoginPage.jsp");
		}
	}
	/*****************************************
	 * Logout form
	 *************************/
	private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("LoginPage.jsp");
	}

	/****************** Retrieve Quote ********************/
	private void retrieveQuote(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		System.out.println("inside servlet");
		if (session.getAttribute("currentSessionUser") != null && session.getAttribute("currentQuote")!=null) 
		{
			RequestDispatcher rd = request.getRequestDispatcher("QuoteDetails.jsp");
			rd.forward(request, response);

		} 
		else 
		{
			User u = (User) session.getAttribute("currentSessionUser");
			int userId=u.getUser_id();
			
			QuoteDetailsBo quoteBo=new QuoteDetailsBo();
			HashMap<Integer,User_Location> quote=quoteBo.getQuoteDetailsByUserId(userId);
			session.setAttribute("quotes", quote);
			
			for(HashMap.Entry<Integer,User_Location> quoteDetails:quote.entrySet()) 
			{
				session.setAttribute("quoteid", quoteDetails.getKey());
				session.setAttribute("residence_type",quoteDetails.getValue().getResidence_Type());
				session.setAttribute("address_line_1",quoteDetails.getValue().getAddress_line_1());
				session.setAttribute("city",quoteDetails.getValue().getCity());
				session.setAttribute("state",quoteDetails.getValue().getState());
				session.setAttribute("zip",quoteDetails.getValue().getZipcode());
				session.setAttribute("residence_use",quoteDetails.getValue().getResidence_use());
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("Quote.jsp");
			rd.forward(request, response);
			
			//response.sendRedirect("CoverageDetails.jsp");
		}

	}
	/******************** send get quote info ************/
	private void saveLocationInfo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException 
	{

		HttpSession session = request.getSession(false);

		

		if(session.getAttribute("currentSessionUser")!=null)
		{
			User u = (User) session.getAttribute("currentSessionUser");
			String residenceType = request.getParameter("residenceType");
			String addressline1 = request.getParameter("Address_Line_1");
			String addressline2 = request.getParameter("Address_Line_2");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			int zipCode = Integer.parseInt(request.getParameter("zipcode"));
			String residenceuse = request.getParameter("ResidentUse");
			int userid= u.getUser_id();
			session.setAttribute("addressline1", addressline1);
			session.setAttribute("addressline2", addressline2);
			session.setAttribute("state", state);
			session.setAttribute("city", city);
			session.setAttribute("zip", zipCode);
			session.setAttribute("type", residenceType);
			session.setAttribute("use", residenceuse);
			

			User_Location location=new User_Location(residenceType,addressline1,addressline2,state,city,zipCode,residenceuse,userid);
			User_LocationBo bo=new User_LocationBo();

			try {
				int LocationId=bo.registerLocation(location);
				System.out.println(LocationId);

				if(LocationId==0)
				{
					RequestDispatcher rd=request.getRequestDispatcher("GetQuote.jsp");
					request.setAttribute("errorMessage", "Invalid input");
					rd.include(request,response);
				}
				else
				{	location.setLocation_id(LocationId);
					// HttpSession session = request.getSession(true);	    
					session.setAttribute("CurrentLocationDetails",location); 
					response.sendRedirect("HomeOwnerDetails.jsp");
				}

			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	}
		else
		{
			response.sendRedirect("LoginPage.jsp");
		}

	}





	
		//*********************************************************save owner info*****************************************************/
	private void saveHomeOwnerInfo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException 
	{
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("currentSessionUser")!=null) 

		{
			User u = (User) session.getAttribute("currentSessionUser");
			String first_name = request.getParameter("fname");
			String last_name = request.getParameter("lname");
			String birth = request.getParameter("dob");
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			java.util.Date formatdb = formatter.parse(birth);
			
			java.sql.Date dateBirth = new java.sql.Date( formatdb.getTime());
			
//			Date dateBirth = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(birth);
			String retired = request.getParameter("retired");
			int ssn = Integer.parseInt(request.getParameter("ssn"));
			String email = request.getParameter("email");
			int user_id = u.getUser_id();

			session.setAttribute("fname", first_name );
			session.setAttribute("lname",last_name );
			session.setAttribute("retired", retired);
			session.setAttribute("ssn",ssn );
			session.setAttribute("email",email );
			session.setAttribute("birth",dateBirth );

			HomeOwner owner = new HomeOwner(first_name,last_name,dateBirth,retired,ssn,email,user_id);

			try {
				HomeOwnerBo home_BO=new HomeOwnerBo();
				int homeOwnerId=home_BO.registerHomeOwner(owner);

				if(homeOwnerId==0)
				{
					RequestDispatcher rd=request.getRequestDispatcher("HomeOwnerDetails.jsp");
					request.setAttribute("errorMessage", "Invalid input");
					rd.include(request,response);
				}
				else
				{
					// HttpSession session = request.getSession(true);
					owner.setHomeOwner_id(homeOwnerId);
					session.setAttribute("currentHomeowner",owner);
					response.sendRedirect("PropertyDetails.jsp");
				}

			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		else {
			response.sendRedirect("LoginPage.jsp");
		}
	}

	//	/************************************************saving property info*******************************************************/
	private void savePropertyInfo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		User_Location location = (User_Location)session.getAttribute("CurrentLocationDetails");

		if(session.getAttribute("currentSessionUser")!=null) 
		{
			Double marketValue =Double.parseDouble(request.getParameter("marketvalue"));
			int built =Integer.parseInt(request.getParameter("yearbuilt"));
			int footage =Integer.parseInt(request.getParameter("squarefootage"));
			String dwelling = request.getParameter("dwellingtype");
			String roof = request.getParameter("roofmaterial");
			String garage = request.getParameter("garagetype");
			int fullBaths = Integer.parseInt(request.getParameter("fullbath"));
			int halfBaths = Integer.parseInt(request.getParameter("halfbath"));
			Boolean pool = Boolean.parseBoolean(request.getParameter("pool"));
			int location_id=location.getLocation_id();
			System.out.println(location_id);


			session.setAttribute("marketValue",marketValue);
			session.setAttribute("built", built);
			session.setAttribute("footage", footage);
			session.setAttribute("dwelling", dwelling);
			session.setAttribute("roof", roof);
			session.setAttribute("halfBaths", halfBaths);
			session.setAttribute("fullBaths", fullBaths);
			session.setAttribute("pool", pool);
			session.setAttribute("garage", garage);

			Property_Details property= new Property_Details(marketValue,built,footage,dwelling,roof,garage,fullBaths,halfBaths,pool,location_id);
			session.setAttribute("currentProperty", property);

			PropertyDetailsBo propertyBo = new PropertyDetailsBo();
			int id=propertyBo.registerPropertyDetails(property);
			if(id!=0) 
			{
			    //response.sendRedirect("/calculateCoverageDetails");
				
				property.setProperty_id(id);
				session.setAttribute("currentProperty",property);
			    RequestDispatcher rd = request.getRequestDispatcher("/calculateCoverageDetails");
			    rd.forward(request, response);
		}
			else
		{
			RequestDispatcher rd=request.getRequestDispatcher("PropertyDetails.jsp");
			request.setAttribute("errorMessage", "Invalid input values");
			rd.include(request,response);
		}
			}
		else {
			response.sendRedirect("LoginPage.jsp");
		}
	}

	/*********************************************************************calculations for policy********************************************************/

	private void calculateCoverageDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		if(session.getAttribute("currentSessionUser")!=null) 
		{
			Property_Details currentProperty = (Property_Details) session.getAttribute("currentProperty");
			Double value =currentProperty.getProperty_market_value();
			int year = currentProperty.getProperty_year_built();
			int footage =currentProperty.getProperty_square_footage();

			
			int homeValue = footage*120;
			int medicalExpense = 5000;
			int deductable = (int) (.01*value);//homeValue
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			int difference = currentYear-year;
			
			if(difference<=5) 
			{
				
				homeValue=(int)(homeValue-(.1*homeValue));
			}else if(difference<=10 && difference>5)
			{
				
				homeValue=(int)(homeValue-(.2*homeValue));
			}else if(difference<=20 && difference>10) 
			{
				
				homeValue=(int)(homeValue-(.3*homeValue));
			}else if(difference>20) {
				
				homeValue=(int)(homeValue-(.5*homeValue));
			}
			//premiun =rate
			int dwellingCovereage = (int)(.50*value+homeValue);
			double rate = (double)(5*(dwellingCovereage/1000));
			int detacheStructure = (int) (.10*dwellingCovereage);
			int personalProperty = (int) (.60*dwellingCovereage);
			int living = (int) (.20*dwellingCovereage);
			double premium1 = rate;
			String style = currentProperty.getProperty_dwelling_style();
			
			switch(style){
			case "single-family":
				premium1 =premium1+(premium1*.005);
				break;
			case "condo":
			case "duplex":
			case "apartment":
				premium1 =premium1+(premium1*.006);
				break;
			case "townhouse":
			case "rowhouse":
				premium1 =premium1+(premium1*.007);
				break;
			}
			
			double monthlyPremium=(premium1/12);
			monthlyPremium=Math.round((monthlyPremium*100)/100);
			session.setAttribute("monthlyPremium", monthlyPremium);
			session.setAttribute("premium", premium1);
			session.setAttribute("coverage", dwellingCovereage);
			session.setAttribute("detacheStructure", detacheStructure);
			session.setAttribute("personalProperty", personalProperty);
			session.setAttribute("living", living);
			session.setAttribute("medicalExpense",medicalExpense);
			session.setAttribute("deductable", deductable);
			

			User_Location location = (User_Location) session.getAttribute("CurrentLocationDetails");
			int locationId=location.getLocation_id();



			Quote_Details quote = new Quote_Details(monthlyPremium,dwellingCovereage,detacheStructure,personalProperty,living,medicalExpense,deductable,locationId); 
			QuoteDetailsBo BO = new QuoteDetailsBo();
			int quoteId=BO.registerQuoteDetails(quote);
			session.setAttribute("quoteId",quoteId);
			int id=(int)session.getAttribute("quoteId");
			if(id!=0)
			{
				quote.setQuote_id(id);
			session.setAttribute("CurrentQuote",quote );
			RequestDispatcher rd = request.getRequestDispatcher("CoverageDetails.jsp");
			rd.forward(request, response);
			}
			else
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("Property_Details.jsp");
				request.setAttribute("errorMessage", "Invalid input");
				rd.include(request,response);
			}
			}
		else {
			response.sendRedirect("LoginPage.jsp");
		}
	}
	/********************************* details of policy************************************************************************/
	private void DetailsPolicy(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		if(session.getAttribute("currentSessionUser")!=null) 
		{

			RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("main");
		}
	}

	



}


