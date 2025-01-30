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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.GatherUp.dao.UserDao;
import com.jsp.GatherUp.entity.User;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
   private UserDao userDao;
	
	@PostMapping
	public User saveUserController(@RequestBody User user) {
		return userDao.saveUserDao(user);
	}
	
	@GetMapping
	public List<User> getAllUserController(){
		return userDao.getAllUserDao();
	}
	
	@GetMapping(value = "/{id}")
	public User getUserController(@PathVariable Long id) {
		return userDao.getUserDao(id);
	}
	
	@PutMapping(value = "/{id}")
	public User updateUserController(@PathVariable Long id,@RequestBody User user) {
		return userDao.updateUserDao(id, user);
	}
	
	@DeleteMapping(value = "/{id}")
	public boolean deleteUserController(@PathVariable Long id) {
		return userDao.deleteUserDao(id);
	}
}
