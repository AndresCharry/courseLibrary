package com.application.courseLibrary.service;

import com.application.courseLibrary.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITopicService {

    public Long addTopic(TopicRegistrationData topicRegistrationData);
    public TopicData getTopic(Long id);
    public Page<TopicDataWithoutCourse> getTopics(Long id, Pageable pageable);
    public TopicData updateTopic(TopicData topicData);
}
