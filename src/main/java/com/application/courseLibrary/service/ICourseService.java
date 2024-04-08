package com.application.courseLibrary.service;

import com.application.courseLibrary.dto.CourseData;
import com.application.courseLibrary.dto.CourseRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICourseService {
    public Long addCourse(CourseRegistrationData courseRegistrationData);
    public CourseData getCourse(Long id);
    public Page<CourseData> getCoursesPage (Pageable pageable);
    public Page<CourseData> getCoursesPageWithWord(Pageable pageable, String word);
    public CourseData updateCourse(CourseData courseData);
}