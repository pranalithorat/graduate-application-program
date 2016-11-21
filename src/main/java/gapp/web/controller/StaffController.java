package gapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import gapp.model.User;

@Controller
@SessionAttributes("user")
public class StaffController {
	
	@RequestMapping(value = "/user/staff.html", method = RequestMethod.GET)
    public String add( ModelMap models )
    {
    	models.put( "user", new User() );
    	
    	return "user/staff";
		
    }

}
