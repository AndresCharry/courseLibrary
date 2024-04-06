package com.application.courseLibrary.model;

import com.application.courseLibrary.dto.CourseRegistrationData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String modality;
    private LocalDate endDate;
    @OneToMany
    @JoinColumn(name = "fk_id_Course", referencedColumnName = "id")
    private List<Topic> listTopic;

    public Course(CourseRegistrationData courseRegistrationData) {
        this.name = courseRegistrationData.name();
        this.modality = courseRegistrationData.modality();
        this.endDate = courseRegistrationData.endDate();
        this.listTopic = courseRegistrationData.listTopics();
    }
}
