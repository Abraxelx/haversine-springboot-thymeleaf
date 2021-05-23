package com.abraxel.haversine.controller;

import com.abraxel.haversine.model.Haversine;
import com.abraxel.haversine.service.HaversineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HaversineController {

    @Autowired
    HaversineService haversineService;

    @GetMapping
    String getDistanceView(Model model){
        Haversine haversine = new Haversine();
        model.addAttribute("haversine", haversine);
        return "distanceView";
    }

    @PostMapping("/saveCoordinates")
    public ModelAndView saveForm(@ModelAttribute(value = "haversine") Haversine haversine){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("distanceView");
        modelAndView.addObject("result", haversineService.getDistance(haversine));
        return modelAndView;
    }
}
