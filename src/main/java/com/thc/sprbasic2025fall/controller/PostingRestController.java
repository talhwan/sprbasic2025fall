package com.thc.sprbasic2025fall.controller;

import com.thc.sprbasic2025fall.domain.Posting;
import com.thc.sprbasic2025fall.dto.PostingDto;
import com.thc.sprbasic2025fall.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/posting")
@RestController
public class PostingRestController {

    final PostingService postingService;

    @PostMapping("")
    public PostingDto.CreateResDto create(@RequestBody PostingDto.CreateReqDto param) {
        return postingService.create(param);
    }
    @PutMapping("")
    public void update(@RequestBody PostingDto.UpdateReqDto param) {
        postingService.update(param);
    }
    @DeleteMapping("")
    public void delete(@RequestBody PostingDto.UpdateReqDto param) {
        postingService.delete(param);
    }

    @GetMapping("")
    public PostingDto.DetailResDto detail(PostingDto.DetailReqDto param) {
        return postingService.detail(param);
    }
    @GetMapping("/list")
    public List<PostingDto.DetailResDto> list(PostingDto.ListReqDto param) {
        return postingService.list(param);
    }

}
