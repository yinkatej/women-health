package com.healthcaredelivery.healthcareblog.service;

import com.healthcaredelivery.healthcareblog.controller.KafkaConsumer;
import com.healthcaredelivery.healthcareblog.entity.Blog;
import com.healthcaredelivery.healthcareblog.entity.Topic;
import com.healthcaredelivery.healthcareblog.model.BlogDto;
import com.healthcaredelivery.healthcareblog.model.PublishBlog;
import com.healthcaredelivery.healthcareblog.repository.BlogRepository;
import com.healthcaredelivery.healthcareblog.repository.TopicRepository;
import com.healthcaredelivery.healthcareblog.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private KafkaConsumer kafkaConsumer;
    @Autowired
    private KafkaProducerService kafkaProducerService;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private TopicRepository topicRepository;


    @Override
    public Blog saveBlog(PublishBlog publishBlog) {
        Topic topic = topicRepository.findById(publishBlog.getTopicId()).orElse(null);
        Blog blog = new Blog();
        blog.setTitle(publishBlog.getTitle());
        blog.setCreatedAt(new Date());
        blog.setBlog(publishBlog.getBlog());
        blog.setPublisherName(publishBlog.getPublisherName());

        blog.setTopic( topic);
//        kafkaProducerService.sendMessage(String.valueOf(topic.getId()), blog);
        kafkaConsumer.listen(blog);

        return blogRepository.save(blog);


    }

    @Override

    public List <BlogDto> getAllBlogs() {
        List<BlogDto> blogLIst = blogRepository.findBy();
        return blogLIst;
    }

    @Override
    public Optional<BlogDto> findById(Long id) {
        return blogRepository.findBlogById(id);
    }
}
