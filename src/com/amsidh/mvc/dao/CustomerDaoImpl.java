package com.amsidh.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amsidh.mvc.model.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
    
	private Session session;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCustomer(Customer customer) {
         session.beginTransaction();
         session.save(customer);
         session.getTransaction().commit();
         session.close();
	}

	@Override
	public List<Customer> getAllCustomer() {
		session.beginTransaction();
        List<Customer> customerList=(List<Customer>)session.createQuery("from Customer").list();
        session.getTransaction().commit();
        session.close();
		return customerList;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = sessionFactory.openSession();;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
}
