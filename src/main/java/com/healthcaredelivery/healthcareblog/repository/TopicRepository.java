package com.healthcaredelivery.healthcareblog.repository;

import com.healthcaredelivery.healthcareblog.entity.Topic;
import com.healthcaredelivery.healthcareblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    public Topic findByTopicIgnoreCase(String topic);


}
