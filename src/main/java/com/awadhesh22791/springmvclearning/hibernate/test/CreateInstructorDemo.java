package com.awadhesh22791.springmvclearning.hibernate.test;

import com.awadhesh22791.springmvclearning.entity.Instructor;
import com.awadhesh22791.springmvclearning.entity.InstructorDetail;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreateInstructorDemo {

	public static void main(String[] args) {
		InstructorDetail instructorDetail=InstructorDetail.builder().youtubleChannel("Youtube channel").hobby("Singing").build();
		Instructor instructor=Instructor.builder().firstName("Ram").lastName("Singh").email("ram.singh@gmail.com").instructorDetail(instructorDetail).build();
		instructor.save();
		log.info("Saved Instructor: {}.",instructor);
	}

}
