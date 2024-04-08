package com.application.courseLibrary.service;

import com.application.courseLibrary.dto.*;
import com.application.courseLibrary.model.Course;
import com.application.courseLibrary.model.Topic;
import com.application.courseLibrary.repository.ITopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    @Override
    public Page<TopicDataWithoutCourse> getTopics(Long id, Pageable pageable) {
        Course idCourse = new Course(new IdCourse(id));
        List<TopicDataWithoutCourse> listTopics = topicRepository.findAllByFkId(idCourse)
                                                    .stream()
                                                    .map(TopicDataWithoutCourse::new)
                                                    .toList();

        return new PageImpl<>(listTopics, pageable, listTopics.size());
    }

    @Override
    public TopicData updateTopic(TopicData topicData) {
        Topic topic = topicRepository.getReferenceById(topicData.id());
        topic.update(topicData);
        return getTopic(topic.getId());
    }
}
