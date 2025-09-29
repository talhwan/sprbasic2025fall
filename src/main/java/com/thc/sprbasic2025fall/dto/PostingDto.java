package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Posting;
import lombok.*;

public class PostingDto {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class CreateReqDto{
        String title;
        String content;

        //CreateReqDto를 사용해서, Posting Entity 인스턴스 하나 만들어주세요!
        public Posting toEntity(){
            return Posting.of(getTitle(), getContent());
        }
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class CreateResDto{
        Long id;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class UpdateReqDto{
        Long id;
        Boolean deleted;
        String title;
        String content;
    }


    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class DetailReqDto{
        Long id;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class DetailResDto{
        Long id;
        Boolean deleted;
        String title;
        String content;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class ListReqDto{
        Boolean deleted;
        String title;
    }



}
