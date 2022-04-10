package com.awadhesh22791.springmvclearning.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "instructor" })
@Builder
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "instructor")
	private Instructor instructor;

	public void save() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();
			session.save(this);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

	public void delete() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();
			session.load(this, this.id);
			session.delete(this);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
