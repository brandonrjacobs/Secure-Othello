package com.othello.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.othello.beans.UserBean;
import org.othello.entities.User;
import org.othello.entities.UserPassword;
import org.othello.hibernate.HibernateUtil;

public class LoginDAO {
	
	private static Logger log = Logger.getLogger("LoginDAO"); 

	public UserBean validateLogin(String userId, String password){
		
		boolean flag = false;
		Session session = null;
		UserBean userBean = new UserBean();

		
		try{
			
			HibernateUtil.getSessionFactory();
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
		     session = sessionFactory.openSession();  
		     
		     @SuppressWarnings("unchecked")
			List<User> user = session.createCriteria(User.class)
		    		 .add(Restrictions.eqOrIsNull("loginId", userId)).list();
		     
		     User user1 = null;
		     
		     for (int i=0; i<user.size(); i++){
		    	 
		    	  user1 = (User)user.get(i);
		    	  userBean.setFirstName(user1.getFirstName());
		    	  userBean.setLastName(user1.getLastName());
		    	  userBean.setEmailAddress(user1.getEmailAddress());
		    	  userBean.setLoginId(user1.getLoginId());
		    	  userBean.setUserid(user1.getUserId());
		    	  
		    	 log.debug("User Information "+ user1.getFirstName());
		    	 log.debug(user1.getLoginId());
		    	 break;
		     }
		     
		     
		     @SuppressWarnings("unchecked")
				List<UserPassword> user2 = session.createCriteria(UserPassword.class)
			    		 .add(Restrictions.eqOrIsNull("FK_USERID", user1.getUserId())).list();
			     
		     UserPassword userPwd = null;
		     
		     for (int i=0; i<user2.size(); i++){		    	 
		    	 userPwd = (UserPassword) user2.get(i);
		    	 log.debug("User Password Information "+ userPwd.getPassword());
		    	 log.debug(userPwd.getFK_USERID());
		    	 break;
		     }
		     log.debug("Value for password="+password);
		     log.debug("value for userpwd="+userPwd.getPassword());
		     
		     if (userPwd.getPassword().trim().equals(password.trim())){
		    	 userBean.setFlag(true);
		     }
		}catch(Exception e){
			
			log.error("LoginDAO Error:: "+ e);
			flag = false;
		}
		
		return userBean;
	}

}
