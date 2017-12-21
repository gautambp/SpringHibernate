package self.learning.spring_web.daos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="s_offer")
public class OfferVO {
	
	@Id
	@GeneratedValue
	private int id;
	private String text;
	
	@ManyToOne
	@JoinColumn(name="username")
	private UserVO user;

	public OfferVO() {
		//user = new UserVO();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "OfferVO [id=" + id + ", text=" + text + ", user=" + user + "]";
	}
}
