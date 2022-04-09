package com.awadhesh22791.springmvclearning.hibernate.test;

import java.util.List;

import com.awadhesh22791.springmvclearning.entity.Student;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HibernateTestApp {
	public static void main(String[] args) {
		//Student awadhesh=Student.builder().firstName("Awadhesh").lastName("Kumar").email("awadhesh22791@gmail.com").build();
		//awadhesh.save();
		Student awadhesh=new Student();
		List<Student> allStudents = awadhesh.all();
		log.info("Saved {}.",allStudents.size());
	}
}
