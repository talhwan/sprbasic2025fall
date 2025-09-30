package com.thc.sprbasic2025fall.domain;

import com.thc.sprbasic2025fall.dto.DefaultDto;
import com.thc.sprbasic2025fall.dto.PostingDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
public class Posting extends AuditingFileds{
    @Setter String title;
    @Setter String content;

    protected Posting(){}
    private Posting(String title, String content){
        this.title = title;
        this.content = content;
    }
    //이 메서드를 통해서만, 엔티티 인스턴스를 만들수 있도록 강제!!
    public static Posting of(String title, String content){
        return new Posting(title, content);
    }
    public DefaultDto.CreateResDto toCreateResDto(){
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
    public void update(PostingDto.UpdateReqDto param){
        if(param.getDeleted() != null){ setDeleted(param.getDeleted()); }
        if(param.getTitle() != null){ setTitle(param.getTitle()); }
        if(param.getContent() != null){ setContent(param.getContent()); }
    }
}
