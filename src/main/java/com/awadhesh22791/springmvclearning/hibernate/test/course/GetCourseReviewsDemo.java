package com.awadhesh22791.springmvclearning.hibernate.test.course;

import com.awadhesh22791.springmvclearning.entity.Course;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GetCourseReviewsDemo {
	public static void main(String[] args) {
		Course course=Course.builder().id(1).build();
		Course courseReviews = course.getCourseReviews();
		log.info("Loaded course reviews: {}.",courseReviews);
	}
}
