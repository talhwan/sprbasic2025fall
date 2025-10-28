package com.thc.sprbasic2025fall.service.impl;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.dto.DefaultDto;
import com.thc.sprbasic2025fall.dto.PostingDto;
import com.thc.sprbasic2025fall.mapper.PostingMapper;
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
    final PostingMapper postingMapper;

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
//        Posting posting = postingRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
//        return PostingDto.DetailResDto.builder()
//                .id(posting.getId())
//                .deleted(posting.getDeleted())
//                .title(posting.getTitle())
//                .content(posting.getContent())
//                .build();
        PostingDto.DetailResDto res = postingMapper.detail(param.getId());
        return res;
    }

    @Override
    public PostingDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }

    @Override
    public List<PostingDto.DetailResDto> list(PostingDto.ListReqDto param) {
        List<PostingDto.DetailResDto> list = new ArrayList<>();
        List<PostingDto.DetailResDto> postings = postingMapper.list(param);
        for (PostingDto.DetailResDto posting : postings) {
            list.add(get(DefaultDto.DetailReqDto.builder().id(posting.getId()).build()));
        }
        /*List<Posting> postings = postingRepository.findAll();
        for (Posting posting : postings) {
            if(param.getDeleted() != null){
                if(posting.getDeleted() == param.getDeleted()){
                    list.add(get(DefaultDto.DetailReqDto.builder().id(posting.getId()).build()));
                }
            }
        }*/
        return list;
    }
    @Override
    public DefaultDto.PagedListResDto pagedList(PostingDto.PagedListReqDto param) {
        Integer callpage = param.getCallpage();
        if(callpage == null){
            callpage = 1;
        }
        if(callpage < 1){
            callpage = 1;
        }
        Integer perpage = param.getPerpage();
        if(perpage == null){
            perpage = 10;
        }
        if(perpage < 2){
            perpage = 10;
        }

        int listcount = postingMapper.listCount(param);
        int totalpage = listcount / perpage;
        if(listcount % perpage > 0){
            totalpage++;
        }
        if(totalpage < 1){
            totalpage = 1;
        }
        if(callpage > totalpage){
            callpage = totalpage;
        }
        int offset = perpage * (callpage - 1);

        param.setOffset(offset);
        param.setPerpage(perpage);

        List<PostingDto.DetailResDto> list = new ArrayList<>();
        List<PostingDto.DetailResDto> postings = postingMapper.pagedList(param);
        for (PostingDto.DetailResDto posting : postings) {
            list.add(get(DefaultDto.DetailReqDto.builder().id(posting.getId()).build()));
        }

        return DefaultDto.PagedListResDto.builder().callpage(callpage).totalpage(totalpage).listcount(listcount).list(list).build();
    }
}
