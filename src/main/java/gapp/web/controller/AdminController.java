
package gapp.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import gapp.model.AdditionalField;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.User;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.jpa.DeptDaoImpl;
import gapp.web.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class AdminController {
	
	@Autowired
	DepartmentDao deptDao;
	
	@Autowired
    UserValidator valid;
	 
	@RequestMapping(value = "/user/admin.html", method = RequestMethod.GET)
    public String add( ModelMap models )
    {
    	models.put( "user", new User() );
    	
    	return "user/admin";
		
    }

	@RequestMapping(value = "/user/deptList.html", method = RequestMethod.GET)
    public ModelAndView deptList( @ModelAttribute HashMap<Integer,HashMap<String,Integer>> deptList )
    {
		HashMap<Integer,HashMap<String,Integer>> deptList1 = deptDao.getDepartmentByName();
    	deptList.putAll(deptList1);
    	
    	return new ModelAndView("user/deptList","deptList",deptList);
    
    }
	
	@RequestMapping(value = "/user/viewDept.html", method = RequestMethod.GET)
    public String viewDept( @RequestParam Integer deptId, ModelMap models  )
    {
		List<Program> programs = deptDao.getProgramsByDeptId(deptId);
		List<AdditionalField> addFields = deptDao.getAdditionalFields(deptId);
		models.put("programs", programs);
		models.put("addFields",addFields);
		Department dept= deptDao.getDept(deptId);
		models.put("deptName", dept.getDeptName());
		models.put("deptId", deptId);
		return "user/viewDept";
    	
    
    }
/*------------------------------------------- Add department ------------------------------------------------*/	
	 
    @RequestMapping(value = "user/addNewDept.html", method = RequestMethod.GET)
    public String addNewDept( ModelMap models )
    {
    	
    	models.put( "department", new Department() );
    	
    	return "user/addNewDept";
		
    }
    
   
    
    @RequestMapping(value = "user/addNewDept.html", method = RequestMethod.POST)
    public String addNewDept( @ModelAttribute Department dept) throws IllegalStateException, IOException
    {
    
        deptDao.saveDepartment( dept );
        
        
        return "redirect:/user/deptList.html";
  
 
    }
  
/*------------------------------------------- Add Program ------------------------------------------------*/	
   
    @RequestMapping(value = "user/addPrograms.html", method = RequestMethod.GET)
    public String addNewPrgm( @RequestParam Integer deptId,@RequestParam Integer add,ModelMap models )
    {
    	models.put( "program", new Program() );
    	
    	return "user/addPrograms";
		
    }

    	
    @RequestMapping(value = "user/addPrograms.html", method = RequestMethod.POST)
    public String addNewPrgm( @RequestParam Integer deptId,@RequestParam Integer add,@ModelAttribute Program program)
    {
    	//retrieving  department object by Id
    	Department dept = deptDao.getDept(deptId);
    	
    	program.setDept(dept);
    	
        deptDao.saveProgram( program );
        if(add == 1){
        	return "redirect:editDepartment.html?deptId=" + deptId;
        }
        return "redirect:/user/deptList.html";

    }
 
    /*------------------------------------------- Add Additional Fields ------------------------------------------------*/	
   
    @RequestMapping(value = "user/addAdditionalFields.html", method = RequestMethod.GET)
    public String addAdditionalFields( @RequestParam Integer deptId,@RequestParam Integer add,ModelMap models )
    {
    	models.put( "additionalFields", new AdditionalField() );
    	
    	return "user/addAdditionalFields";
		
    }

    	
    @RequestMapping(value = "user/addAdditionalFields.html", method = RequestMethod.POST)
    public String addAdditionalFields( @RequestParam Integer deptId,@RequestParam Integer add,@ModelAttribute AdditionalField additionalFields)
    {
    	Department dept = deptDao.getDept(deptId);
    	
    	additionalFields.setDept(dept);
    	
        deptDao.saveAdditionalFields( additionalFields);
        
        if(add == 1){
        	return "redirect:editDepartment.html?deptId=" + deptId;
        }
        return "redirect:/user/deptList.html";
        
      
    }
    
    //----------------------------Edit Department--------------------------------------------------*/
    @RequestMapping(value = "/user/editDepartment",method = RequestMethod.GET)
        public String editDepartment( @RequestParam Integer deptId, ModelMap models )
        {
            
    		Department dept= deptDao.getDept(deptId);
    		models.put("dept", dept);
    		models.put("deptId", deptId);
  
			List<Program> programs = deptDao.getProgramsByDeptId(deptId);
			
			List<AdditionalField> addFields = deptDao.getAdditionalFields(deptId);
			models.put("programs", programs);
			models.put("addFields",addFields);
			
            return "user/editDepartment";
        }

        @RequestMapping(value = "/user/editDepartment",method = RequestMethod.POST)
        public String editDepartment(@RequestParam Integer deptId,@ModelAttribute Department department)
        {
        	deptDao.saveDepartment( department );

           // return "redirect:/user/viewDept";
        	return "redirect:/user/deptList.html";
        }

       

        	
       
     
                    
                    
 //--------------------------------Delete Programs and Additional Fields-------------------------------------------------------------
                    
                    @RequestMapping("/user/deletePrograms")
                    public String deletePrograms( @RequestParam Integer prgmId, @RequestParam Integer deptId, ModelMap models )
                    {
                        int result = deptDao.deleteProgram(prgmId);
                        return "redirect:editDepartment.html?deptId=" + deptId;
                    }
                    
                    @RequestMapping("/user/deleteAdditionalFields")
                    public String deleteAdditionalFields( @RequestParam Integer addFieldId,@RequestParam Integer deptId )
                    {
                        int result = deptDao.deleteAdditionalFields(addFieldId);
                        //deptDao.saveDepartment(department);
                        
                        return "redirect:editDepartment.html?deptId=" + deptId;
                    }
    
}
