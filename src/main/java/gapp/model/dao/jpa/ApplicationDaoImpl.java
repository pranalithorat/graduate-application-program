package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Department;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.DepartmentDao;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	DepartmentDao deptDao;

	@Override
	public Department getDeptId(String deptname) {
		return entityManager.createQuery("from Department where deptName = '" + deptname + "'", Department.class)
				.getSingleResult();
	}

	@Override
	public List<Application> getTerms(Integer dept_Id, String term) {

		return entityManager
				.createQuery("from Application where department = '" + dept_Id + "' and term = '" + term + "' ",
						Application.class)
				.getResultList();
	}
	
	 @Override
	@Transactional
	public List<Application> getApplication(Integer id)
	{
		 return entityManager
					.createQuery("from Application where user_id = :id",Application.class)
					.setParameter("id", id)
					.getResultList();
	}

	 @Override
		@Transactional
	 public List<Application> getEckBckgrnd(Integer id)
	 {
		 return entityManager
					.createQuery("from Application where education = :id",Application.class)
					.setParameter("id", id)
					.getResultList();
	 }
	@Override
	public Application getApp(Integer id) {
		return entityManager.find(Application.class, id);
	}

	@Override
	@Transactional
	public Application saveApplication(Application app) {
	
		return entityManager.merge(app);
	}
	 
	@Override
	@Transactional
	public EducationalBackground saveEducationalBackground(EducationalBackground edu) {
	
		return entityManager.merge(edu);
	}

	@Override
	@Transactional
	public int deleteEduBckGrnd(Integer edu) {
		
		Query query = entityManager.createQuery("delete from EducationalBackground where edBckId = '"+edu+"'");
 		int result = query.executeUpdate();
 		return result;
	}

	/* public Application getStatus(String status)
	 {
		 
		 return entityManager.createQuery("from Application where status = '" + status + "'", Application.class)
					.getSingleResult();
	 }
*/
	@Override
	@Transactional
	public Program getPrgmId(String prgm_name) {
		return entityManager.createQuery("from Program where programName = '" + prgm_name + "'", Program.class)
				.getSingleResult();											
	}	

	@Override
	@Transactional
	public Department getDeptId(Integer deptId) {
		return entityManager.createQuery("from Department where deptId = '" + deptId + "'", Department.class)
				.getSingleResult();
	}

	@Override
	@Transactional
	public  List<EducationalBackground> getEducationalBckgrnd(Integer appId) {
		
		return entityManager.createQuery("from EducationalBackground where applicationId = '" + appId + "'", EducationalBackground.class)
				.getResultList();
	}


	@Override
	@Transactional
	public ApplicationStatus saveApplicationStatus(ApplicationStatus apps) {
		return entityManager.merge(apps);
	}

	@Override
	@Transactional
	public List<Program> getProgram(Integer deptId) {
		
		return entityManager.createQuery("from Program where dept = '" + deptId + "'", Program.class)
				.getResultList();
	}

}
