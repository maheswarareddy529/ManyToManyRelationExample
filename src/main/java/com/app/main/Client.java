package com.app.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Role;
import com.app.model.User;
import com.app.util.HBUtils;

public class Client {

	public static void main(String[] args) {

		Session session = HBUtils.getSessionFactoryInstance().getCurrentSession();
		Transaction tx = session.beginTransaction();
		

		User user1 = new User("Maheswara");
		User user2 = new User("Basireddy");
		
		Role role1 = new Role();
		role1.setName("Developer");
		
		Role role2 = new Role();
		role2.setName("Admin");
		
		Role role3 = new Role();
		role3.setName("Manager");
		
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user1.getRoles().add(role3);

		
		user2.getRoles().add(role1);
		user2.getRoles().add(role2);
	
		session.persist(user1);
		session.persist(user2);

		tx.commit();

		System.out.println("=========================");
	}

}
