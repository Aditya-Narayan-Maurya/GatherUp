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

import com.jsp.GatherUp.dao.RegistrationDao;
import com.jsp.GatherUp.entity.Registration;

import lombok.experimental.PackagePrivate;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class RegistrationController {

	@Autowired
	public RegistrationDao registrationDao;
	
	@PostMapping(value = "/register/{userId}/{eventId}")
	public Registration saveRegistrationController(@PathVariable Long userId, @PathVariable Long eventId) {
		return registrationDao.saveRegistrationDao(userId, eventId);
	}
	
	@GetMapping(value = "/registrations")
	public List<Registration> getAllRegistrationController(){
		return registrationDao.getAllRegistrationDao();
	}
	
	@GetMapping(value = "/registrations/{id}")
	public Registration getRegistrationById(@PathVariable Long id) {
		return registrationDao.getRegistrationById(id);
	}
	@GetMapping(value = "/registrations/user/{userId}")
	public List<Registration> getAllRegistrationByUserController(@PathVariable Long userId){
		return registrationDao.getAllRegistrationByUserDao(userId);
	}
	
	@GetMapping(value = "/registrations/event/{eventId}")
	public List<Registration> getAllRegistrationByEventController(@PathVariable Long eventId){
		return registrationDao.getAllRegistrationByEventDao(eventId);
	}
	
	@PutMapping(value = "/registrations/{id}")
	public Registration updateRegistrationById(@PathVariable Long id,@RequestBody Map<String, String> payload) {
		String status=payload.get("status");
		return registrationDao.updateRegistrationById(id, status);
	}
	
	@DeleteMapping(value = "/registrations/{registrationId}")
	public boolean deleteRegistrationById(@PathVariable Long registrationId) {
		return registrationDao.deleteRegisratinById(registrationId);
	}
		
}
