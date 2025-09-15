package com.thc.sprbasic2025fall.controller;

import com.thc.sprbasic2025fall.dto.MultipleBasket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api") // 모든 메서드에 앞에 붙는 메핑!!!
@RestController // 페이지 리턴이 아니라, 객체 리턴할꺼에요!
public class DefaultRestController {

    @RequestMapping("/add")
    public Map<String, Object> add(int a, int b) {
        int sum = a + b;
        Map<String, Object> map = new HashMap<>();
        map.put("resultCode", 200);
        map.put("sum", sum);
        return map;
    }

    //과제!
    @RequestMapping("/multiple")
    public Map<String, Object> multiple(int a, int b) {
        Map<String, Object> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);

        int a_1 = Integer.parseInt(a + "");
        int b_1 = Integer.parseInt(b + "");

        int result = a * b;
        Map<String, Object> result_map = new HashMap<>();
        result_map.put("resultCode", 200);
        result_map.put("result", result);
        return result_map;
    }

    @RequestMapping("/multiple2")
    public Map<String, Object> multiple2(@RequestParam Map<String, Object> param) {
        int a = Integer.parseInt(param.get("a") + "");
        int b = Integer.parseInt(param.get("b") + "");
        int result = a * b;
        Map<String, Object> result_map = new HashMap<>();
        result_map.put("resultCode", 200);
        result_map.put("result", result);
        return result_map;
    }
    @RequestMapping("/multiple3")
    public Map<String, Object> multiple3(MultipleBasket param) {
        int a = param.getA();
        int b = param.getB();
        int result = a * b;
        Map<String, Object> result_map = new HashMap<>();
        result_map.put("resultCode", 200);
        result_map.put("result", result);
        return result_map;
    }


}
