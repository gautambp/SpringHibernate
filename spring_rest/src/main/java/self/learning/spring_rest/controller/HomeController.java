package self.learning.spring_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import self.learning.spring_rest.dao.PersonRepository;
import self.learning.spring_rest.domain.Person;

@Controller
public class HomeController {

	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(value = "/index")
	public String index() {
		Person p = new Person();
		p.setName("first last");
		p.setLocation("some location");
		personRepository.save(p);
		return "index";
	}
}
