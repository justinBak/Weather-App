package com.tts.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	
	@GetMapping(value="/")
	public String getIndex(Model model) {

		Request request = new Request();
		model.addAttribute("request", request);
		model.addAttribute("lastRequests", weatherService.getLastRequests());
		return "index";
	}
	
	@PostMapping(value="/")
	public String postIndex(Request request, Model model) {
		Response data = weatherService.getForecast(request.getZipCode());
		model.addAttribute("data", data);
		model.addAttribute("lastRequests", weatherService.getLastRequests());
		return "index";
	}
}
