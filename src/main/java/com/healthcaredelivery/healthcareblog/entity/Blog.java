package com.healthcaredelivery.healthcareblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @Column(unique = true)
    private String title;
    @Lob
    @Column(length = 600000)
    private String blog;
    private Date createdAt;
    private String publisherName;

//    @JsonIgnore
    @ManyToOne( fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private Topic topic;


}
