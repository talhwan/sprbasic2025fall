package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.repository.PostingRepository;
import com.thc.sprbasic2025fall.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PostingServiceImpl implements PostingService {

    final PostingRepository postingRepository;

    @Override
    public Long create(Map<String, Object> param) {
        Posting posting = new Posting();
        posting.setTitle(param.get("title") + "");
        posting.setContent(param.get("content") + "");

        posting = postingRepository.save(posting);
        return posting.getId();
    }

    @Override
    public void update(Map<String, Object> param) {
        Long id = Long.parseLong(param.get("id") + "");
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        String title = (String) param.get("title");
        if(title != null){ posting.setTitle(title); }
        String content = (String) param.get("content");
        if(content != null){ posting.setContent(content); }
        postingRepository.save(posting);
    }

    @Override
    public void delete(Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        postingRepository.delete(posting);
    }

    @Override
    public Posting detail(Long id) {
        return postingRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
    }

    @Override
    public List<Posting> list() {
        return postingRepository.findAll();
    }
}
