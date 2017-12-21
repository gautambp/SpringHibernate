package self.learning.spring_web.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
@Repository
public class UserDAO {

//	private NamedParameterJdbcTemplate jdbc;
//	@Autowired
//	public void setDataSource(DataSource ds) {
//		jdbc = new NamedParameterJdbcTemplate(ds);
//	}

	private PasswordEncoder passwordEncoder;
	@Autowired
	public void setPasswordEncoder(PasswordEncoder encoder) {
		this.passwordEncoder = encoder;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	// since we're making more than one jdbc updates, make this method transactional
	//@Transactional()
	public boolean create(UserVO user) {
		String encryptedPwd = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPwd);
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);		
//		return jdbc.update("insert into s_users (username, password, email, status, authority, name) values (:username, :password, :email, :status, :authority, :name)", params) == 1;
		Session s = session();
		Transaction t = s.beginTransaction();
		s.persist(user);
		s.flush();
		t.commit();
		return true;
	}
	//@Transactional
	public UserVO get(String username) {
		Session s = session();
		Transaction t = s.beginTransaction();
		UserVO user = s.byId(UserVO.class).load(username);
		t.commit();
		return user;
	}

	//@Transactional
	public boolean exists(String username) {
		UserVO user = get(username);
		if (user == null) return false;
		return true;
	}

	//@Transactional
	public List<UserVO> find() {
		Session s = session();
		Transaction t = s.beginTransaction();
		List<UserVO> users = s.createQuery("from UserVO").list();
		t.commit();
		return users;
//		return jdbc.query("select * from s_users", 
//				new RowMapper<UserVO>() {
//
//			@Override
//			public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				UserVO user = new UserVO();
//				user.setUsername(rs.getString("username"));
//				user.setEmail(rs.getString("email"));
//				user.setAuthority(rs.getString("authority"));
//				user.setStatus(rs.getString("status"));
//				user.setName(rs.getString("name"));
//				return user;
//			}
//		});
	}
}
