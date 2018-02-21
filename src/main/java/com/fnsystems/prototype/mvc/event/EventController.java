package com.fnsystems.prototype.mvc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fnsystems.prototype.persistence.event.EventEntity;
import com.fnsystems.prototype.persistence.event.EventRepository;

@Controller
public class EventController {

	@Autowired
	private EventRepository eventRepository;

    @GetMapping("/addevent")
	public String initForm(ModelMap model) {
		// Empty entity
		model.addAttribute("event", new EventEntity());

		// View's name
		return "addevent";
	}

	@PostMapping(value = "/addevent")
	public String submit(@ModelAttribute EventEntity event, ModelMap model) {
		
		// Add fake value in order to store
		event.setDescription("description");
		event.setHow("how");
		event.setImage("image");
		event.setLatitude("latitude");
		event.setLongitude("longitude");
		event.setPrice("price");
		event.setWhen("when");
		event.setWhere("where");
		event = eventRepository.save(event);
		
		model.addAttribute("event", event);
		
		// View's name
		return "result";
	}
}
