package com.application.courseLibrary.model;

import com.application.courseLibrary.dto.TopicData;
import com.application.courseLibrary.dto.TopicRegistrationData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topic {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "fk_idCourse")
    private Course course;

    public Topic(TopicRegistrationData topicRegistrationData) {
        this.name = topicRegistrationData.name();
        this.description = topicRegistrationData.description();
        this.course = new Course(topicRegistrationData.course());
    }

    public void update(TopicData topicData) {
        this.name = topicData.name();
        this.description = topicData.description();
        this.course = new Course(topicData.course());
    }
}
