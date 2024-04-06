package com.application.courseLibrary.repository;

import com.application.courseLibrary.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicRepository extends JpaRepository<Topic,Long> {
}
