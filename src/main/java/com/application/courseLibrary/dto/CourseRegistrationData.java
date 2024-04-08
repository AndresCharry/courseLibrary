package com.application.courseLibrary.dto;

import com.application.courseLibrary.model.Topic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CourseRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        String modality,
        @NotNull
        LocalDate endDate

) {
}
