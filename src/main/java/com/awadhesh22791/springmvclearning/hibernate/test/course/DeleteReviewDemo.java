package com.awadhesh22791.springmvclearning.hibernate.test.course;

import com.awadhesh22791.springmvclearning.entity.Review;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeleteReviewDemo {

	public static void main(String[] args) {
		Review reviewToDelete=Review.builder().id(3).build();
		int rowUpdated= reviewToDelete.delete();
		log.info("Deleted review {}.",rowUpdated);
	}

}
