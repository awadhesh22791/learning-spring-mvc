package com.awadhesh22791.springmvclearning.hibernate.test;

import com.awadhesh22791.springmvclearning.entity.Instructor;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeleteInstructorDemo {
public static void main(String[] args) {
	Instructor ram=Instructor.builder().id(1).build();
	ram.delete();
	log.info("Rows deleted instructor with id: {}.",1);
}
}
