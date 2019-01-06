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
 * Servlet implementation class StartGame
 */
@WebServlet("/StartGame")
public class StartGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("StartGame"); 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
HttpSession session = request.getSession();
		
		int gameId;
		GameDAO gameDAO = new GameDAO();
		
		gameId = Integer.parseInt(request.getParameter("gameId"));
		log.debug("Game ID ="+ gameId);
		log.debug("Session Id to get LoginId "+ ((UserBean)session.getAttribute("UserBean")).toString());
	
		
		UserBean userBean = (UserBean) session.getAttribute("UserBean");
		
		gameDAO.setSecondPlayer(userBean, gameId);
		userBean.setGameId(gameId);
		session.setAttribute("UserBean", userBean);
		String nextJSP = "/GameBoard.jsp";
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
