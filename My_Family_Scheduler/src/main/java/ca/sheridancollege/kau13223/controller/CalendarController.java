package ca.sheridancollege.kau13223.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ca.sheridancollege.kau13223.beans.Event;
import ca.sheridancollege.kau13223.database.DatabaseAccess;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/events") // http://localhost:8080/api/v1/events
public class CalendarController {

	private DatabaseAccess da;

	@GetMapping
	public List<Event> getEventList() {

		return da.findAll();
	}

	@GetMapping(value = "/{id}") // http://localhost:8080/api/v1/events/5 where 5 is an example of id.
	public Event getIndividualStudent(@PathVariable Long id) {
		return da.findById(id);
	}

	@PostMapping(consumes = "application/json")
	public String postEvent(@RequestBody Event event) {
		return "http://localhost:8080/api/v1/events/" + da.save(event);
	}

	@PutMapping(consumes = "application/json")
	public String putEventList(@RequestBody List<Event> eventList) {
		// da.deleteAll();
		da.saveAll(eventList);
		return "Total Records: " + da.count();

	}

	@DeleteMapping
	public String deleteAllevents() {
		da.deleteAll();
		return "All events deleted" + da.count();
	}

	@DeleteMapping(value = "/{id}")
	public String deleteIndividualEvent(@PathVariable Long id) {

		da.deleteById(id);
		return "Events deleted" ;
	}

	


}
