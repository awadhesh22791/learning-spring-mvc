package com.awadhesh22791.springmvclearning.hibernate.test.course;

import com.awadhesh22791.springmvclearning.entity.Course;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeleteCourseDemo {
	public static void main(String[] args) {
		Course html=Course.builder().id(2).build();
		html.delete();
		log.info("Deleted course {}.",html);
	}
}
