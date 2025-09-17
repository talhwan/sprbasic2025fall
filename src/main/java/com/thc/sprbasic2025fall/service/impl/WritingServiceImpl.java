package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.service.WritingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WritingServiceImpl implements WritingService {

    List<Map<String, Object>> list = new ArrayList<>();
    int order = 0;

    @Override
    public Map<String, Object> create(Map<String, Object> params) {
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

    @Override
    public void update(Map<String, Object> params) {
        int id = Integer.parseInt(params.get("id") + "");
        String title = (String) params.get("title");
        String content = (String) params.get("content");

        Map<String, Object> map_writing = getData(id);
        map_writing.put("title", title);
        map_writing.put("content", content);
    }
    @Override
    public void delete(Map<String, Object> params) {
        int id = Integer.parseInt(params.get("id") + "");
        Map<String, Object> map_writing = getData(id);
        map_writing.put("title", null);
        map_writing.put("content", null);
    }

    @Override
    public Map<String, Object> list() {
        Map<String, Object> map_return = new HashMap<>();
        map_return.put("resultCode", 200);
        map_return.put("data", list);
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

    @Override
    public Map<String, Object> detail(int id) {
        Map<String, Object> map_return = new HashMap<>();
        map_return.put("resultCode", 200);
        map_return.put("data", getData(id));
        return map_return;
    }
}
