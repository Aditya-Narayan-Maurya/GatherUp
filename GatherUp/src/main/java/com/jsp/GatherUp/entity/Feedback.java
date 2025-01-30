package com.jsp.GatherUp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long feedback_id;
    
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    
    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;
    private int rating;
    private String comments;
    private LocalDateTime feedback_date;
}
