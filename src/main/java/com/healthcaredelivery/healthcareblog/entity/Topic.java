package com.healthcaredelivery.healthcareblog.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    @JsonIgnore
    @OneToMany(mappedBy = "topic")
    private Set<Blog> blog = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "topic")
    private Set<User> user = new HashSet<>();
}
