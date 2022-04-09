package com.awadhesh22791.springmvclearning.hibernate.test;

import java.util.Date;

import com.awadhesh22791.springmvclearning.model.Employee;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreateEmployeeDemo {
	public static void main(String[] args) {
		Employee awadhesh = Employee.builder().firstName("Rahul").lastName("Kumar").company("Oscorp").active(true)
							.department("HR").joinAt(new Date()).build();
		awadhesh.save();
		log.info("Saved employee details {}.",awadhesh);
	}
}
