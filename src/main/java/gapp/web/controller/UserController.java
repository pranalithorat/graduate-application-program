package gapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import gapp.model.User;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.UserDao;
import gapp.web.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserDao userDao;
   
    
    @Autowired
    UserValidator userValidator;
    
    @Autowired
	DepartmentDao deptDao;
    

    
    @RequestMapping("/user/list.html")
    public String list( ModelMap models )
    {
    	//List<User> users= userDao.getUsers();
        models.put( "users", userDao.getUsers() );
        return "user/list";
    }
    
   
    @RequestMapping("/user/view.html")
    public String view( @RequestParam Integer id,ModelMap models )
    {
    	models.put( "user", userDao.getUser(id));
        return "user/view";
    }
    
   
    @RequestMapping(value = "/user/add.html", method = RequestMethod.GET)
    public String add( ModelMap models )
    {
    	models.put( "user", new User() );
    	
    	return "user/add";
		
    }

    @RequestMapping(value = "/user/add.html", method = RequestMethod.POST)
    public String add( @ModelAttribute User user,BindingResult bindingResult)
    {
    		
    	
    	userValidator.validate( user, bindingResult );
        if( bindingResult.hasErrors() ) {
        	return "user/add";
        }
        
        user.setStudent(true);
        userDao.saveUser( user );
        
     
        return "redirect:/user/login.html";
    	
    	
       
    }
    
    @RequestMapping(value = "/user/edit.html", method = RequestMethod.GET)
    public String edit( @RequestParam Integer id, ModelMap models )
    {
        models.put( "user", userDao.getUser( id ) );
        return "user/edit";
    }
    
    @RequestMapping(value = "/user/edit.html", method = RequestMethod.POST)
    public String edit( @ModelAttribute User user, BindingResult bindingResult,
            SessionStatus sessionStatus)
    {
    	 userValidator.validate( user, bindingResult );
         if( bindingResult.hasErrors() ) return "user/edit";

         userDao.saveUser( user );
         
         sessionStatus.setComplete();
         return "redirect:list.html";
    	
    	/*//save user to database
    	user= userDao.saveUser(user);
    	
    	//it will remove the session object after the session is over
    	 sessionStatus.setComplete();
    	 
    	//redirect user to list
    	return "redirect:list.html";*/
    	
       
    }

}