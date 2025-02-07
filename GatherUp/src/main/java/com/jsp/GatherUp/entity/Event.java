package com.jsp.GatherUp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long event_id;
	 private String event_name;
	 private String description;
	 private LocalDateTime date;
	 private String venue;
	 private String event_image_url;
	 private String category;
	 
	 
	 @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
	 @JsonIgnore
	 private List<Registration> registrations;
		
	 @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
	 @JsonIgnore
	 private List<Feedback> feedbacks;
	 
	 @ManyToOne
	 @JoinColumn(name = "created_by")
	 private User user;
}
