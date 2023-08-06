package com.healthcaredelivery.healthcareblog.service;

import com.healthcaredelivery.healthcareblog.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TopicService {
    Topic saveTopic(Topic topic);

    List<Topic> getAllTopics();
}
