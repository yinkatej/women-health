package com.healthcaredelivery.healthcareblog.controller;

import com.healthcaredelivery.healthcareblog.entity.Topic;
import com.healthcaredelivery.healthcareblog.entity.User;
import com.healthcaredelivery.healthcareblog.model.BlogDto;
import com.healthcaredelivery.healthcareblog.model.Email;
import com.healthcaredelivery.healthcareblog.model.PublishBlog;
import com.healthcaredelivery.healthcareblog.model.SubscribeModel;
import com.healthcaredelivery.healthcareblog.repository.BlogRepository;
import com.healthcaredelivery.healthcareblog.repository.TopicRepository;
import com.healthcaredelivery.healthcareblog.repository.UserRepository;
import com.healthcaredelivery.healthcareblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")

public class HealthCareController{
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private BlogService blogService;
    @Autowired
    private TopicService topicService;

    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;
    @Autowired
    private BlogRepository blogRepository;

//    @PostMapping("/email")
//    public String sendMail(@RequestBody Email email){
//       return emailService.sendSimpleMail(email.getToEmail(), email.getSubject(), email.getBody());
//
//    }


    @PostMapping("/add_topic")
    public Topic addTopic(@RequestBody Topic topic){
        return topicService.saveTopic(topic);
    }

    @PostMapping("/publish")
    public ResponseEntity<String> postBlog(@RequestBody PublishBlog publishBlog){
        blogService.saveBlog(publishBlog);
        return new ResponseEntity<String>("Content published successfully",HttpStatus.CREATED);
    }

    @PostMapping("/subscribe")
    public User userSubscribe(@RequestBody SubscribeModel model){

        return userService.subscribe(model);
    }
    @GetMapping("/all_blog")
    public List<BlogDto> getAllBlog(){
//        kafkaProducerService.sendMessage("1", "I love this");
        return blogRepository.findBy();
    }
    @GetMapping("/all_topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }
    @GetMapping("/blog/{id}")
    public Optional<BlogDto> getBlogById(@PathVariable Long id){
        return blogService.findById(id);
    }

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user-topic/{id}")
    public List<User> getUserById(@PathVariable("id") Long id){
        return userRepository.findByTopicId(id);
    }

}
