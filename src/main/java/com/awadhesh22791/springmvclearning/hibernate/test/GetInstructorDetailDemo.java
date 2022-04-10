package com.awadhesh22791.springmvclearning.hibernate.test;

import com.awadhesh22791.springmvclearning.entity.InstructorDetail;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class GetInstructorDetailDemo {
	public static void main(String[] args) {
		InstructorDetail instructorDetail=InstructorDetail.builder().id(2).build();
		instructorDetail=instructorDetail.get(3);
		log.info("Loaded instructor detail: {}.",instructorDetail);
		log.info("Loaded Instructor: {}.",instructorDetail.getInstructor());
	}
}
