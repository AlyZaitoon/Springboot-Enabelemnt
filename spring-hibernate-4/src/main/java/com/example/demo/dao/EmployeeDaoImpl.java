package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.Employee;

import jakarta.persistence.EntityManager;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private EntityManager entityManager;
	@Override
	public List<Employee> get() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		Employee e = entityManager.find(Employee.class,id);

		entityManager.remove(e);
		System.out.println(get().size());
		System.out.println(id);
	}

}
