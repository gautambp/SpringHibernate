package self.learning.spring_web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import self.learning.spring_web.daos.UserDAO;
import self.learning.spring_web.daos.UserVO;

@Service
public class UserService implements UserDetailsService {
	private UserDAO userDAO;
	
	@Autowired
	public void setOfferDAO(UserDAO dao) {
		this.userDAO = dao;
	}
	
	public boolean createUser(UserVO user) {
		return userDAO.create(user);
	}
	
	public boolean exists(String username) {
		return userDAO.exists(username);
	}
	
	public UserVO getUser(String username) {
		return userDAO.get(username);
	}

	public List<UserVO> getUsers() {
		return userDAO.find();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO user = userDAO.get(username);
		if (user == null) throw new UsernameNotFoundException("Username (" + username + ") not found");
		boolean enabled = (user.getStatus().equals('A'));
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getAuthority()));
		return new User(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		//return null;
	}
}
