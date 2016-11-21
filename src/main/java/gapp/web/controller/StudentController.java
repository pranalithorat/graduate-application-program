/*package gapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import gapp.model.Application;
import gapp.model.Department;
import gapp.model.User;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.StudentApplicationDao;
import gapp.model.dao.UserDao;

@Controller
@SessionAttributes("user")
public class StudentController {
	
	@Autowired
    private UserDao userDao;
	
	@Autowired
	private StudentApplicationDao studentDao;
	
	@Autowired
	private ApplicationDao applicationDao;
	
	@RequestMapping(value = "/user/student.html")
    public String student( ModelMap models , @RequestParam Integer user_id)
    {
		Department dept= applicationDao.getDeptId(deptname);
		models.put("deptname", deptname);
		//models.put("term", dept.getTerms());
		
    	Application appli = new Application();
    	appli.getDepartment();
    	appli.getTerm();
		
		models.put("application", applicationDao.getApplication(user_id));
		
    	
		//models.put( "user", new User() );
    	return "/user/student";
		
    }
	
	
}
*/