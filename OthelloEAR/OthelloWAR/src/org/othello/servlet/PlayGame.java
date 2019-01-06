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
import org.othello.utils.GameException;

import com.othello.DAO.PlayGameDAO;

/**
 * Servlet implementation class PlayGame
 */
@WebServlet("/PlayGame")
public class PlayGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("PlayGame"); 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayGame() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		int row, col;
		Integer stateId;
		String str;
		Integer boardId = 0;
		String message= "This is my message";
		
		row = Integer.parseInt(request.getParameter("rowId"));
		col = Integer.parseInt(request.getParameter("colId"));

		// TODO: DO VALIDATION 
		
		PlayGameDAO playGameDAO = new PlayGameDAO();
		
		UserBean userBean = (UserBean) session.getAttribute("UserBean");
		try{
			boardId = playGameDAO.setBoard(userBean);
		}catch(GameException gE){
			log.error("Error PlayGame:: doPost "+ gE.getMessage());			
			message = gE.getMessage();
			request.setAttribute("Message", message);

			session.setAttribute("UserBean", userBean);
			String nextJSP = "/GameBoard.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);	

		return;

		}
		
		stateId = playGameDAO.insertMove(userBean, row, col,boardId);
		
		str = playGameDAO.loadBoard(stateId);
		
		
		request.setAttribute("Message", message);
		session.setAttribute("BoardStates", str);

		session.setAttribute("UserBean", userBean);
		String nextJSP = "/GameBoard.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);	}

}
