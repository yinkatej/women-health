package com.healthcaredelivery.healthcareblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String toEmail;
    private String subject;
    private String body;
}
