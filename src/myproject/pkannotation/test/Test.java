package myproject.pkannotation.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import myproject.pkannotation.entity.Employee;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
		
		Configuration cfg = new Configuration();
		cfg.configure("/myproject/pkannotation/resources/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(cfg.getProperties());
		StandardServiceRegistry registry = builder.build();
		sessionFactory = cfg.buildSessionFactory(registry);
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEname("Ritik");
		emp.setEsal(4532);
		emp.setEaddr("Bhopal");
		session.save(emp);
		tx.commit();
		
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		
	}
}
