package com.example.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/c/{name}")
    public String hello(@PathVariable int name) {
        switch (name) {
            case 1:
                return "hello";
            default:
                return "hello2";
        }
    }

    @GetMapping("/hello3/{name}")
    public String hello3(@PathVariable String name, Model model) {
        model.addAttribute(name);
        return "hello3";
    }
    
    @GetMapping("mav/{name}")
    public ModelAndView modelAndView(@PathVariable String name, ModelAndView mav) {
        mav.addObject(name);
        mav.setViewName("hello3");
        return mav;
    }
}
