package com.thc.sprbasic2025fall.service;

import com.thc.sprbasic2025fall.domain.Posting;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PostingService {
    Long create(Map<String, Object> param);
    void update(Map<String, Object> param);
    void delete(Long id);
    Posting detail(Long id);
    List<Posting> list();
}
