package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Application;
import gapp.model.User;
import gapp.model.dao.StudentApplicationDao;

@Repository
public class StudentApplicationDaoImpl implements StudentApplicationDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Override
	public List<Application> getStudentApplications(String username) {
		
		String email =  username+"@localhost.localdomain";
		
		User user = entityManager.createQuery( "from User where email='"+email+"'", User.class )
				 .getSingleResult();
	   
		return (List<Application>) user;
	}
	
	

	
}
