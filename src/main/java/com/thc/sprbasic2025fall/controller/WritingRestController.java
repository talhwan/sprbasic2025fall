package com.thc.sprbasic2025fall.controller;

import com.thc.sprbasic2025fall.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
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

    WritingService writingService;
    WritingRestController(WritingService writingService) {
        this.writingService = writingService;
    }

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {
        return writingService.create(params);
    }
    @GetMapping("/update")
    public void update(@RequestParam Map<String, Object> params) {
        writingService.update(params);
    }
    @GetMapping("/delete")
    public void delete(@RequestParam Map<String, Object> params) {
        writingService.delete(params);
    }

    @GetMapping("/list")
    public Map<String, Object> list() {
        return writingService.list();
    }
    @GetMapping("/detail")
    public Map<String, Object> detail(int id) {
        return writingService.detail(id);
    }

}
