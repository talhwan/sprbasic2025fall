package com.thc.sprbasic2025fall.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/writing")
@Controller
public class WritingPageController {
    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "writing/" + page;
    }
    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "writing/" + page;
    }
}
