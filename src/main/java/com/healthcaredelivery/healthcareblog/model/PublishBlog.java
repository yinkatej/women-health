package com.healthcaredelivery.healthcareblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishBlog {
    private String PublisherName;
    private Long topicId;
    private String blog;
    private String title;

}
