package ua.com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.service.BagImageService;
import ua.com.shop.service.BagService;

@Controller
public class BagImagesController {


    @Autowired
    private BagImageService bagImageService;
    @Autowired
    private BagService bagService;

    @GetMapping("/addImages/{idBag}")
    public String addImage(@PathVariable String idBag, Model model){

        model.addAttribute("bag", bagService.findOne(Integer.parseInt(idBag)));

        return "views-admin-addBagImage";
    }

    @PostMapping("/saveManyImages/{idBag}")
    public String saveManyImages(@PathVariable String idBag, @RequestParam MultipartFile[] images){

        bagImageService.saveImage(Integer.parseInt(idBag), images);


        return "redirect:/addBagImages";

    }


}
