package com.application.courseLibrary.service;

import com.application.courseLibrary.dto.TopicData;
import com.application.courseLibrary.dto.TopicRegistrationData;
import com.application.courseLibrary.model.Topic;
import com.application.courseLibrary.repository.ITopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicService implements ITopicService {

    private final ITopicRepository topicRepository;
    @Override
    public Long addTopic(TopicRegistrationData topicRegistrationData) {
        Topic topic = new Topic(topicRegistrationData);
        topicRepository.save(topic);
        return topic.getId();
    }

    @Override
    public TopicData getTopic(Long id) {
        return new TopicData(topicRepository.getReferenceById(id));
    }
}
