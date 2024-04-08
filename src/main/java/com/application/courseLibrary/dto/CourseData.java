package com.application.courseLibrary.dto;


import com.application.courseLibrary.model.Course;
import com.application.courseLibrary.model.Topic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CourseData(
        @NotNull
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String modality,
        @NotNull
        LocalDate endDate
) {
    public CourseData (Course course){
        this(course.getId(),course.getName(),course.getModality(),course.getEndDate());
    }
}
