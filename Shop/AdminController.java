package ua.com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.shop.service.BagService;

@Controller
public class AdminController {

	@Autowired
	private BagService bagService;
//hay
	@RequestMapping(value="/Allbags", method=RequestMethod.GET)
	public String showBag(Model model){
		model.addAttribute("bags", 
				bagService.findAll());
		return "views-admin-Allbags";
	}
	
	
}
