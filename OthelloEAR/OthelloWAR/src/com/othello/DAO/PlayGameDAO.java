package com.othello.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.othello.beans.UserBean;
import org.othello.entities.Board;
import org.othello.entities.BoardStates;
import org.othello.entities.User;
import org.othello.entities.UserPassword;
import org.othello.hibernate.HibernateUtil;
import org.othello.utils.GameException;

public class PlayGameDAO {
	
	private static Logger log = Logger.getLogger("PlayGameDAO"); 
	private Session session = null;
	

	
	
	public Integer setBoard(UserBean aUserBean) throws GameException{
		Integer boardId = null;
		try{
			
			Board board = new Board();
			
			HibernateUtil.getSessionFactory();
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		     session = sessionFactory.openSession();  
		     session.beginTransaction();
		      
		     
		     @SuppressWarnings("unchecked")
			List<Board> existingBoard = session.createCriteria(Board.class)
		    		 .add(Restrictions.eqOrIsNull("FK_GAMEID", aUserBean.getGameId())).list();
		     log.debug("XXXXBBBBB "+ existingBoard.size());
		     
		    
		     
		     if (existingBoard.size() > 0){
		    	 
		    	 for (int i=0; i < existingBoard.size(); i++){
		    		 board = (Board) existingBoard.get(i);
		    		 log.debug("Inside PlayGameDAO Board value:"+ board.getBoardID());
		    		 log.debug("Inside PlayGameDAO UserId value:"+ board.getFK_USERID());
		    		 log.debug("Inside PlayGameDAO Game Id value:"+ board.getFK_GAMEID());
		    		 
		    		 if (board.getFK_USERID() == aUserBean.getUserid()){
		    			 
		    			 log.debug("UserId is current ..... ");
		    			 throw new GameException("Please wait for your turn...");
		    		 }
		    		 board = (Board) session.get(Board.class, board.getBoardID());
		    		 board.setFK_USERID(aUserBean.getUserid());
		    		 session.update(board);
		    		 
		    	 }
		    	 
		    	 
		     }else{	     
		     
		     board.setFK_GAMEID(aUserBean.getGameId());
			 board.setFK_USERID(aUserBean.getUserid());
		     session.save(board);
		     }
		     
		     boardId = board.getBoardID();
		   log.debug("Board Id is :::: "+ boardId);
		     
		}catch(GameException gE){
			 throw new GameException("Please wait for your turn...");

		}catch(Exception e){
			
			log.error("PlayGameDAO:: setBoard Error: "+ e);
		}finally{	    
			session.getTransaction().commit();
			session.close();  
		
		}
		
		return boardId;
	}

	public Integer insertMove(UserBean aUserBean, int row, int col, Integer boardId){
		
		Integer stateId = null;
		int moveNumber = 1;
		
try{
			
			BoardStates boardStates = new BoardStates();
			BoardStates board = new BoardStates();

			HibernateUtil.getSessionFactory();
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		     session = sessionFactory.openSession();  
			
			 @SuppressWarnings("unchecked")
				List<BoardStates> existingBoard = session.createCriteria(BoardStates.class)
			    		 .add(Restrictions.eqOrIsNull("FK_GAMEID", aUserBean.getGameId())).list();
			     log.debug("insertMove:: move numbersize "+ existingBoard.size());
			     if (existingBoard.size() > 0){
			    	 
			    	 for (int i=0; i < existingBoard.size(); i++){
			    		 board = (BoardStates) existingBoard.get(i);
			    		 log.debug("Inside PlayGameDAO UserId value:"+ board.getFK_USERID());
			    		 log.debug("Inside PlayGameDAO Game Id value:"+ board.getFK_GAMEID());
			    		 
			    		 moveNumber = board.getMoveNumber();
			    		 moveNumber++;
			    		 
			    	 }
			     }
			
			
			boardStates.setFK_GAMEID(aUserBean.getGameId());
			boardStates.setFK_USERID(aUserBean.getUserid());
			boardStates.setFK_BOARDID(boardId);
			boardStates.setMoveNumber(moveNumber);
			boardStates.setBoardMap("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
			
							
			
		     session.beginTransaction();
		      session.save(boardStates);
		      stateId = boardStates.getStateId();
		     
		     
		}catch(Exception e){
			
			log.error("PlayGameDAO:: insertMove Error: "+ e);
		}finally{	    
			session.getTransaction().commit();
			session.close();  
		
		}
	return stateId;
	}
	

	public String loadBoard(Integer stateId){
		String board = null;
		
		
try{
			
			HibernateUtil.getSessionFactory();
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		     session = sessionFactory.openSession();  
		     
		     @SuppressWarnings("unchecked")
			List<BoardStates> user = session.createCriteria(BoardStates.class)
		    		 .add(Restrictions.eqOrIsNull("StateId", stateId)).list();
		     
		     User user1 = null;
		     
		     for (int i=0; i<user.size(); i++){
		    	 
		    	 BoardStates boardState = (BoardStates)user.get(i);
		    	 board = boardState.getBoardMap();
		    	 log.debug("Board Map is "+ boardState.getBoardMap());
		    	 break;
		     }
		     
		     
		    
		}catch(Exception e){
			
			log.error("PlayGameDAO loadBoard Error:: "+ e);
		
		}
		
		
		return board;
	}
	
}
