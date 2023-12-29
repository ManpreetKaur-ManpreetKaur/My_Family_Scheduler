package ca.sheridancollege.kau13223.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.kau13223.beans.Event;

/**Added an addEvent method, to add  a new event on the client side. It sends a POST request to the "/api/v1/events" 
 with the data of the new event. After the addition is successful, it redirects the user to the home page " index".*/

@Controller
public class HomeController {

	final String REST_URL = "http://localhost:8080/api/v1/events";

	@GetMapping("/")
	public String index(Model model, RestTemplate restTemplate) {
		ResponseEntity<Event[]> responseEntity = restTemplate.getForEntity(REST_URL, Event[].class);
		model.addAttribute("event", new Event());
		model.addAttribute("eventList", responseEntity.getBody());
		return "index";
	}

	@GetMapping(value = "/getEvent/{id}", produces = "application/json")
	@ResponseBody
	public Event getEvent(@PathVariable int id, RestTemplate restTemplate) {
		ResponseEntity<Event> responseEntity = restTemplate.getForEntity(REST_URL + "/" + id, Event.class);
		return responseEntity.getBody();
	}


	@PostMapping("/addEvent")
	public String addEvent(@ModelAttribute Event newEvent, RestTemplate restTemplate) {
		
		restTemplate.postForEntity(REST_URL, newEvent, String.class);
		return "redirect:/";
	}
	
	@GetMapping(value ="/{id}")
	@ResponseBody
	public String deleteEvent( Model model,@PathVariable Long id, RestTemplate restTemplate) {
		
	    String deleteUrl = REST_URL + "/" + id;
	    restTemplate.delete(deleteUrl);
	   
	    ResponseEntity<Event[]> responseEntity = restTemplate.getForEntity(REST_URL, Event[].class);
        model.addAttribute("eventList", responseEntity.getBody());
	    return "redirect:/";
	    
	   
	}
	

}