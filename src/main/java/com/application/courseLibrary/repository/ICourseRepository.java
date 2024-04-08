package com.application.courseLibrary.repository;

import com.application.courseLibrary.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Long> {

    @Query("""
           SELECT c 
           FROM Course c
           WHERE c.name LIKE %:word%
           """)
    List<Course> findAllCoursesWithWord(String word);
}
