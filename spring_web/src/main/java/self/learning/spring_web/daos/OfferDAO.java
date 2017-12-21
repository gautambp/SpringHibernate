package self.learning.spring_web.daos;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OfferDAO {

//	private NamedParameterJdbcTemplate jdbc;
//	@Autowired
//	public void setDataSource(DataSource ds) {
//		jdbc = new NamedParameterJdbcTemplate(ds);
//	}

	@Autowired
	private SessionFactory sessionFactory;
	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public List<OfferVO> find() {
		return session().createQuery("from OfferVO").list();
//		return jdbc.query("select * from s_offer o, s_users u where o.username = u.username", new RowMapper<OfferVO>() {
//
//			@Override
//			public OfferVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				UserVO user = new UserVO();
//				user.setUsername(rs.getString("username"));
//				user.setEmail(rs.getString("email"));
//				user.setAuthority(rs.getString("authority"));
//				user.setStatus(rs.getString("status"));
//				user.setName(rs.getString("name"));
//
//				OfferVO offer = new OfferVO();
//				offer.setId(rs.getInt("id"));
//				offer.setText(rs.getString("text"));
//				offer.setUser(user);
//				return offer;
//			}
//		});
	}
	
	@Transactional(readOnly=false)
	public boolean create(OfferVO offer) {
		session().save(offer);
		return true;
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);		
//		return jdbc.update("insert into s_offer (id, text, username) values (:id, :text, :username)", params) == 1;
	}
}
