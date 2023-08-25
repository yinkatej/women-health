package com.healthcaredelivery.healthcareblog.controller;

import com.healthcaredelivery.healthcareblog.entity.Blog;
import com.healthcaredelivery.healthcareblog.entity.User;
import com.healthcaredelivery.healthcareblog.repository.*;
import com.healthcaredelivery.healthcareblog.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class KafkaConsumer {
    private LoggerFactory loggerFactory;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    String subject = "A new update for you";
    String url = "https://women-health-2674a5ec82b7.herokuapp.com/?title=";

//   Nursing Mothers
//    @KafkaListener(topics = "1", groupId = "my-group")
    public void listen(Blog blog){
        List<User> users = userRepository.findByTopicId(blog.getTopic().getId());
        String message = String.format("A new article has been published in Reproductive Women Blog:\n%s.\n%s\n Read more at:%s"
                ,blog.getTopic().getTopic(),blog.getTitle(), url+blog.getTitle());
        for (User s: users){
            emailService.sendSimpleMail(s.getEmail(), subject, message, s.getFirstName(), blog.getTitle(), url+blog.getTitle());
            System.out.println("message sent to"+s.getEmail());
        }


    }

//  Pregnant Women
//    @KafkaListener(topics = "2", groupId = "my-group")
//    public void listenNursingMothersEvent(Blog blog){
//        List<User> users = userRepository.findByTopicId(blog.getTopic().getId());
//        String message = String.format("A new article has been published on %s.\n%s\nYou can read more at %s"
//                ,blog.getTopic().getTopic(),blog.getTitle(), url+blog.getTitle());
//        for (User s: users){
//            emailService.sendSimpleMail(s.getEmail(), subject, message);
//            System.out.println("message sent to"+s.getEmail());
//        }
//    }
//
////  Reproductive Women
//    @KafkaListener(topics = "3", groupId = "my-group")
//    public void listenToReproductiveWomenEvent(Blog blog){
//        List<User> users = userRepository.findByTopicId(blog.getTopic().getId());
//        String message = String.format("A new article has been published on %s.\n%s\nYou can read more at %s"
//                ,blog.getTopic().getTopic(),blog.getTitle(), url+blog.getTitle());
//        for (User s: users){
//            emailService.sendSimpleMail(s.getEmail(), subject, message);
//            System.out.println("message sent to"+s.getEmail());
//        }
//    }

}
