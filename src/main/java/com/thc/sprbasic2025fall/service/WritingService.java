package com.thc.sprbasic2025fall.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface WritingService {
    Map<String, Object> create(Map<String, Object> params);
    void update(Map<String, Object> params);
    void delete(Map<String, Object> params);
    Map<String, Object> list();
    Map<String, Object> detail(int id);

}



