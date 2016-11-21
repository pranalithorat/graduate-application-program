package gapp.model.dao;

import java.util.List;

import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Department;
import gapp.model.EducationalBackground;
import gapp.model.Program;

public interface ApplicationDao {

	Department getDeptId(String dept_name);
	
	Department getDeptId(Integer deptId);
	
	Program getPrgmId(String prgm_name);

	List<Application> getTerms(Integer dept_Id, String term);

	List<Application> getApplication(Integer id);

	Application getApp(Integer id);

	Application saveApplication(Application app);
	
	ApplicationStatus saveApplicationStatus(ApplicationStatus apps);

	List<Application> getEckBckgrnd(Integer id);
	
	List<Program> getProgram(Integer deptId);
	
	List<EducationalBackground> getEducationalBckgrnd(Integer appId);

	EducationalBackground saveEducationalBackground(EducationalBackground edu);

	int deleteEduBckGrnd(Integer edu);
	
/*	Application getStatus(String status);*/
}
