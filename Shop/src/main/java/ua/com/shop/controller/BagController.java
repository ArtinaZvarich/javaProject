package ua.com.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.dto.DtoUtilMapper;
import ua.com.shop.dto.BagDTO;
import ua.com.shop.entity.Bag;
import ua.com.shop.service.BagService;

@Controller
public class BagController {

	@Autowired
	private BagService bagService;
		
	@RequestMapping(value = {"/addBag"}, method = RequestMethod.GET)
	public String addBag(Model model) {


		return "views-admin-addBag";
	}

	@RequestMapping(value = "/saveBag", method = RequestMethod.POST)
	public String saveBook(@RequestParam String name,
						   @RequestParam String element,
						   @RequestParam String fabric,
						   @RequestParam String color,
						   @RequestParam String size,
						   @RequestParam String collection,
						   @RequestParam int price,
						   
						   @RequestParam MultipartFile image) {

		Bag bag = new Bag();
		bag.setName(name);
		bag.setElement(element);
		bag.setFabric(fabric);
		bag.setColor(color);
		bag.setSize(size);
		bag.setCollection(collection);
		bag.setPrice(price);
	

		bagService.save(bag, image);



		return "redirect:/addBag";
	}

	

	@RequestMapping(value="/shop", method=RequestMethod.GET)
	public String showBag(Model model){
		model.addAttribute("bags", 
				bagService.findAll());
		return "views-home-shop";
	}

	
	@RequestMapping(value="/deleteBag/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		bagService.delete(id);
		return "redirect:/shop";
	}

}
