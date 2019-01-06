package com.othello.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.othello.beans.GameBean;
import org.othello.beans.UserBean;
import org.othello.entities.Game;
import org.othello.hibernate.HibernateUtil;

public class GameDAO {

	
	private static Logger log = Logger.getLogger("GameDAO"); 
	private Session session = null;
	
	public void createNewGame(UserBean usrBean, String gameName){
		
		
		Game game = new Game();
		
		game.setFK_USERID1(usrBean.getUserid());
		game.setGameName(gameName);
		game.setGameStatus("WAIT");

		

		try{
			HibernateUtil.getSessionFactory();
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		     session = sessionFactory.openSession();  
		     session.beginTransaction();
		      session.save(game);
		     
		   
		}catch(Exception e){
			
			log.error("Game:: CreateUser Error: "+ e);
		}finally{	    
			session.getTransaction().commit();
			session.close();  
		
		}
		
	}
	
	public ArrayList<GameBean> getAllAvailableGames(UserBean aUserBean){
		
		ArrayList allAvailableGames = new ArrayList();
		
		try{
			HibernateUtil.getSessionFactory();
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		     session = sessionFactory.openSession();  
		     session.beginTransaction();
		     List<Game> allGames = session.createQuery("FROM Game").list(); 
		     
		     GameBean gameBean;
		     Game game;
		     for(int i=0; i< allGames.size(); i++){
		    	 gameBean = new GameBean();
		    	 game = (Game) allGames.get(i);
		    	 
		    	 gameBean.setGameId(game.getGameID());
		    	 gameBean.setGameName(game.getGameName());
		    	 gameBean.setGameStatus(game.getGameStatus());
		    	 gameBean.setUser1Id(game.getFK_USERID1());
		   // 	 gameBean.setUser2Id(game.getFK_USERID2());
		    	 
		    	 
		    	
		    		 
		    		 allAvailableGames.add(gameBean);
		    	
		    	 
		    	 
		     }
		     
		   
		}catch(Exception e){
			e.printStackTrace();
			
			log.error("Game:: GetAllAvailableGames Error: "+ e.getMessage());
		}finally{	    
			session.getTransaction().commit();
			session.close();  
		
		}
		return allAvailableGames;
		
	}
	
	
	public void setSecondPlayer(UserBean aUserBean, int aGameId){
		
		
		try{
			HibernateUtil.getSessionFactory();
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		     session = sessionFactory.openSession();  
		     session.beginTransaction();
		     Game game = (Game) session.get(Game.class, aGameId) ;
		     if (!game.getGameStatus().equalsIgnoreCase("CURRENT")){		     
		    	 game.setGameStatus("CURRENT");
		    	 game.setFK_USERID2(aUserBean.getUserid());
		    	 session.update(game);
		     }
		     
		   
		}catch(Exception e){
			
			log.error("Game:: setSecondPlayer Error: "+ e);
		}finally{	    
			session.getTransaction().commit();
			session.close();  
		
		}
		
		
	}

}
