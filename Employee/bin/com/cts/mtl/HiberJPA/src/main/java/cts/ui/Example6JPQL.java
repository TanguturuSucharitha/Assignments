package cts.ui;

import java.util.List;

import javax.persistence.EntityManager;

import com.mysql.cj.Query;

import cts.model.Employee;
import cts.model.Employee1;
import cts.util.JPAUtil;

public class Example6JPQL {
	@SuppressWarnings("unchecked")

	public static void main(String[] args) {
	         EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
	         
	         Employee1 emp=em.find(Employee1.class,101);
	         
	         if(emp!=null)
	        	 System.out.println(emp);
	}
	String qryString="Select e from Employee1 e";
	Query qry=em.createQuery(qryString);
		
	display(qry.getResultList());
	
	display(em.createQuery("SELECT e FROM Emloyee WHERE e,basic>25000")
			.getResultList());
	List<String> names=em.createQuery("SELECT e.ename FROM Employee1 e").getResultList();
			for(String n:names) {
				System.out.println(n);			

	}
         em.close();
         JPAUtil.shutdown();
}
static void display(List<Employee> data) {
	System.out.println("-----------------------------------------");
	for(Employee e:data) {
		System.out.println(e);
	}
		System.out.println("------------------------------------");
		
	}
}