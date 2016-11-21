package gapp.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import gapp.model.User;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.UserDao;
import gapp.web.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
    private UserDao userDao;
   
	@Autowired
	private ApplicationDao applicationDao;
	 
    @Autowired
    UserValidator userValidator;
    
    @RequestMapping(value = "/user/login.html", method = RequestMethod.GET)
    public String add( ModelMap models )
    {
    	models.put( "user", new User() );
    	
    	return "user/login";
		
    }
    
    @RequestMapping(value = "/user/login.html", method = RequestMethod.POST)
    public String login( @ModelAttribute User user,BindingResult bindingResult,HttpSession session, ModelMap models)
    {
    	
        	User u=userDao.checkLogin(user, session);
        	
        	if(u!=null)
        	{
        		if(u.isAdmin()==true)
        		{
        			return "redirect:/user/admin.html";
        		}
        		if(u.isStaff()==true)
        		{
        			return "user/staff";
        		}
        		if(u.isStudent()==true)
        		{
        			//getting userid
        			int id=u.getId();
        			models.put("id",id);
        			return "redirect:/user/student.html";
        		}

        		return "user/login";
        	}
        	return null;
       
    }
    
    @RequestMapping("/user/logout.html")
    public String logout(ModelMap models,HttpSession session){
    	
    	
    	session.invalidate();
    	return "redirect:/user/login.html";
    }
	
    
   
    @RequestMapping(value = "/user/student.html", method = RequestMethod.GET)
    public String student( ModelMap models , @RequestParam Integer id)
    {
    
		//List<Application> a = applicationDao.getApplication(id);
		models.put("application", applicationDao.getApplication(id));
		
		
    	return "/user/student";
		
    }
    
  

}
