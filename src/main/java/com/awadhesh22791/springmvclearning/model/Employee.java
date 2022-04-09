package com.awadhesh22791.springmvclearning.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee",schema = "hb_student_tracker")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "company")
	private String company;
	@Column(name="active",nullable = false)
	private boolean active;
	@Column(name="department",nullable = false)
	private String department;
	@Column(name="join_at")
	@Temporal(TemporalType.DATE)
	private Date joinAt;

	public void save() {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();
			session.save(this);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
	public void load(Integer id) {
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(this.getClass())
									.buildSessionFactory();
		try(Session session = factory.getCurrentSession()) {
			session.beginTransaction();
			session.load(this, id);
			session.getTransaction().commit();
		} finally {
				factory.close();
		}
	}
	
	public List<Employee> load(String company) {
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(this.getClass())
								.buildSessionFactory();
		List<Employee> resultList=Collections.emptyList();
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();
			resultList = session.createQuery("from Employee where company=:company",Employee.class).setParameter("company", company).getResultList();
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		return resultList;
	}
	
	public int delete() {
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(this.getClass())
								.buildSessionFactory();
		int rowsUpdated;
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();
			rowsUpdated = session.createQuery("delete from Employee where id=:id").setParameter("id", this.id).executeUpdate();
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		return rowsUpdated;
	}
}
