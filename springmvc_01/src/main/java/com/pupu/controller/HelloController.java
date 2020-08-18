package com.pupu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : lipu
 * @since : 2020-03-10 16:18
 */
@Controller
public class HelloController {


    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("Hello springMVC");
        return "success";
    }
}
