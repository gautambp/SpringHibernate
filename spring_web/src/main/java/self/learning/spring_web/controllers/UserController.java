package self.learning.spring_web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import self.learning.spring_web.daos.UserVO;
import self.learning.spring_web.services.UserService;

@Controller
public class UserController {
	private UserService userService;
	private MessageSource messageSource; 
	
	@Autowired
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@RequestMapping("/users")
	public String showUsers(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "users";
	}
	
	@RequestMapping("/users/new")
	public String showUsersNew(Model model) {
		model.addAttribute("userVO", new UserVO());
		return "newUser";
	}
	
	@RequestMapping(value="/users/create", method=RequestMethod.POST)
	public String showUsersCreate(Model model, @Valid UserVO userVO, BindingResult result) {
		if (result.hasErrors()) {
			return "newUser";
		} else {
			if (userService.exists(userVO.getUsername())) {
				result.rejectValue("username", "DuplicateKey.userVO.username");
				return "newUser";
			}
			userVO.setAuthority("ROLE_USER");
			userVO.setStatus("A");
			userService.createUser(userVO);
		}
		return "userCreated";
	}

}
