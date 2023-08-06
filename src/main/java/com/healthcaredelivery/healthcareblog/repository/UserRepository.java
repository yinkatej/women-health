package com.healthcaredelivery.healthcareblog.repository;

import com.healthcaredelivery.healthcareblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);


    List<User> findByTopicId(Long id);
}
