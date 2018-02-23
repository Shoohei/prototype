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

import com.fnsystems.prototype.persistence.event.EventEntity;
import com.fnsystems.prototype.persistence.event.EventRepository;
import com.fnsystems.prototype.persistence.storage.StorageService;

@Controller
public class EventController {

	@Autowired
    private StorageService storageService;
    
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
	public String submit(@ModelAttribute EventEntity event, ModelMap model, @RequestParam("file") MultipartFile file) throws IOException {
		
		// Add fake value in order to store
		event.setDescription("description");
		event.setHow("how");
		event.setImage(file.getOriginalFilename());
		event.setLatitude("latitude");
		event.setLongitude("longitude");
		event.setPrice("price");
		event.setWhen("when");
		event.setWhere("where");
		event = eventRepository.save(event);
		
		// Store the file
		storageService.store(file, String.valueOf(event.getId()));
		
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
}
