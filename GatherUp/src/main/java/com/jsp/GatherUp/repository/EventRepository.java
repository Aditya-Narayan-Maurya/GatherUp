package com.jsp.GatherUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.GatherUp.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
