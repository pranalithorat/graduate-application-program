package gapp.model.dao.jpa;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AdditionalField;
import gapp.model.Application;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.dao.DepartmentDao;

@Repository
public class DeptDaoImpl implements DepartmentDao{
	
	@PersistenceContext
    private EntityManager entityManager;

	 @Override
    public Department getDept( Integer deptId )
    {
    	
        return entityManager.find( Department.class, deptId );
    }
	 

	 @Override
	 public List<Department> getDepts()
    {
        return entityManager.createQuery( "from Department order by deptId", Department.class )
            .getResultList();
    }

	
	 @Override
	    public HashMap<Integer,HashMap<String,Integer>> getDepartmentByName()
	    {
		 
		 HashMap<Integer,HashMap<String,Integer>> deptIdMap = new HashMap<Integer,HashMap<String,Integer>>();
		 HashMap<String,Integer> deptMap = new HashMap<String,Integer>();
		 Integer deptId = null;
		 List<Department> deptList = entityManager.createQuery( "from Department", Department.class ).getResultList();
		 for(Department department : deptList){
			 deptId = department.getDeptId();
			 List<Program> programs = entityManager.createQuery("from Program where dept ='"+department.getDeptId()+"'",Program.class)
					.getResultList();
			 deptMap.put(department.getDeptName(), programs.size());
			 deptIdMap.put(deptId, deptMap);
			 deptMap = new HashMap<String,Integer>();
			
		 }
	     	
	        return deptIdMap;
	    }
	 
	 @Override
	 public List<Program> getProgramsByDeptId(Integer deptId)
	 {
		 //finding the department by id
		 Department department = entityManager.find(Department.class,deptId );
		
		
		List<Program> programs = entityManager.createQuery("from Program where dept ='"+department.getDeptId()+"'",Program.class)
						.getResultList();
		
		return programs;

	 }
	 
	 @Override
	 public List<AdditionalField> getAdditionalFields(Integer deptId)
	 {
		 //finding the department by id
		 Department department = entityManager.find(Department.class,deptId );
		
		 List<AdditionalField> addFields = entityManager.createQuery("from AdditionalField where dept = '"+department.getDeptId()+"'",AdditionalField.class)
					.getResultList();
		
		 return addFields;
		
		 
	 }

	 	@Override
	    @Transactional
	    public Department saveDepartment( Department department )
	    {
	        return entityManager.merge( department );
	    }
	 	
	 	@Override
	    @Transactional
	    public int deleteProgram( Integer prgmId )
	    {
	 		
	 		
	 		Query query = entityManager.createQuery("delete from Program where prgmId = '"+prgmId+"'");
	 		int result = query.executeUpdate();
	 		return result;
	 		
	    }
	 	
	 	@Override
	    @Transactional
	    public int deleteAdditionalFields( Integer addFieldId )
	    {
	          Query query =entityManager.createQuery("delete from AdditionalField where addFieldId='"+addFieldId+"'");
	          int result = query.executeUpdate();
	          return result;
	    }

		@Override
		@Transactional
		public Program saveProgram(Program program) {
			return entityManager.merge(program);
			
		}
		

		@Override
		@Transactional
		public AdditionalField saveAdditionalFields(AdditionalField addF) {
			return entityManager.merge(addF);
		}


		@Override
		public Set<Program> getProgramsByDeptName(String deptName) {
			// TODO Auto-generated method stub
			return null;
		}

/*
		@Override
		public Set<Program> getProgramsByDeptName(String deptName) {
			
			Department dept = entityManager.createQuery("from Department where deptName='"+deptName+"'",Department.class).getSingleResult();
			 List<Program> prgms = entityManager.createQuery("from Program where dept = '"+dept.getDeptId()+"'",Program.class)
						.getResultList();
			 
			 Set<Program> prgmSet = new HashSet<Program>();
			 for(Program p : prgms){
				 prgmSet.add(p);
			 }
			 return prgmSet;
			
		}*/
		
}
