package com.awadhesh22791.springmvclearning.hibernate.test;

import com.awadhesh22791.springmvclearning.entity.Student;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreateStudentDemo {
	public static void main(String[] args) {
		Student student=Student.builder().firstName("Janny").lastName("Shrivastava").email("jannyshri@gmail.com").build();
		student.save();
		log.info("Saved student {}.",student);
	}
}
