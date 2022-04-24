package com.awadhesh22791.springmvclearning.hibernate.test.course;

import com.awadhesh22791.springmvclearning.entity.Course;
import com.awadhesh22791.springmvclearning.entity.Review;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class CreateReviewDemo {
	public static void main(String[] args) {
		
		Course course=Course.builder().id(6).build();
		course.add(Review.builder().comment("Nice learning.").build());
		course.add(Review.builder().comment("Great job.").build());
		course.add(Review.builder().comment("Awsome!").build());
		course.saveReviews();
		log.info("Added reviews: {}",course.getReviews());		
	}
}
