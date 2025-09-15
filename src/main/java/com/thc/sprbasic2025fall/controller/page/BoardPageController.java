package com.thc.sprbasic2025fall.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardPageController {
    @RequestMapping("/index")
    public String index(){
        return "board/index";
    }
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "board/" + page;
    }
}
