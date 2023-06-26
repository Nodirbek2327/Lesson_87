package com.example.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HomeController {

    @RequestMapping("/current/time")
    public String getTime() {
        System.out.println("Keldi");
        return LocalDateTime.now().toString();
    }

    @RequestMapping("/greeting/{name}") // greeting/Ali
    public String greeting(@PathVariable("name") String namejon) {
        System.out.println(namejon);
        return "Hello " + namejon;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //  ip:port/login?login=mazgi&password=12345
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password) {
        System.out.println(login + " " + password);
        return "Login api";
    }





}
