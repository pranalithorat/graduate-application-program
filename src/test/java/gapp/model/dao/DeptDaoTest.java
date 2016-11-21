/*package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "DeptDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DeptDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
	DepartmentDao deptDao;
	
	

	 @Test
	    public void getDepts()
	    {
	        assert deptDao.getDepts().size() == 2;
	    }

	 @Test
	    public void getDepartmentByName()
	    {
	        assert deptDao.getDepartmentByName() != null;
	    }
}
*/