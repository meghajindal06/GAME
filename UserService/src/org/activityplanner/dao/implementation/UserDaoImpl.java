package org.activityplanner.dao.implementation;

import java.util.List;

import org.activityplanner.dao.UserAccountAlreadyExistException;
import org.activityplanner.dao.UserDao;
import org.activityplanner.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
@SuppressWarnings({"rawtypes", "unchecked"})
public class UserDaoImpl implements UserDao {
    
   

    @Autowired
    private SessionFactory sessionFactory;

    public UserEntity createUser(UserEntity userEntity) throws UserAccountAlreadyExistException {
       
        Session session = null;
        try {
        	
        	System.out.println(sessionFactory);
            session = sessionFactory.openSession();
           
            session.saveOrUpdate(userEntity);
            session.flush();
        } catch (HibernateException e) {
            throw new RuntimeException("Unable to create user:, cause is: ", e);
        } catch(Exception e){
        	e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                try {
                    session.close();
                } catch (HibernateException e) {
                }
            }
        }

        return userEntity;
    }

    private void close(Session session) {
        if (session != null && session.isOpen()) {
            try {
                session.close();
            } catch (HibernateException e) {
            }
        }
    }

	@Override
	public UserEntity authenticateUser(String email, String password) {
		  Session session = null;
	        try {
	            session = sessionFactory.openSession();
	            String hql = null;
	                hql = "FROM UserEntity U WHERE U.mailId =:email and U.password =:password";
	            Query query = session.createQuery(hql);
	            query.setParameter("email", email);
	            query.setParameter("password", password);
	            List<UserEntity> users = query.list();
	            if (users != null && users.size() > 0) {
	                return (UserEntity) users.get(0);
	            }
	        } catch (HibernateException e) {
	        	e.printStackTrace();
	        } finally {
	            close(session);
	        }
	        return null;
		
	}

    
  
    
   
    
   
}
