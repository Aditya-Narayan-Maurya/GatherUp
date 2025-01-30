package com.jsp.GatherUp.dao;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.GatherUp.entity.Event;
import com.jsp.GatherUp.entity.Registration;
import com.jsp.GatherUp.entity.User;
import com.jsp.GatherUp.repository.EventRepository;
import com.jsp.GatherUp.repository.RegistrationRepository;
import com.jsp.GatherUp.repository.UserRepository;

@Repository
public class RegistrationDao {
	@Autowired
	public RegistrationRepository registrationRepository;
	
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public EventRepository eventRepository;
	
	public Registration saveRegistrationDao(Long userId,Long eventId) {
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		Event event=eventRepository.findById(eventId).orElseThrow(()->new RuntimeException("Event not found"));
		Registration registration=new Registration();
		registration.setUser(user);
		registration.setEvent(event);
		registration.setStatus("REGISTERED");//register pending cancel
		registration.setRegistration_date(LocalDateTime.now());
		return registrationRepository.save(registration);
	}
	
	public Registration getRegistrationById(Long id) {
		return registrationRepository.findById(id).orElseThrow(()->new RuntimeException("Registration Not found "));
	}
	
	//admin only
	public List<Registration> getAllRegistrationDao(){
		return registrationRepository.findAll();
	}
	
	public List<Registration> getAllRegistrationByUserDao(Long userId){
		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
		List<Registration> registrations=getAllRegistrationDao();
		List<Registration> userRegistrations=new LinkedList<Registration>();
		for(Registration registration:registrations) {
			if(registration.getUser().getUser_id()==user.getUser_id())
				userRegistrations.add(registration);
		}
		return userRegistrations;
	}
	
	public List<Registration> getAllRegistrationByEventDao(Long eventId) {
		Event event=eventRepository.findById(eventId).orElseThrow(()->new RuntimeException("Event Not Found"));
		List<Registration> registrations=getAllRegistrationDao();
		List<Registration> eventRegistrations=new LinkedList<Registration>();
		for(Registration registration:registrations) {
			if(registration.getEvent().getEvent_id()==event.getEvent_id())
				eventRegistrations.add(registration);
		}
		return eventRegistrations;
	}
     
	//status ko update krne ke liye
	public Registration updateRegistrationById(Long id,String status) {
		Registration registration=getRegistrationById(id);
		registration.setStatus(status);
		return registrationRepository.save(registration);
	}
	
	//delete krne ke liye
	public boolean deleteRegisratinById(Long id) {
		Registration registration=getRegistrationById(id);
		if(registration!=null) {
		            registrationRepository.delete(registration);
		            return true;
		}
		return false;     
	}
	
	
}
