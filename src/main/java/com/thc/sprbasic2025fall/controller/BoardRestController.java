package com.thc.sprbasic2025fall.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    List<Map<String,Object>> list_board;

    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){

        System.out.println("board create");
        System.out.println("title : " + params.get("title"));
        System.out.println("content : " + params.get("content"));

        if(list_board == null){
            list_board = new ArrayList<>();
        }
        Map<String,Object> map_board = new HashMap<>();
        map_board.put("id", list_board.size() + 1);
        map_board.put("title",params.get("title") + "");
        map_board.put("content",params.get("content") + "");

        list_board.add(map_board);

        Map<String, Object> return_map = new HashMap<>();
        return_map.put("resultCode","200");
        return_map.put("id",map_board.get("id"));
        return return_map;
    }
    @RequestMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){

        System.out.println("board create");
        System.out.println("id : " + params.get("id"));
        System.out.println("title : " + params.get("title"));
        System.out.println("content : " + params.get("content"));
        String id = params.get("id").toString();

        Map<String, Object> map_board = null;
        for(Map<String,Object> each:list_board){
            if(id.equals(each.get("id") + "")){
                map_board = each;
            }
        }

        if(map_board != null){
            map_board.put("title",params.get("title") + "");
            map_board.put("content",params.get("content") + "");
        }

        Map<String, Object> return_map = new HashMap<>();
        return_map.put("resultCode","200");
        return return_map;
    }
    @RequestMapping("/list")
    public Map<String, Object> list(){
        System.out.println("board list");

        Map<String, Object> return_map = new HashMap<>();
        return_map.put("resultCode","200");
        return_map.put("list", list_board);
        return return_map;
    }
    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable String id){
        System.out.println("board detail : " + id);

        Map<String, Object> map_board = null;
        for(Map<String,Object> each:list_board){
            if(id.equals(each.get("id") + "")){
                map_board = each;
            }
        }
        Map<String, Object> return_map = new HashMap<>();
        return_map.put("resultCode","200");
        return_map.put("detail", map_board);
        return return_map;
    }
}
