package org.othello.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.othello.beans.UserBean;

import com.othello.DAO.LoginDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("Login"); 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String loginId;
		String password;
		boolean flag = false;
		HttpSession session = request.getSession(true);
		UserBean userBean = null;
		
		loginId = request.getParameter("loginId");
		password = request.getParameter("password");
		
		//TODO: Perform validation
		
		LoginDAO loginDAO = new LoginDAO();
		userBean = loginDAO.validateLogin(loginId, password);
		log.debug("FFFFFFFFF "+ flag);
		
		if (!userBean.isFlag()){
			response.sendRedirect("LoginIncorrect.jsp");			
		}else
		{			
			session.setAttribute("UserBean", userBean);
			String nextJSP = "/GameList";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
	
	}

}
