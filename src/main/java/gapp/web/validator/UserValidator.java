package gapp.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gapp.model.Application;
import gapp.model.Department;
import gapp.model.User;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.UserDao;

@Component
public class UserValidator implements Validator{
	
	 @Autowired
	  UserDao userDao;
	 
	 @Autowired
	 DepartmentDao deptdao;

	//validates all objects of user class and its subclases
	//clazz is subclass of User
	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user=(User)target;
		Integer id = user.getId();
	
		
		if( !StringUtils.hasText( user.getFname() ) )
            errors.rejectValue( "fname", "error.fname.required" );
		
		if( !StringUtils.hasText( user.getLname() ) )
            errors.rejectValue( "lname", "error.lname.required" );
		
		if( !StringUtils.hasText( user.getEmail() ) )
            errors.rejectValue( "email", "error.email.required" );

        if( !StringUtils.hasText( user.getPassword() ) )
            errors.rejectValue( "password", "error.password.required" );
        
        String email = user.getEmail();
        if( StringUtils.hasText( email ) )
        {
            User u = userDao.getUserByEmail( email );
            if( u != null && !u.getId().equals( id) )
                errors.rejectValue( "email", "error.email.required" );
        }
        
		
	}
	

}
