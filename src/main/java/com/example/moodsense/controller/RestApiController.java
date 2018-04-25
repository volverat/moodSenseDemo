package com.example.moodsense.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moodsense.model.Event;
import com.example.moodsense.model.User;
import com.example.moodsense.repository.EventRepository;
import com.example.moodsense.repository.UserRepository;
import com.example.moodsense.util.ResourceNotFoundException;

/**
 * @author victor olvera
 * REST Controller
 */

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	//Add log
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	UserRepository userRepository; //Service to get information
	
	@Autowired
	EventRepository eventRepository;
	
	
 
    // -------------------New User-------------------------------------------
	// Create a new User
	@PostMapping("/user/")
	public User createUser(@Valid @RequestBody User user) {
	    return userRepository.save(user);
	}
    
    
 // -------------------New Event-------------------------------------------
    
	// Create a new User
	@PostMapping("/event/")
	public Event createEvent(@Valid @RequestBody Event event) {
	    return eventRepository.save(event);
	}
    
    
 // -------------------Retrieve All the Events by user id---------------------------------------------
    @GetMapping(value = "/events/byUser/{id}")
    public List<Event> getEventsByUserId(@PathVariable("id") int id) {
        List<Event> events = eventRepository.getEventsByUserId(id);//Sending the user_id
        return events;
    }
 
    // -------------------Retrieve Single Event by Id------------------------------------------
    @GetMapping(value = "/event/{id}")
    public Event getEventId(@PathVariable("id") int id) {
    	
    	Event result = eventRepository.getEventById(id);
    	if (result == null) {
    		throw new ResourceNotFoundException("Event", "id", id);
    	}
    	return result;
                
    }
    
 // -------------------Retrieve All the Events by Date---------------------------------------------
    @GetMapping(value = "/event/byDate/{date}")
    public List<Event> getEventByDate(@PathVariable("date") String date) {
    	
    	List<Event> events = eventRepository.getEventsByDate(date);
    	if (events.isEmpty() || events == null) {
    		throw new com.example.moodsense.util.ResourceNotFoundException("Event", "date", date);
    	}
    	return events;
                
    }
 
 
 
}
