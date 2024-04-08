package com.application.courseLibrary.service;

import com.application.courseLibrary.dto.CourseData;
import com.application.courseLibrary.dto.CourseRegistrationData;
import com.application.courseLibrary.model.Course;
import com.application.courseLibrary.repository.ICourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final ICourseRepository courseRepository;

    @Override
    public Long addCourse(CourseRegistrationData courseRegistrationData) {
        Course course  = new Course(courseRegistrationData);
        courseRepository.save(course);
        return course.getId();
    }

    @Override
    public CourseData getCourse(Long id) {
        return new CourseData(courseRepository.getReferenceById(id));
    }

    @Override
    public Page<CourseData> getCoursesPage(Pageable pageable) {
        List<CourseData> listCourses =  courseRepository.findAll()
                                                    .stream()
                                                    .map(CourseData::new).toList();
        long listCourseSize = listCourses.size();
        return  new PageImpl<>(listCourses, pageable, listCourseSize);
    }

    @Override
    public Page<CourseData> getCoursesPageWithWord(Pageable pageable, String word) {
        List<CourseData> listCourses = courseRepository.findAllCoursesWithWord(word)
                                                       .stream()
                                                       .map(CourseData::new)
                                                       .toList();
        return new PageImpl<>(listCourses, pageable, listCourses.size());
    }

    @Override
    public CourseData updateCourse(CourseData courseData) {
        Course course = courseRepository.getReferenceById(courseData.id());
        course.update(courseData);
        return getCourse(course.getId());
    }
}
