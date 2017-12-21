package self.learning.spring_web.daos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import self.learning.spring_web.validation.ValidEmail;

@Entity
@Table(name="s_users")
public class UserVO {

	@NotBlank
	@Size(min=8, max=15)
	@Pattern(regexp="^\\w{8,}$")
	@Id
	private String username;
	
	@Size(min=5, max=100, message="Name must be between 5 & 100 chars")
	private String name;

	//@Pattern(regexp=".*\\@.*\\..*", message="This is not a valid email")
	@NotNull
	@ValidEmail
	private String email;

	@NotBlank
	//@Size(min=8, max=15)
	private String password;
	private String authority;
	private String status;
	
	public UserVO() {
	}

	public UserVO(String uName, String name, String email, String pwd) {
		this.username = uName;
		this.name = name;
		this.email = email;
		this.password = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserVO [username=" + username + ", name=" + name + ", email="
				+ email + ", authority=" + authority + ", status=" + status
				+ "]";
	}
	
}
