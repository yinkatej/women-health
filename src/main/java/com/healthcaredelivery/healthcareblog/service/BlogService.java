package com.healthcaredelivery.healthcareblog.service;

import com.healthcaredelivery.healthcareblog.entity.Blog;
import com.healthcaredelivery.healthcareblog.model.BlogDto;
import com.healthcaredelivery.healthcareblog.model.PublishBlog;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface BlogService {

    Blog saveBlog(PublishBlog publishBlog);

    List <BlogDto> getAllBlogs();

    Optional<BlogDto> findById(Long id);
}
