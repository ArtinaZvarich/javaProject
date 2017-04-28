package ua.com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class IndexController {
	

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String start(){
		
		return "views-home-index";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String starth(){
		
		return "views-home-index";
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public String contact(){
		
		return "views-home-contact";
	}
	
	@RequestMapping(value="/aboutus", method=RequestMethod.GET)
	public String abutus(){
		
		return "views-home-aboutus";
	}
	
	@RequestMapping(value="/base", method=RequestMethod.GET)
	public String admin(){
		
		return "views-admin-base";
	}
	
}
