package cts.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("cemp")

@Table(name="ContractEmployee")

public class ContractEmployee extends Employee1 {
	
 @Column(name="Duration")	
 
 private int duration;
 
 public ContractEmployee() {
		
	}

public ContractEmployee(long eid,String ename, double basic,int duration) {
	super(eid,ename,basic);
	this.duration = duration;
}

public int getDuration() {
	return duration;
}

public void setDuration(int duration) {
	this.duration = duration;
}

@Override
public String toString() {
	return "ContractEmployee [duration=" + duration + "]";
}

}

