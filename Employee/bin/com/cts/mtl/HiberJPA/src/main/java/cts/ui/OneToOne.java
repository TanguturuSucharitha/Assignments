package cts.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import cts.model.BankAccount;
import cts.model.Customer;
import cts.util.JPAUtil;

public class OneToOne {

	public static void main(String[] args) {
		
		BankAccount ba=new BankAccount();
		Customer cs=new Customer("9441027798","suchi",ba);
		ba.setAccno("SB30761");
		ba.setCustomer(cs);
		
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn=em.getTransaction();
		
		txn.begin();
		em.persist(cs);
		txn.commit();
		JPAUtil.shutdown();

	}

}
