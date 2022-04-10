package com.awadhesh22791.springmvclearning.hibernate.test;

import com.awadhesh22791.springmvclearning.entity.InstructorDetail;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeleteInstructorDetailDemo {
	public static void main(String[] args) {
		InstructorDetail instructorDetail = InstructorDetail.builder().id(3).build();
		instructorDetail.delete();
		log.info("Deleted Instructor detail: {}", instructorDetail);
	}
}
