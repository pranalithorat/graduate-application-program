package gapp.model.dao;

import java.util.List;

import gapp.model.Application;

public interface StudentApplicationDao {
	
	List<Application> getStudentApplications(String email);
	
	

	
}
