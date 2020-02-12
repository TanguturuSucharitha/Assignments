package cts.ui;

import javax.persistence.EntityManager;

import cts.model.ContractEmployee;
import cts.model.Employee1;
import cts.model.Manager;
import cts.util.JPAUtil;

public class Example2 {
	
	public static void main(String[] args) {
		Employee1 e=new Employee1(101,"suchi",25000);
		Manager m=new Manager(102,"Ramu",35000,9500);
		ContractEmployee ce=new ContractEmployee(103,"Kittu",42000,11);
		
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.persist(m);
		em.persist(ce);
		em.getTransaction().commit();
		
		System.out.println("Saved");
		JPAUtil.shutdown();
	}

}
