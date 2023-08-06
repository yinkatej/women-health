package com.healthcaredelivery.healthcareblog.service;

import com.healthcaredelivery.healthcareblog.entity.Topic;
import com.healthcaredelivery.healthcareblog.entity.User;
import com.healthcaredelivery.healthcareblog.model.SubscribeModel;
import com.healthcaredelivery.healthcareblog.repository.TopicRepository;
import com.healthcaredelivery.healthcareblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public User subscribe(SubscribeModel model) {
        Topic topic = topicRepository.findById(model.getTopicId()).orElse(null);
        User newUser = userRepository.findByEmail(model.getEmail());
        if (newUser!=null){
            return userRepository.save(newUser);
        }else
        {
            User user = new User();
            user.setFirstName(model.getFirstName());
            user.setLastName(model.getLastName());
            user.setEmail(model.getEmail());
            user.setTopic(topic);
            return  userRepository.save(user);
        }



    }
}
