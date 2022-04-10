package com.awadhesh22791.springmvclearning.hibernate.test.course;

import com.awadhesh22791.springmvclearning.entity.Course;
import com.awadhesh22791.springmvclearning.entity.Instructor;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreateCourseDemo {
	public static void main(String[] args) {
		Instructor instructor=new Instructor();
		instructor.load(3);
		Course course=Course.builder().title("Mastering HTML").instructor(instructor).build();
		course.save();
		log.info("Saved course: {}.",course);
	}
}
