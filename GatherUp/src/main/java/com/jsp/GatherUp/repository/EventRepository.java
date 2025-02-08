package com.jsp.GatherUp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.GatherUp.entity.Event;
import com.jsp.GatherUp.entity.User;

public interface EventRepository extends JpaRepository<Event, Long>{
	
	@Query("SELECT e FROM Event e JOIN e.registrations r GROUP BY e HAVING COUNT(r) >= 2 ORDER BY COUNT(r) DESC")
	List<Event> findTrendingEvents();

}
