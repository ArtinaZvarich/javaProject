package ua.com.shop.controller;

import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.validator.UserValidationMessages;
import ua.com.shop.dto.DtoUtilMapper;
import ua.com.shop.entity.User;
import ua.com.shop.service.MailSenderService;
import ua.com.shop.service.UserService;

@Controller
public class UserController {

	@Autowired
    @Qualifier("userDetailsService")
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		
		return "views-login-login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(){
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/registration")
    public String registration(Model model) {
		model.addAttribute("users", userService.findAll());
        model.addAttribute("user", new User());
 
        return "views-login-registration";
    }
	
	
	@RequestMapping(value = "/registration", method=RequestMethod.POST)
    public String registrationUser(@ModelAttribute User user, Model model) {
		
		String uuid = UUID.randomUUID().toString();
		
		user.setUuid(uuid);
		
		
		try{
        userService.save(user);
		}catch(Exception e){
			model.addAttribute("exception", e.getMessage()+" !!!! ");
		return "views-login-registration";
		}
		
		
		String theme = "thank`s for registration";
		String messege = "ql & hf http://localhost:8080/Shop/confirm/"+uuid;
		
		mailSenderService.sendMail(theme, messege, user.getEmail());
		
        return "redirect:/index";
    }
	
	
	@RequestMapping(value="/confirm/{uuid}", method=RequestMethod.GET)
	public String saveSave (@PathVariable String uuid){
		
		User user = userService.findByUUID(uuid);
		user.setEnabled(true);
		
		userService.update(user);
		
		return "redirect:/";
	}
	

	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String loginprocesing(){
		
		return "redirect:/index";
	}
	
	 @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	    public String saveImage(Principal principal,
	                            @RequestParam MultipartFile image) {

	        userService.saveImage(principal, image);

	        return "redirect:/profile";
	    }
	 
	 @RequestMapping(value = "/profile", method = RequestMethod.GET)
	    public String profile(HttpServletRequest request, Principal principal, Model model) {

	        User user = userService.fetchUserWithBag(Integer.parseInt(principal.getName()));

	        model.addAttribute("user", user);

	        return "views-user-profile";
	    }
	 
	 @RequestMapping(value = "/update", method = RequestMethod.GET)
	    public String update(Principal principal, Model model){
	        User user = userService.findOne(Integer.parseInt(principal.getName()));
	        model.addAttribute("user", user);
	        return "views-user-update";
	    }

	    @RequestMapping(value = "/update", method = RequestMethod.POST)
	    public String update(Principal principal, @RequestParam String phone){
	        User user = userService.findOne(Integer.parseInt(principal.getName()));

	        
	        user.setPhone(phone);

	        userService.update(user);

	        return "redirect:/profile";
	    }
	    
	    @RequestMapping(value = "joinUserWithBook/{idBag}", method = RequestMethod.PUT)
	    public String join(Principal principal, @PathVariable String idBag){

	        userService.join(Integer.parseInt(principal.getName()),Integer.parseInt(idBag));


	        return null;
	    }
	   	    
	    
	   
	    @RequestMapping(value = "/buyBag/{id}", method = RequestMethod.GET)
	    public String buyBag(Principal principal, @PathVariable String id) {

	        userService.buyBag(principal, id);

	        return "redirect:/profile";
	    }
}
