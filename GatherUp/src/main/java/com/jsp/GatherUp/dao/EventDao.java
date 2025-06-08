package com.jsp.GatherUp.dao;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.jsp.GatherUp.entity.Event;
import com.jsp.GatherUp.entity.User;
import com.jsp.GatherUp.repository.EventRepository;
import com.jsp.GatherUp.repository.UserRepository;

@Repository
public class EventDao {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Event saveEventDao(Event event,Long userId) {
		User user=userRepository.findById(userId).orElseThrow(null);
//		System.out.println("user=>"+user);
		event.setUser(user);
		return eventRepository.save(event);
	}
	
	public List<Event> getAllEventDao(){
		return eventRepository.findAll();
	}
	
	public Page<Event> getEventByPaginationDao(int pageNumber,int pageSize){
		return eventRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}
	
	public Event getEventDao(Long id) {
		return eventRepository.findById(id).orElseThrow(null);
	}
	
	public Event updateEventDao(Long id,Event updatedEvent) {
		Event oldEvent=getEventDao(id);
		oldEvent.setEvent_name(updatedEvent.getEvent_name());
		oldEvent.setDescription(updatedEvent.getDescription());
		oldEvent.setDate(updatedEvent.getDate());
		oldEvent.setVenue(updatedEvent.getVenue());
		oldEvent.setEvent_image_url(updatedEvent.getEvent_image_url());
		return eventRepository.save(oldEvent);
	}
	
	public boolean deleteEventDao(Long id) {
		try {
			Event event=getEventDao(id);
			if(event!=null) {
				eventRepository.delete(event);
				return true;
			}
			else
				return false;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<Event> getEventByUser(Long userId) {
		return eventRepository.findAll().stream()
	            .filter(event -> event.getUser() != null && Objects.equals(event.getUser().getUser_id(), userId))
	            .collect(Collectors.toList());
	}
	
	public List<Event> getTrendingEventsDao() {
        return eventRepository.findTrendingEvents();
    }


}
