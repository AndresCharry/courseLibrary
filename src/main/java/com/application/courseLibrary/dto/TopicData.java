package com.application.courseLibrary.dto;

import com.application.courseLibrary.model.Topic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicData(
        @NotNull
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        IdCourse course
) {
    public TopicData(Topic topic) {
        this(topic.getId(), topic.getName(), topic.getDescription(), new IdCourse(topic.getCourse().getId()));
    }
}
