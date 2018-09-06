package com.case_study.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.case_study.bo.UserBo;
import com.case_study.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out=response.getWriter();
		
		try
		{	    
        User user = new User();
		  UserBo bo=new UserBo();
		
		  user=bo.loginUser(request.getParameter("username"),request.getParameter("password"));
			   		    
		     if (user.getUser_name().isEmpty())
		     {
		    	
		    	 RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
		    	 request.setAttribute("errorMessage", "Invalid Userid or Password");
		 		  rd.include(request,response);
		    	  //error page 
		             	
		     }
			        
		     else 
		     if(user.getAdmin_role().equals("user"))
		     {
		     HttpSession session = request.getSession();	 
		     	request.setAttribute("userid", user.getUser_id());
	          session.setAttribute("currentSessionUser",user); 
	          response.sendRedirect("Home.jsp"); //logged-in page 
		     }
		     else
		     {
		    	 HttpSession session = request.getSession();	 
			     	request.setAttribute("userid", user.getUser_id());
		          session.setAttribute("currentSessionUser",user); 
		          response.sendRedirect("AdminScreen.jsp"); //
		     }
		
		}			
			catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		       }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
