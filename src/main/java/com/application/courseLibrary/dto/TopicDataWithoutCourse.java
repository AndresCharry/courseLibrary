package com.application.courseLibrary.dto;

import com.application.courseLibrary.model.Topic;

public record TopicDataWithoutCourse(
        Long id,
        String name,
        String description
) {
    public TopicDataWithoutCourse(Topic topic){
        this(topic.getId(), topic.getName(), topic.getDescription());
    }
}
