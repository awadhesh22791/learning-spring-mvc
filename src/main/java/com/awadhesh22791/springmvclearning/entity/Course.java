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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.LAZY)
	@JoinColumn(name = "instructor")
	private Instructor instructor;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private List<Review>reviews;
	
	public void add(Review review) {
		if(this.reviews==null) {
			this.reviews=new ArrayList<>();
		}
		this.reviews.add(review);
	}

	public void save() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
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
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
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

	public void saveReviews() {
		SessionFactory factory = new Configuration()
								.configure().addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		try (Session session = factory.openSession()){
			session.beginTransaction();
			Course currentCourse = session.load(Course.class, this.id);
			this.getReviews().forEach(review->currentCourse.add(review));
			session.save(currentCourse);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
	public Course getCourseReviews() {
		Course course=null;
		SessionFactory factory = new Configuration()
								.configure().addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
								.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			Query<Course> getCourseQuery = session.createQuery("select c from Course c"
					+ " JOIN FETCH c.reviews"
					+ " where c.id=:courseId", Course.class);
			getCourseQuery.setParameter("courseId", this.id);
			course = getCourseQuery.getSingleResult();
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		return course;
	}
}
