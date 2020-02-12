package cts.ui;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import cts.model.Course;
import cts.model.Trainee;
import cts.util.JPAUtil;

public class Example5 {
	public static void main(String[] args) {
		Course mca=new Course(101,"MCA",new TreeSet<Trainee>());
		Course mba=new Course(102,"MBA",new TreeSet<Trainee>());
		
		mca.getTrainees().add(new Trainee(201,"Suchi",mca));
		mca.getTrainees().add(new Trainee(202,"Venu",mca));
		mca.getTrainees().add(new Trainee(203,"Anji",mca));
		
		mba.getTrainees().add(new Trainee(204,"Srinu",mba));
		mba.getTrainees().add(new Trainee(205,"uma",mba));
		mba.getTrainees().add(new Trainee(206,"renu",mba));
		
		EntityManager em= JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn=em.getTransaction();
		
		txn.begin();
		em.persist(mca);
		em.persist(mba);
		txn.commit();
		
		

		
	}

}