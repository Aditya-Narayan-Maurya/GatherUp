package com.jsp.GatherUp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.GatherUp.entity.Event;
import com.jsp.GatherUp.repository.EventRepository;

@Repository
public class EventDao {
	
	@Autowired
	EventRepository eventRepository;
	
	public Event saveEventDao(Event event) {
		return eventRepository.save(event);
	}
	
	public List<Event> getAllEventDao(){
		return eventRepository.findAll();
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

}
