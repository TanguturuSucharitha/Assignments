package cts.ui;

import javax.persistence.EntityManager;

import cts.model.Address;
import cts.model.Faculty;
import cts.util.JPAUtil;

public class CompositionDemo {
	public static void main(String[] args) {
		
		Faculty f=new Faculty("suchi",new Address("E234","Marthalli","Banglore,Karnataka."));
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		em.persist(f);
		
		//em.flush();
		em.getTransaction();
		System.out.println("Faculty Saved");
		JPAUtil.shutdown();
	}

}
