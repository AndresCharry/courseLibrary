package com.application.courseLibrary.controller;

import com.application.courseLibrary.dto.TopicData;
import com.application.courseLibrary.dto.TopicRegistrationData;
import com.application.courseLibrary.service.ITopicService;
import com.application.courseLibrary.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {

    private final ITopicService topicService;

    @PostMapping("/add")
    @Transactional
    public ResponseEntity<TopicData> addTopic(@RequestBody @Valid TopicRegistrationData topicRegistrationData) {
        Long id = topicService.addTopic(topicRegistrationData);
        return ResponseEntity.ok(getTopic(id).getBody());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TopicData> getTopic(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.getTopic(id));
    }
}
