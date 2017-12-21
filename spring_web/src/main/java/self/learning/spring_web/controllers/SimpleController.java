package self.learning.spring_web.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {
	
	@RequestMapping("/0")
	public String showHome() {
		return "simple";
	}

	@RequestMapping("/1")
	public ModelAndView showHome(HttpSession session) {
		ModelAndView mv = new ModelAndView("simple");
		Map<String, Object> model = mv.getModel();
		model.put("message", "Hello");
		session.setAttribute("message", "World!!");
		return mv;
	}

	@RequestMapping("/2")
	public String showHome(Model model, HttpSession session) {
		model.addAttribute("message", "<b>Hello</b>");
		session.setAttribute("message", "World!!");
		return "simple";
	}

	@RequestMapping(value="/3", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println(id);
		return "home";
	}
	
	@RequestMapping("/dbTest")
	public String showDBTest() {
		return "dbTest";
	}
}
