package org.othello.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.othello.beans.RegistrationBean;

import com.othello.DAO.UserDAO;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("Registration"); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegistrationBean registration = new RegistrationBean();
		
		 String firstName;
		 String middleName;
		 String lastName;
		 String emailAddress;
		 String password;
		 String loginId;
		 
		
		 firstName = request.getParameter("firstName");
		 lastName  = request.getParameter("lastName");
		 middleName = request.getParameter("middleName");
		 emailAddress= request.getParameter("emailAddress");
		 loginId = request.getParameter("loginId");
		 password = request.getParameter("password");
		 
		 
		// TODO: CALL VALIDATION ROUTINE TO VALIDATE ALL THE PARAMETERS
		 
		 registration.setFirstName(firstName);
		 registration.setLastName(lastName);
		 registration.setMiddleName(middleName);
		 registration.setEmailAddress(emailAddress);
		 registration.setLoginId(loginId);
		 registration.setPassword(password);
		
		if (log.isDebugEnabled()) 
		{
			log.debug(registration.toString());
		}
		UserDAO userDAO = new UserDAO();
		userDAO.createUser(registration);
		
		log.debug("Record Added Succesfully .... ");
		
	}

}
