package com.awadhesh22791.springmvclearning.hibernate.test;

import java.util.List;

import com.awadhesh22791.springmvclearning.model.Employee;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class GetEmployeeDemo {

	public static void main(String[] args) {
		Employee awadhesh=new Employee();
		awadhesh.load(5);
		log.info("Loaded employee: {}.",awadhesh);
		
		Employee oscorpEmployee=new Employee();
		List<Employee> oscorpEmployees = oscorpEmployee.load("Oscorp");
		log.info("Oscorp employees: {}",oscorpEmployees);
	}

}
