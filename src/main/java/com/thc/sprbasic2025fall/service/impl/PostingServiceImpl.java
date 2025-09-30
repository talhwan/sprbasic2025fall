package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.dto.DefaultDto;
import com.thc.sprbasic2025fall.dto.PostingDto;
import com.thc.sprbasic2025fall.repository.PostingRepository;
import com.thc.sprbasic2025fall.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PostingServiceImpl implements PostingService {

    final PostingRepository postingRepository;

    @Override
    public DefaultDto.CreateResDto create(PostingDto.CreateReqDto param) {
        return postingRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(PostingDto.UpdateReqDto param) {
        Posting posting = postingRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        posting.update(param);
        postingRepository.save(posting);
    }

    @Override
    public void delete(PostingDto.UpdateReqDto param) {
        update(PostingDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public PostingDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        Posting posting = postingRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        return PostingDto.DetailResDto.builder()
                .id(posting.getId())
                .deleted(posting.getDeleted())
                .title(posting.getTitle())
                .content(posting.getContent())
                .build();
    }

    @Override
    public PostingDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }

    @Override
    public List<PostingDto.DetailResDto> list(PostingDto.ListReqDto param) {
        List<PostingDto.DetailResDto> list = new ArrayList<>();
        List<Posting> postings = postingRepository.findAll();
        for (Posting posting : postings) {
            if(param.getDeleted() != null){
                if(posting.getDeleted() == param.getDeleted()){
                    list.add(get(DefaultDto.DetailReqDto.builder().id(posting.getId()).build()));
                }
            }
        }
        return list;
    }
}
