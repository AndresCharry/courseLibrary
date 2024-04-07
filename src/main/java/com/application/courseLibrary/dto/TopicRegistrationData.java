package com.application.courseLibrary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        IdCourse course
) {
}
