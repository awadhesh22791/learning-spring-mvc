package com.awadhesh22791.springmvclearning.hibernate.test;

import com.awadhesh22791.springmvclearning.entity.Employee;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeleteEmployeeDemo {
	public static void main(String[] args) {
		Employee awadhesh = Employee.builder().id(1).build();
		int rowDeleted = awadhesh.delete();
		log.info("Row deleted {}.", rowDeleted);
	}
}
