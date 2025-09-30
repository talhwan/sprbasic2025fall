package com.thc.sprbasic2025fall.dto;

import com.thc.sprbasic2025fall.domain.Posting;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

public class DefaultDto {
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class CreateResDto{
        Long id;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class UpdateReqDto{
        Long id;
        Boolean deleted;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class DetailReqDto{
        Long id;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class DetailResDto{
        Long id;
        Boolean deleted;
        LocalDateTime createdAt;
        LocalDateTime modifiedAt;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ListReqDto{
        Boolean deleted;
    }
}
