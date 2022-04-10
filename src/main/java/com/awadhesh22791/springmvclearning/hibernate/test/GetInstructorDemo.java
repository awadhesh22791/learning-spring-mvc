package com.awadhesh22791.springmvclearning.hibernate.test;

import com.awadhesh22791.springmvclearning.entity.Instructor;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GetInstructorDemo {
	public static void main(String[] args) {
		Instructor rahul=new Instructor();
		rahul.load(3);
		log.info("Loaded instructor: {}.",rahul);
	}
}
