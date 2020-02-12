package cts.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;

import cts.model.Employee;
import cts.util.JPAUtil;

public class Example1 {
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		
		Employee e=new Employee();
		System.out.println("Empid:");
		e.setEmpId(scan.nextInt());
		System.out.println("Ename:");
		e.setEmpName(scan.next());
		System.out.println("Basic:");
		e.setBasic(scan.nextDouble());
		
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		System.out.println("Emp Saved!");
		JPAUtil.shutdown();
		scan.close();
		
}
}