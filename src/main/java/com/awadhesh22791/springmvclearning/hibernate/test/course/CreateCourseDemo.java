package com.awadhesh22791.springmvclearning.hibernate.test.course;

import com.awadhesh22791.springmvclearning.entity.Course;
import com.awadhesh22791.springmvclearning.entity.Instructor;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreateCourseDemo {
	public static void main(String[] args) {
		Instructor instructor=new Instructor();
		instructor.load(4);
		Course course=Course.builder().title("Bhangra").instructor(instructor).build();
		course.save();
		log.info("Saved course: {}.",course);
	}
}
