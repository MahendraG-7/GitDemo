package com.example.GitDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/demo")
public class DemoController {

    //@GetMapping
    public String message(){
        System.out.println("feature 1 added");
        return "git demo !!!!";
    }

    //@GetMapping
    public String message1(){
        System.out.println("feature 1 added");
        System.out.println("fe4ture 1 added");
        return "git demo !!!!";
    }


}
