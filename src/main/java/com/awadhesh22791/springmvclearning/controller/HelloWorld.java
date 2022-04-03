package com.awadhesh22791.springmvclearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorld {

	@GetMapping("/show")
	public String showForm() {
		return "helloworld-form";
	}
	
	@GetMapping("/process")
	public String processForm(@RequestParam String studentName,Model model) {
		studentName=studentName.toUpperCase();
		model.addAttribute("message", "Yo! "+studentName);
		return "helloworld";
	}
}
