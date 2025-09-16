package com.thc.sprbasic2025fall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/writing")
@RestController
public class WritingRestController {

    List<Map<String, Object>> list = new ArrayList<>();
    int order = 0;

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {
        String title = (String) params.get("title");
        String content = (String) params.get("content");
        int id = ++order;

        Map<String, Object> map_writing = new HashMap<>();
        map_writing.put("title", title);
        map_writing.put("content", content);
        map_writing.put("id", id);

        list.add(map_writing);

        Map<String, Object> map_return = new HashMap<>();
        map_return.put("resultCode", 200);
        map_return.put("id", id);

        return map_return;
    }

    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> map_return = new HashMap<>();
        map_return.put("data", list);
        map_return.put("resultCode", 200);
        return map_return;
    }

    public Map<String, Object> getData(int id) {
        Map<String, Object> map_writing = null;
        for(Map<String, Object> each : list) {
            if(each.get("id").equals(id)) {
                map_writing = each;
                break;
            }
        }
        return map_writing;
    }

    @GetMapping("/detail")
    public Map<String, Object> detail(int id) {
        Map<String, Object> map_return = new HashMap<>();
        map_return.put("data", getData(id));
        map_return.put("resultCode", 200);
        return map_return;
    }

}
