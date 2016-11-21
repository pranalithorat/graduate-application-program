/*package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "StudentApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests{

	@Autowired
	StudentApplicationDao studDao;
	
	@Test
    public void getStudentApplications()
    {
        assert studDao.getStudentApplications("student1").size() == 1;
    }

	
	
}
*/