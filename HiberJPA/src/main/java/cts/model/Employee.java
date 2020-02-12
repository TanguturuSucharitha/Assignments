package cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TestEmps")
public class Employee {
	@Id
	@Column(name="eid")
	private int empId;
	
	@Column(name="ename",nullable=false)
	private String empname;
	
	private double basic;
	
	public Employee() {
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empname;
	}

	public void setEmpName(String empName) {
		this.empname = empName;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empname=" + empname + ", basic=" + basic + "]";
	}

}
