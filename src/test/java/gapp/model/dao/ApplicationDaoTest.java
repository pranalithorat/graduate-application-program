/*package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "ApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
    ApplicationDao applicationDao;
	

	
	@Test
    public void getTerms()
    {
		Integer id = applicationDao.getDeptId("Accounting Department").getDeptId();
        assert applicationDao.getTerms(id, "Fall 2016").size() == 1;
    }



}
*/