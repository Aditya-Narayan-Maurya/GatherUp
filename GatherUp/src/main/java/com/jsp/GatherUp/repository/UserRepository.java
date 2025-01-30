package com.jsp.GatherUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.GatherUp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
