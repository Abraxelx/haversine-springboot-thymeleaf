package com.abraxel.haversine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DistanceController {

    @GetMapping
    String getDistanceView(){
        return "distanceView";
    }
}
