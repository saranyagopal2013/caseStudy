package com.case_study.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.case_study.bo.UserBo;
import com.case_study.dao.UserDao;
import com.case_study.model.User;

/**
 * Servlet implementation class CustomerDetails
 */
@WebServlet("/NewUserRegisterServlet")
public class NewUserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message = "";
	List<String> errors = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 String name = request.getParameter("regname");
	        String password = request.getParameter("regpassword");
	        String repassword = request.getParameter("password_confirm");
	        if(password.equals(repassword))
	        {
	        User newUser=new User(name,password);
	       
	        
	        UserBo register=new UserBo();
	        try {
				int userid=register.registerUser(newUser);
				if(userid==0)
				{
					 RequestDispatcher rd=request.getRequestDispatcher("UserRegistration.jsp");
			    	 request.setAttribute("errorMessage", "Invalid Userid or Password");
			 		  rd.include(request,response);
				}
				else
				{
					 HttpSession session = request.getSession(true);	    
			          session.setAttribute("currentSessionUser",newUser); 
			          response.sendRedirect("LoginPage.jsp");
				}
	       
			} catch (SQLException e) 
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }else
	        {
	        	 RequestDispatcher rd=request.getRequestDispatcher("UserRegistration.jsp");
		    	 request.setAttribute("errorMessage", "Invalid Password");
		 		  rd.include(request,response);
	        }
	}

}
