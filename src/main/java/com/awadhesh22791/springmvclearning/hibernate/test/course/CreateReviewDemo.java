package com.awadhesh22791.springmvclearning.hibernate.test.course;

import com.awadhesh22791.springmvclearning.entity.Course;
import com.awadhesh22791.springmvclearning.entity.Review;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class CreateReviewDemo {
	public static void main(String[] args) {
		
		Course course=Course.builder().id(1).build();
		course.add(Review.builder().comment("Good book to read.").build());
		course.add(Review.builder().comment("Nice thought process of writer.").build());
		course.add(Review.builder().comment("Depth of knowledge").build());
		course.saveReviews();
		log.info("Added reviews: {}",course.getReviews());		
	}
}
