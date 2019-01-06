package com.othello.DAO;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.othello.beans.RegistrationBean;
import org.othello.entities.User;
import org.othello.entities.UserPassword;
import org.othello.hibernate.HibernateUtil;


public class UserDAO {

	private static Logger log = Logger.getLogger("UserDAO"); 
	User user = new User();

	public boolean createUser(RegistrationBean registrationBean){
		boolean flag = true;
		if (log.isDebugEnabled()){
			
			log.debug("Inside Create User ");
		}
		
	user.setFirstName(registrationBean.getFirstName());
	user.setLastName(registrationBean.getLastName());
	user.setEmailAddress(registrationBean.getEmailAddress());
	user.setLoginId(registrationBean.getLoginId());
	user.setPassword(registrationBean.getPassword());
	Session session = null;
	
	try{
		HibernateUtil.getSessionFactory();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
	     session = sessionFactory.openSession();  
	     session.beginTransaction();
	      session.save(user);
	      
	    UserPassword userPassword = new UserPassword();
	    userPassword.setFK_USERID(user.getUserId());
	    userPassword.setPassword(registrationBean.getPassword());
	      
	    session.save(userPassword);
	   
	}catch(Exception e){
		
		log.error("User:: CreateUser Error: "+ e);
		flag = false;
	}finally{	    
		session.getTransaction().commit();
		session.close();  
	
	}
		return flag;
		
	}
	
}
