package com.thc.sprbasic2025fall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller// 컨트롤러임을 알리기 위해 붙이는 어노테이션!
public class DefaultPageController {

    @RequestMapping("/index") //찾아올수 있는 주소값을 설정한 것입니다!
    public String index(){
        System.out.println("DefaultPageController.index()");
        return "index"; //페이지컨트롤러 리턴값! src->resources->templates 아래에 있는 리턴값, index.html을 찾아서 파씽해줌!!
    }

    @RequestMapping("/add")
    public String add(int a, int b, Model model){
        //파라미터를 받아볼께요!
        // ~~~?key1=value1&key2=value2&key3=value3 (url에 이렇게 적혀 있으면 , 파라미터 사용 가능!)
        System.out.println("DefaultPageController.add()");
        System.out.println("a : " + a);
        System.out.println("b : " + b);

        int sum = a + b;
        System.out.println("sum : " + sum);

        model.addAttribute("sum", sum);

        return "add";
    }

    @RequestMapping("/addstring")
    public String addstring(String a, String b, Model model){
        //두개의 글자를 입력받아서(url에서) 결합해보세요!
        System.out.println("DefaultPageController.addstring()");
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        String result = a + b;
        model.addAttribute("result", result);
        return "addstring";
    }

}
