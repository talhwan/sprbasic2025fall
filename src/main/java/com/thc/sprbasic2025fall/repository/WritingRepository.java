package com.thc.sprbasic2025fall.repository;

import com.thc.sprbasic2025fall.domain.Writing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritingRepository extends JpaRepository<Writing,Long> {
}
