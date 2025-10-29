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

    public List<PostingDto.DetailResDto> addlist(List<PostingDto.DetailResDto> list) {
        List<PostingDto.DetailResDto> newList = new ArrayList<>();
        for (PostingDto.DetailResDto posting : list) {
            newList.add(get(DefaultDto.DetailReqDto.builder().id(posting.getId()).build()));
        }
        return newList;
    }

    @Override
    public List<PostingDto.DetailResDto> list(PostingDto.ListReqDto param) {
        List<PostingDto.DetailResDto> list = new ArrayList<>();
        List<PostingDto.DetailResDto> postings = postingMapper.list(param);
        return addlist(postings);
    }
    @Override
    public DefaultDto.PagedListResDto pagedList(PostingDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(postingMapper.listCount(param));
        res.setList(addlist(postingMapper.pagedList(param)));
        return res;
    }

    @Override
    public List<PostingDto.DetailResDto> scrollList(PostingDto.ScrollListReqDto param) {
        return addlist(postingMapper.scrollList(param));
    }
}
