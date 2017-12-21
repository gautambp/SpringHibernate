package self.learning.spring_web.test.junit;

import javax.sql.DataSource;
import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import self.learning.spring_web.daos.UserDAO;
import self.learning.spring_web.daos.UserVO;

@ActiveProfiles("junit")
//@TestPropertySource("/jdbc.properties")
@ContextConfiguration(locations= {
		"classpath:self/learning/spring_web/contexts/dao-context.xml",
		"classpath:self/learning/spring_web/contexts/security-context.xml",
		"classpath:self/learning/spring_web/test/config/test_db_config.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from s_users where username = 'testuser'");
	}
	
	@Test
	public void testUserCreate() {
		UserVO userVO = new UserVO();
		userVO.setUsername("testuser");
		userVO.setEmail("junk@email.com");
		userVO.setPassword("somepassword");
		userVO.setAuthority("ROLE_USER");
		userVO.setName("some name");
		userVO.setStatus("A");
		Assert.assertTrue("User creation failed", this.userDAO.create(userVO));
		Assert.assertTrue(this.userDAO.exists("testuser"));
		userVO = null;
		for (UserVO u : this.userDAO.find()) {
			if (u.getUsername().equals("testuser")) {
				userVO = u;
				break;
			}
		}
		Assert.assertNotNull(userVO);
		Assert.assertEquals("junk@email.com", userVO.getEmail());
		Assert.assertEquals("ROLE_USER", userVO.getAuthority());
		Assert.assertEquals("some name", userVO.getName());
		Assert.assertEquals("Comparing user status", "A", userVO.getStatus());
	}
}
