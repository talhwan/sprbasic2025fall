package com.thc.sprbasic2025fall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DefaultController {

    @ResponseBody
    @RequestMapping("/multiples")
    public String[] multiples() {
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                System.out.println(i+"*"+j+"="+(i*j));
            }
        }
        String[] result = {"1", "2"};
        return result;
    }

    @ResponseBody
    @RequestMapping("/test")
    public List test(){

        int a = 0;
        double double_a = 0.0;
        boolean boolean_a = false;
        String string_a = "";

        for(int i=0;i<10;i++){
            System.out.println(i);
        }
        String[] array_a = {"1", "2"};
        for(int i=0;i<array_a.length;i++){
            String each = array_a[i];
            System.out.println(each);
        }
        for(String each : array_a){
            System.out.println(each);
        }

        if(a > 0){

        } else {

        }

        //
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("key_a", "value_a");
        String a_value = (String) a_map.get("key_a");

        List<String> a_list = new ArrayList<>();
        a_list.add("value_a");
        a_list.add("value_b");
        String string_0 = a_list.get(0);


        return a_list;
    }

}
