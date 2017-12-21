package self.learning.spring_web.controllers;

import java.security.Principal;
import java.util.Random;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import self.learning.spring_web.daos.OfferVO;
import self.learning.spring_web.services.OfferService;
import self.learning.spring_web.services.UserService;

@Controller
public class OfferController {
	private OfferService offerService;
	private UserService userService;

	@Autowired
	public void setOfferService(OfferService service) {
		this.offerService = service;
	}

	@Autowired
	public void setUserService(UserService service) {
		this.userService = service;
	}
	
	@RequestMapping(value="/offers", method=RequestMethod.GET)
	public String showOffers(Model model) {
		model.addAttribute("offers", offerService.getOffers());
		return "offers";
	}

	@RequestMapping("/offers/new")
	public String showOffersNew(Model model) {
		OfferVO offer = new OfferVO();
		model.addAttribute("offerVO", offer);
		return "newOffer";
	}

	@RequestMapping(value="/offers/create", method=RequestMethod.POST)
	public String showOffersCreate(Model model, @Valid OfferVO offerVO, BindingResult result, Principal p) {
		if (result.hasErrors()) {
			return "newOffer";
		} else {
			//int id = new Random().nextInt();
			// To simulate exception try to create with id 1 again
			//offerVO.setId(1);
			//offerVO.setId(id);
			offerVO.setUser(userService.getUser(p.getName()));
			offerService.createOffer(offerVO);
		}
		return "offerCreated";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Model model, Exception e) {
		model.addAttribute("exceptionMessage", e.getMessage());
		return "error";
	}
}
