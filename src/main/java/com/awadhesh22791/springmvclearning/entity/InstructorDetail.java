package com.awadhesh22791.springmvclearning.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "instructor_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"instructor"})
@Builder
public class InstructorDetail {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "youtube_channel")
	private String youtubleChannel;
	@Column(name = "hobby")
	private String hobby;
	@OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
	private Instructor instructor;
	
	public void load() {
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		try (Session session = factory.getCurrentSession()){
			session.beginTransaction();
			session.load(this, this.id);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
	public InstructorDetail get(Integer id) {
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		InstructorDetail instructorDetail=null;
		try (Session session = factory.getCurrentSession()){
			session.beginTransaction();
			instructorDetail = session.get(this.getClass(), id);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		return instructorDetail;
	}
}
