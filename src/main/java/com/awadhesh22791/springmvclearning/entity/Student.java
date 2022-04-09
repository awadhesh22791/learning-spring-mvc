package com.awadhesh22791.springmvclearning.entity;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Log4j2
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;

	@Transient
	public String fullName() {
		String fullName = this.firstName;
		if (this.lastName != null && !this.lastName.isEmpty()) {
			fullName += " " + this.lastName;
		}
		return fullName;
	}

	public void save() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(this.getClass())
				.buildSessionFactory();
		Session currentSession = factory.getCurrentSession();
		try {
			currentSession.beginTransaction();
			currentSession.save(this);
			currentSession.getTransaction().commit();
		} finally {
			currentSession.close();
			factory.close();
		}
	}

	public Student get(Integer id) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(this.getClass())
				.buildSessionFactory();
		Session currentSession = factory.getCurrentSession();
		Student student=null;
		try {
			currentSession.beginTransaction();
			currentSession.load(this, id);
			currentSession.getTransaction().commit();
		}catch(ObjectNotFoundException ex) {
			log.info("Student not found for id {}.",id);
		} finally {
			currentSession.close();
			factory.close();
		}
		return student;
	}
	
	public List<Student> all() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(this.getClass())
				.buildSessionFactory();
		Session currentSession = factory.getCurrentSession();
		List<Student> resultList=Collections.emptyList();
		try {
			currentSession.beginTransaction();
			resultList = currentSession.createQuery("from Student",Student.class).getResultList();
			currentSession.getTransaction().commit();
		}catch(ObjectNotFoundException ex) {
			log.info("Student not found for id {}.",id);
		} finally {
			currentSession.close();
			factory.close();
		}
		return resultList;
	}
}
