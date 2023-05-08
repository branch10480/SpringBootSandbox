package com.example.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FowardAndRedirect {
    private boolean flag = false;
    
    @GetMapping("/far")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "/far/indexのページです");
        return mav;
    }
    
    @GetMapping("/far/redirect")
    public String redirect() {
        return "redirect:/far";
    }
    
    @GetMapping("/far/forward")
    public ModelAndView forward() {
        // mavを返す場合は新しく生成して返す
        ModelAndView mav = new ModelAndView("forward:/far");
        return mav;
    }
    
    @GetMapping("/switch")
    public ModelAndView flagSwitch(ModelAndView mav) {
        flag = !flag;
        mav.addObject("flag", flag);
        mav.setViewName("switch");
        return mav;
    }
    
    @GetMapping("/recursive")
    public ModelAndView recursive(ModelAndView mav) {
        String[] list = new String[] {"Apple", "Orange", "Lemon"};
        mav.setViewName("recursive");
        mav.addObject("list", list);
        return mav;
    }
    
}
