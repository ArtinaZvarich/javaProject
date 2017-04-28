package ua.com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShopController {

	
	@RequestMapping(value="/basket", method=RequestMethod.GET)
	public String basket(){
		
		return "views-user-basket";
	}

	
}