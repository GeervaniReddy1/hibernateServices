package com.hibernate1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			//start a transaction
			session.beginTransaction();
			System.out.println("create");
			//query students
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudent);
			
			//Query the students last name: 1
			System.out.println("Query the students last name: weel1");
			theStudent = session.createQuery("from Student s where s.lastName = 'weel1'").list();
			displayStudents(theStudent);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done");
			
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student tempStudent:theStudent) {
			System.out.println(tempStudent);
		}
	}

}
