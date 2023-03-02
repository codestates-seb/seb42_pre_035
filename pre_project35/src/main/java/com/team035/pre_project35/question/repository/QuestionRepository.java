package com.team035.pre_project35.question.repository;

import com.team035.pre_project35.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    //검색 기능 추가
    Page<Question> findByTitleContainingIgnoreCase(Pageable pageable, String keyword);
}
