package com.jsp.GatherUp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.GatherUp.entity.Event;
import com.jsp.GatherUp.entity.User;

public interface EventRepository extends JpaRepository<Event, Long>{
  
}
