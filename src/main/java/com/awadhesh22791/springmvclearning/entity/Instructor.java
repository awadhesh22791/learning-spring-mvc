package com.awadhesh22791.springmvclearning.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "instructor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetail;
	@OneToMany(mappedBy = "instructor",
			cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	private List<Course>courses;
	
	public void addCourse(Course course) {
		if(this.courses==null) {
			this.courses=new ArrayList<>();
		}
		this.courses.add(course);
		course.setInstructor(this);
	}

	public void save() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(this.getClass())
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();
		try (Session session=factory.getCurrentSession()) {
			session.beginTransaction();
			session.persist(this);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
	public void load(Integer id) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(this.getClass())
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();
		try (Session session=factory.getCurrentSession()) {
			session.beginTransaction();
			session.load(this, id);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
	public Instructor loadFetchJoin(Integer id) {
		Instructor instructor=null;
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(this.getClass())
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();
		try (Session session=factory.getCurrentSession()) {
			session.beginTransaction();
			Query<Instructor> instructorQuery = session.createQuery("select i from Instructor i"
					+ " JOIN FETCH i.courses"
					+ " where i.id=:id", Instructor.class);
			instructorQuery.setParameter("id", id);
			instructor = instructorQuery.getSingleResult();
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		return instructor;
	}
	
	public void delete() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(this.getClass())
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();
		this.load(this.id);
		try (Session session=factory.getCurrentSession()) {
			session.beginTransaction();
			session.delete(this);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
