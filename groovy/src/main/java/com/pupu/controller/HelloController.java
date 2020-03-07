package com.pupu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : lipu
 * @since : 2020-03-07 21:11
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/list")
    public String toList(){
        return "list";
    }
}
