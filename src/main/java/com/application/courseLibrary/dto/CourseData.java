package com.application.courseLibrary.dto;


import com.application.courseLibrary.model.Course;
import com.application.courseLibrary.model.Topic;

import java.time.LocalDate;
import java.util.List;

public record CourseData(
        Long id,
        String name,
        String modality,
        LocalDate endDate,
        List<Topic> listTopics
) {
    public CourseData (Course course){
        this(course.getId(),course.getName(),course.getModality(),course.getEndDate(),course.getListTopic());
    }
}
