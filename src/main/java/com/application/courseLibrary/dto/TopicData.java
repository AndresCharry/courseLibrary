package com.application.courseLibrary.dto;

import com.application.courseLibrary.model.Course;
import com.application.courseLibrary.model.Topic;

public record TopicData(
        Long id,
        String name,
        String description,
        CourseData courseData
) {
    public TopicData(Topic topic) {
        this(topic.getId(), topic.getName(), topic.getDescription(), new CourseData(topic.getCourse()));
    }
}
