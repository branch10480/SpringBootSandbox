package com.example.demo3;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    
    @GetMapping("/form")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("form");
        mav.addObject("msg", "名前を書いてください");
        return mav;
    }
    
    @PostMapping("/form")
    public ModelAndView indexPost(ModelAndView mav, @RequestParam("text1") String name) {
        mav.addObject("msg", "ようこそ" + name + "さん");
        mav.setViewName("form");
        mav.addObject("value", name);
        return mav;
    }
    
    @GetMapping("/form/detail")
    public ModelAndView formDetail(ModelAndView mav) {
        mav.setViewName("form2");
        return mav;
    }
    
    @PostMapping("/form/detail")
    public ModelAndView formDetailPost(
        ModelAndView mav,
        // required = false にしたものは、 null の可能性も考慮すること！
        @RequestParam(value = "check1", required = false) boolean check1,
        @RequestParam(value = "radio1", required = false) String radio1,
        @RequestParam(value = "select1", required = false) String select1,
        @RequestParam(value = "select2", required = false) String[] select2
    ) {
        ArrayList<String> msgs = new ArrayList<>();
        msgs.add(check1 ? "チェック済み" : "未チェック");
        msgs.add(radio1);
        msgs.add(select1);
        if (select2 != null) {
            msgs.add(String.join(",", select2));
        }
        String msg = String.join(" | ", msgs);
        mav.addObject("msg", msg);
        mav.setViewName("form2");
        return mav;
    }
}
