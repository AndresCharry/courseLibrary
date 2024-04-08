package com.application.courseLibrary.controller;

import com.application.courseLibrary.dto.*;
import com.application.courseLibrary.service.ITopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    @GetMapping("/getTopics/{id}")
    public ResponseEntity<Page<TopicDataWithoutCourse>> getTopics(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(topicService.getTopics(id,pageable));
    }

    @PutMapping("/edit")
    @Transactional
    public ResponseEntity<TopicData> updateTopic
            (@RequestBody @Valid TopicData topicData) {
        return ResponseEntity.ok(topicService.updateTopic(topicData));
    }

}
