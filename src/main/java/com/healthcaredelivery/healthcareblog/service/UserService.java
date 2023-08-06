package com.healthcaredelivery.healthcareblog.service;

import com.healthcaredelivery.healthcareblog.entity.User;
import com.healthcaredelivery.healthcareblog.model.SubscribeModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User subscribe(SubscribeModel model);
}
