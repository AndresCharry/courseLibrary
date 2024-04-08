package com.application.courseLibrary.repository;

import com.application.courseLibrary.model.Course;
import com.application.courseLibrary.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITopicRepository extends JpaRepository<Topic,Long> {

    @Query("""
           SELECT t
           FROM Topic t
           WHERE t.course = :fkId
           """)
    List<Topic> findAllByFkId(Course fkId);
}
