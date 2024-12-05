package com.example.springjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.LocalTime;

@Controller
public class HomeController {

	@GetMapping({"/", "/home"})
	public String home() {
		return "home";
	}

	@PostMapping("/calculateElapsedTime")
	public String calculateElapsedTime(@RequestParam("timeInput") String timeInput, Model model) {
		try {
			System.out.println("Fucking ass hole coming...");
			LocalTime inputTime = LocalTime.parse(timeInput);
			LocalTime currentTime = LocalTime.now();

			Duration duration = Duration.between(inputTime, currentTime);
			long elapsedHours = duration.toHours();

			model.addAttribute("elapsedHours", elapsedHours);
			model.addAttribute("isElapsed9HoursOrMore", elapsedHours >= 9);
		} catch (Exception e) {
			model.addAttribute("error", "Invalid time format. Please enter time in HH:mm format.");
		}

		return "timeResult";
	}
}
