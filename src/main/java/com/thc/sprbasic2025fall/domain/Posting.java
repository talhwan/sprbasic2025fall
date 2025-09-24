package com.thc.sprbasic2025fall.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Posting {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Setter String title;
    @Setter String content;
}
