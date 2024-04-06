package com.application.courseLibrary.controller;

import com.application.courseLibrary.dto.CourseData;
import com.application.courseLibrary.dto.CourseRegistrationData;
import com.application.courseLibrary.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    @PostMapping("/add")
    @Transactional
    public ResponseEntity<CourseData> addCourse(@RequestBody @Valid CourseRegistrationData courseRegistrationData) {
        Long id =  courseService.addCourse(courseRegistrationData);
        return ResponseEntity.ok(getCourseById(id).getBody());
    }

    @GetMapping("/get/{id}")
    @Transactional
    public ResponseEntity<CourseData> getCourseById(@PathVariable Long id) {
        CourseData courseData = courseService.getCourse(id);
        return ResponseEntity.ok(courseData);
    }

    @GetMapping("/get")
    @Transactional
    public ResponseEntity<Page<CourseData>> getCoursesPage(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(courseService.getCoursesPage(pageable));
    }
}
