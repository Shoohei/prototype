package com.fnsystems.prototype.mvc.event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fnsystems.prototype.business.event.EventService;
import com.fnsystems.prototype.persistence.event.EventEntity;
import com.fnsystems.prototype.persistence.storage.StorageService;

@Controller
public class EventController {

	@Autowired
    private StorageService storageService;
    
	@Autowired
	private EventService eventService;
	
    @GetMapping("/addevent")
	public String initForm(ModelMap model) {
		// Empty entity
		model.addAttribute("event", new EventEntity());

		// View's name
		return "addevent";
	}

	@PostMapping(value = "/addevent")
	public String submit(@ModelAttribute EventEntity event, ModelMap model, @RequestParam("file") MultipartFile file) throws IOException {

		// Add the image to the event
		event.setImage(file.getOriginalFilename());
		
		// Store the event
		event = eventService.save(event);
		
		// Store the file
		storageService.store(file, String.valueOf(event.getId()));
		
		model.addAttribute("event", event);
		
		// View's name
		return "result";
	}
	
	@GetMapping(value = "/result/{eventId}")
	public String getEvent(@PathVariable(value="eventId") String eventId, ModelMap model) throws IOException {
		
		EventEntity event = eventService.getEvent(Long.valueOf(eventId));
		
		model.addAttribute("event", event);
		
		// View's name
		return "result";
	}
	
	@RequestMapping(value = "/image/{imageId}")
	@ResponseBody
	public byte[] loadImage(@PathVariable String imageId) throws IOException  {
	  Path image = storageService.load(imageId);
	  
	  return Files.readAllBytes(image);
	}
	
    @GetMapping("/events")
	public ModelAndView getEvents(ModelMap model) {
    	ModelAndView modelAndView = new ModelAndView("events_page");
    	
		modelAndView.addObject("events", eventService.getEvents());
		
		modelAndView.addObject("test1", "Test1");
 
		return modelAndView;
	}
}
