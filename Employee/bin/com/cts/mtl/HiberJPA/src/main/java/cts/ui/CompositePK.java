package cts.ui;

import java.util.Date;

import javax.persistence.EntityManager;

import cts.model.Student;
import cts.model.StudentIdentity;
import cts.util.JPAUtil;

public class CompositePK {
   public static void main(String[]args) {
	   Student s=new Student();
	   
	   EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
	   em.getTransaction().begin();
	   em.persist(s);
	   em.getTransaction().commit();
	   System.out.println("Saved");
	   JPAUtil.shutdown();
   }
}
