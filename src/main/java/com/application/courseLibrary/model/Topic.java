package com.application.courseLibrary.model;

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

    public Topic(TopicRegistrationData topicRegistrationData) {
        this.name = topicRegistrationData.name();
        this.description = topicRegistrationData.description();
    }
}
