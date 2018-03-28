package com.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentDemo {
	public static void main(String[] args) {
		//System.out.println("first ");
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// System.out.println("creating new student object...");
			
			Student tempStudent = new Student("gre1","weel1","h1rev@luv2code.com");
			//Student tempStudent1 = new Student("gre2","weel2","h2rev@luv2code.com");
			
			session.beginTransaction();
			System.out.println("saving the student");
			session.save(tempStudent);
			//session.save(tempStudent1);
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
			
		}
	}

}
