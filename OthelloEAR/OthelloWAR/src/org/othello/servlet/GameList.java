package org.othello.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class GameList
 */
@WebServlet("/GameList")
public class GameList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("GameList"); 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList allGames;
		HttpSession session = request.getSession();
		
		log.debug("Session Id to get LoginId "+ ((UserBean)session.getAttribute("UserBean")).toString());
		UserBean userBean = (UserBean) session.getAttribute("UserBean");
		GameDAO gameDAO = new GameDAO();
		allGames = gameDAO.getAllAvailableGames(userBean);
		
		session.setAttribute("AllGames", allGames);

		//response.sendRedirect("Games.jsp");
		//session.setAttribute("UserBean", userBean);
		String nextJSP = "/Games.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
