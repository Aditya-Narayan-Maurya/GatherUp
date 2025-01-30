package com.jsp.GatherUp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.GatherUp.dao.FeedbackDao;
import com.jsp.GatherUp.entity.Feedback;

@RestController
@RequestMapping(value = "feedback")
public class FeedbackController {

	@Autowired
	public FeedbackDao feedbackDao;
	
	
	@PostMapping("/{userId}/{eventId}")
	public Feedback saveFeedbackController(@PathVariable Long userId, @PathVariable Long eventId,@RequestBody Feedback feedback) {
		return feedbackDao.saveFeedbackDao(userId, eventId, feedback);
	}
	
	@GetMapping
	public List<Feedback> getAllFeedback(){
		return feedbackDao.getAllFeedbackDao();
	}
	
	@GetMapping(value = "/{id}")
	public Feedback getFeedbackById(@PathVariable Long id) {
		return feedbackDao.getFeedbackById(id);
	} 
	
	@GetMapping(value = "/user/{userId}")
	public List<Feedback> getAllFeedbackByUserController(@PathVariable Long userId){
		return feedbackDao.getAllFeedbackByUserDao(userId);
		
	}

	@GetMapping(value = "/event/{eventId}")
	public List<Feedback> getAllFeedbackByeEentController(@PathVariable Long eventId){
		return feedbackDao.getAllFeedbackByEventDao(eventId);
		
	}
	
	@PutMapping(value = "{id}")
	public Feedback updateFeedbackById(@PathVariable Long id,@RequestBody Feedback updatedFeedback) {
		return feedbackDao.updateFeedbackById(id, updatedFeedback);
	}
	
	@DeleteMapping(value = "/{id}")
	public boolean deleteFeedbackByIdController(@PathVariable Long id) {
		return feedbackDao.deleteFeedbackById(id);
	}
	
	
}
