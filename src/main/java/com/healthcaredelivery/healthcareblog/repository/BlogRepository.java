package com.healthcaredelivery.healthcareblog.repository;

import com.healthcaredelivery.healthcareblog.entity.Blog;
import com.healthcaredelivery.healthcareblog.model.BlogDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<BlogDto> findBy();

//    @Query("SELECT a.id AS id, a.title AS title, a.blog AS blog, " +
//            " b AS topic FROM Blog a INNER JOIN a.topic b WHERE a.id =?1.  ")
    Optional<BlogDto> findBlogById(Long id);

}
