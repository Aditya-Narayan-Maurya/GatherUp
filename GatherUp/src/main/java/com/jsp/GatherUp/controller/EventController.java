package com.jsp.GatherUp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.GatherUp.dao.EventDao;
import com.jsp.GatherUp.entity.Event;
import com.jsp.GatherUp.entity.User;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(value = "/events")
public class EventController {
	@Autowired
    EventDao eventDao;
	
	@PostMapping(value = "/{userId}")
	public Event saveEventController(@RequestBody Event event ,@PathVariable Long userId) {
		System.out.println("event="+event);
		System.out.println("userId"+userId);
		return eventDao.saveEventDao(event,userId);
	}
	
	@GetMapping
	public List<Event> getAllEventController(){
		return eventDao.getAllEventDao();
	}
	
	@GetMapping(value = "/{id}")
	public Event getEventController(@PathVariable Long id) {
		return eventDao.getEventDao(id);
	}
	
	@PutMapping(value = "/{id}")
	public Event updateEventController(@PathVariable Long id,@RequestBody Event event) {
		return eventDao.updateEventDao(id, event);
	}
	
	@DeleteMapping(value = "/{id}")
	public boolean deleteEventController(@PathVariable Long id) {
		return eventDao.deleteEventDao(id);
	}
	
	@GetMapping(value ="users/{id}")
	public List<Event> getLaptopByUser(@PathVariable Long id){
		System.out.println("id=>"+id);
		return eventDao.getEventByUser(id);
	}
	
	@GetMapping(value = "/trending")
	public List<Event> getTrendingEventsController() {
        return eventDao.getTrendingEventsDao();
    }
}
