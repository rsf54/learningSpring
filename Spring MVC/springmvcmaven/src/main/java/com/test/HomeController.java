package com.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome(){
        System.out.println("In home controller");
        return "index"; //name of the view to go to
    }


}
