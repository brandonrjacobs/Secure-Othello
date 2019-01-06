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

import com.othello.DAO.GameDAO;

/**
 * Servlet implementation class CreateGame
 */
@WebServlet("/CreateGame")
public class CreateGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("CreateGame"); 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGame() {
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
		
		HttpSession session = request.getSession();
		String gameName;
		GameDAO gameDAO = new GameDAO();
		
		gameName = request.getParameter("gameName");
		
		//TODO: DO VALIDATIONs
		UserBean userBean = (UserBean) session.getAttribute("UserBean");
		log.debug("From Create Game userbean "+ userBean.toString());
		
		gameDAO.createNewGame(userBean, gameName);
		
		session.setAttribute("UserBean", userBean);
		String nextJSP = "/GameList";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
		
	}

}
