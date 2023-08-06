package com.healthcaredelivery.healthcareblog.model;

import java.util.Date;

public interface BlogDto {
    public Long getId();
    public String getTitle();
    public String getBlog();
//    public Date getCreatedAt();
    public String getPublisherName();
    public  TopicDto getTopic();

    interface TopicDto {
        public Long getId();
        public String getTopic();
    }
}
