package self.learning.spring_web.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	private static Logger logger = Logger.getLogger(HomeController.class.getName());
	
	@RequestMapping("/")
	public String showHome() {
		logger.log(Level.INFO, "Home page requested");
		return "home";
	}

	@RequestMapping(value="/jsonAjaxTest", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> getCount() {
		int count = new Random().nextInt();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("count", count);
		return data;
	}
}
