package com.jsp.GatherUp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.GatherUp.entity.User;
import com.jsp.GatherUp.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUserDao( User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUserDao(){
		return userRepository.findAll();
	}
	
	public User getUserDao(Long id) {
		return userRepository.findById(id).orElseThrow(null);
	}
	
	public User updateUserDao(Long id,User updatedUser) {
		User oldUser=getUserDao(id);
		oldUser.setUser_name(updatedUser.getUser_name());
		oldUser.setEmail(updatedUser.getEmail());
		oldUser.setPhone_number(updatedUser.getPhone_number());
		oldUser.setPassword(updatedUser.getPassword());
		oldUser.setRole(updatedUser.getRole());
		return userRepository.save(oldUser);
	}

	public boolean deleteUserDao(Long id) {
		try {
			User user=getUserDao(id);
			if(user!=null) {
				userRepository.delete(user);
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	

}
