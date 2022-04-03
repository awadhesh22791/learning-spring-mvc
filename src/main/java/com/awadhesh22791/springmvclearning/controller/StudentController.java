package com.awadhesh22791.springmvclearning.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awadhesh22791.springmvclearning.model.Student;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/student")
@Log4j2
public class StudentController {
	
	List<String>countries=Arrays.asList(new String[]{"India","France","Italy","Brazil"});
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("form")
	public String form(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "student/form";
	}
	
	@PostMapping("process")
	public String form(@Valid @ModelAttribute("student") Student student,BindingResult result) {
		log.info("Processing student detail: {}",student);
		if(result.hasErrors()) {
			return "student/form";
		}
		return "student/save";
	}
	
}
