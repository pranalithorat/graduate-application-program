package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.User;
import gapp.model.dao.UserDao;

@Repository
public  class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User getUser( Integer id )
    {
    	
        return entityManager.find( User.class, id );
    }
    
    

    @Override
    public List<User> getUsers()
    {
        return entityManager.createQuery( "from User order by id", User.class )
            .getResultList();
    }

	@Override
	@Transactional
	public User saveUser(User user) {
		
		return entityManager.merge(user);
	}
	
	
	
	@Override
    public User getUserByEmail( String email )
    {
        String query = "from User where lower(email) = :email";

        List<User> users = entityManager.createQuery( query, User.class )
            .setParameter( "email", email.toLowerCase() )
            .getResultList();
        return users.size() == 0 ? null : users.get( 0 );
    }
	
	@Override
	public User checkLogin(User user,HttpSession session) {
		
		try{
		User u = entityManager.createQuery("from User where email = :email and password = :password",User.class)
				.setParameter("email", user.getEmail())
				.setParameter("password", user.getPassword())
				.getSingleResult();
		if(u!=null){
    		session.setAttribute("user", u.getId());
		return u;}
		else{
			return null;
		}
		
		}
		
		catch(Exception e){System.out.println(e.getMessage());
		return null;}
	}
	
	@Override
	public User getStudent(User user){
		try{
			User s = entityManager.createQuery("from User where isStudent = :true",User.class)
					.getSingleResult();
			
			return s;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public User getAdmin(User user){
		try{
			User admin = entityManager.createQuery("from User where isAdmin = :true",User.class)
					.getSingleResult();
			
			return admin;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public User getStaff(User user){
		try{
			User staff = entityManager.createQuery("from User where isStaff = :true",User.class)
					.getSingleResult();
			
			return staff;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	


}