package com.thc.sprbasic2025fall.repository;

import com.thc.sprbasic2025fall.domain.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    /*
    Posting findByTitle(String title); //title이 unique한 경우에 사용 필수!
    List<Posting> findByContent(String content);
     */
}
