package com.application.courseLibrary.service;

import com.application.courseLibrary.dto.TopicData;
import com.application.courseLibrary.dto.TopicRegistrationData;

public interface ITopicService {

    public Long addTopic(TopicRegistrationData topicRegistrationData);
    public TopicData getTopic(Long id);
}
