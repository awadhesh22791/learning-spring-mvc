package com.awadhesh22791.springmvclearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "comment", nullable = false, length = 500)
	private String comment;

	public int delete() {
		int rowUpdated=0;
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			rowUpdated = session.createQuery("DELETE FROM Review r WHERE r.id=:reviewId")
							.setParameter("reviewId", this.id)
							.executeUpdate();
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		return rowUpdated;
	}
}
