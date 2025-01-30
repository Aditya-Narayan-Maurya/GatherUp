package com.jsp.GatherUp.dao;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.GatherUp.entity.Event;
import com.jsp.GatherUp.entity.Feedback;
import com.jsp.GatherUp.entity.Registration;
import com.jsp.GatherUp.entity.User;
import com.jsp.GatherUp.repository.EventRepository;
import com.jsp.GatherUp.repository.FeedbackRepository;
import com.jsp.GatherUp.repository.UserRepository;

@Repository
public class FeedbackDao {

	@Autowired
	public FeedbackRepository feedbackRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public EventRepository eventRepository;
	
	public Feedback saveFeedbackDao(Long userId,Long eventId,Feedback feedback) {
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		Event event=eventRepository.findById(eventId).orElseThrow(()->new RuntimeException("Event not found"));
		feedback.setUser(user);
		feedback.setEvent(event);
		feedback.setFeedback_date(LocalDateTime.now());
		return feedbackRepository.save(feedback);
	}
	
	public Feedback getFeedbackById(Long id) {
		return feedbackRepository.findById(id).orElseThrow(()->new RuntimeException("Feedback Not found "));
	}
	
	public List<Feedback> getAllFeedbackDao(){
		return  feedbackRepository.findAll();
	}
	
	public List<Feedback> getAllFeedbackByUserDao(Long userId){
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
		List<Feedback> feedbacks=getAllFeedbackDao();
		List<Feedback> userFeedbacks=new LinkedList<Feedback>();
		for(Feedback feedback:feedbacks) {
			if(feedback.getUser().getUser_id()==user.getUser_id())
				userFeedbacks.add(feedback);
		}
		return userFeedbacks;
	}
	
	public List<Feedback> getAllFeedbackByEventDao(Long eventId){
		Event event=eventRepository.findById(eventId).orElseThrow(()->new RuntimeException("Event Not Found"));
		List<Feedback> feedbacks=getAllFeedbackDao();
		List<Feedback> userFeedbacks=new LinkedList<Feedback>();
		for(Feedback feedback:feedbacks) {
			if(feedback.getEvent().getEvent_id()==event.getEvent_id())
				userFeedbacks.add(feedback);
		}
		return userFeedbacks;
	}
	
	//comments ko update krne ke liye
		public Feedback updateFeedbackById(Long id,Feedback updatedFeedback) {
			Feedback feedback=getFeedbackById(id);
			feedback.setRating(updatedFeedback.getRating());
			feedback.setComments(updatedFeedback.getComments());
			return feedbackRepository.save(feedback);
		}
	
	//delete krne ke liye
		public boolean deleteFeedbackById(Long id) {
			Feedback feedback=getFeedbackById(id);
			if(feedback!=null) {
			            feedbackRepository.delete(feedback);
			            return true;
			}
			return false;     
		} 
	
}
