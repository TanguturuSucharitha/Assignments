package cts.model;

import javax.persistence.Column;
//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("manager")
@Table(name="manager")
public class Manager extends Employee1 {
	@Column(name="allowances")
	private double allowances;
	
	public Manager() {
		
	}

	public Manager(long eid,String ename,double basic,double allowances) {
		super(eid,ename,basic);
		this.allowances=allowances;
	}

	public double getAllowances() {
		return allowances;
	}

	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}

	@Override
	public String toString() {
		return "Manager [allowances=" + allowances + "]";
	}


	

}
