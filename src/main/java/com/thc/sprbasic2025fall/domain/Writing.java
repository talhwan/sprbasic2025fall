package com.thc.sprbasic2025fall.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Writing {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Long id;
    String title;
    String content;
}
