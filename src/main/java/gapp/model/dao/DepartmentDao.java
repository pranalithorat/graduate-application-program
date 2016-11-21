package gapp.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import gapp.model.AdditionalField;
import gapp.model.Application;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.User;

public interface DepartmentDao {

	Department getDept( Integer id );
	
	List<Department> getDepts();

	HashMap<Integer, HashMap<String, Integer>> getDepartmentByName();

	Department saveDepartment(Department department);

	List<Program> getProgramsByDeptId(Integer deptId);
	
	Set<Program> getProgramsByDeptName(String deptName);

	List<AdditionalField> getAdditionalFields(Integer deptId);

	AdditionalField saveAdditionalFields(AdditionalField addF);

	Program saveProgram(Program prgm);

	int deleteProgram(Integer prgmId);

	int deleteAdditionalFields(Integer addFieldId);
	
	

	
} 
