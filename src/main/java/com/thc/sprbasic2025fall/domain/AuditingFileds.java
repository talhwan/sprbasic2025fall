package com.thc.sprbasic2025fall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@MappedSuperclass
public class AuditingFileds {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    Boolean deleted;
    @CreatedDate @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime createdAt;
    @LastModifiedDate @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime modifiedAt;

    @PrePersist
    public void onPrePersist() {
        this.deleted = false;
    }
}
