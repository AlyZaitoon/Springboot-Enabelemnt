package com.example.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	SessionFactory sessionfactory;
	
	protected Session currentSession() {
		return sessionfactory.openSession();
	}
	
	@Override
	public void create(UserModel user) {
		Session session=currentSession();
		try {
		    // Step 4: Use .persist() method to save the entity
		    session.beginTransaction();
		    session.persist(user);
		    session.getTransaction().commit();
		} catch (Exception e) {
		    session.getTransaction().rollback();
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		

		
	}

	@Override
	public void update(UserModel user) {
		Session session=currentSession();
		try {
		    // Step 4: Use .merge() method to update the entity
		    session.beginTransaction();
		    session.update(user);
		    session.getTransaction().commit();
		} catch (Exception e) {
		    session.getTransaction().rollback();
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		
	}

	@Override
	public UserModel edit(Long userId) {
		return find(userId);
	}

	@Override
	public void delete(Long userId) {
		Session session=currentSession();
		UserModel detachedUser=session.get(UserModel.class, userId);

		
		if (detachedUser != null) {
		    try {
		        // Step 3: Use .delete() method to delete the entity
		        session.beginTransaction();
		        session.delete(detachedUser);
		        session.getTransaction().commit();
		    } catch (Exception e) {
		        session.getTransaction().rollback();
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		} else {
		    System.out.println("user with ID " + userId + " not found. Nothing to delete.");
		}
	}

	@Override
	public UserModel find(Long userId) {
		return currentSession().get(UserModel.class, userId);
	}

	@Override
	public List<UserModel> getAll() {
		// Assuming you have properly configured the SessionFactory (usually done at application startup)

		// Step 1: Obtain a session
		Session session = currentSession();
		List<UserModel> users = null;
		try {
		    // Step 2: Create a CriteriaBuilder and CriteriaQuery
		    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		    CriteriaQuery<UserModel> criteriaQuery = criteriaBuilder.createQuery(UserModel.class);
		    
		    // Step 3: Set the root entity for the query (similar to 'FROM' in HQL)
		    Root<UserModel> root = criteriaQuery.from(UserModel.class);
		    criteriaQuery.select(root);
		    
		    // Step 4: Execute the query
		    users = session.createQuery(criteriaQuery).getResultList();

		    // Step 5: Process the fetched entities
		    for (UserModel user : users) {
		        // Do something with each entity
		        System.out.println(user);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return users;
	}

}
