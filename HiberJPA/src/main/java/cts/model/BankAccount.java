package cts.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BankAccount1")
public class BankAccount {
	@Id
	private String accno;
	
	@OneToOne
	@JoinColumn(name="aadhar")
	private Customer customer;

	public BankAccount() {

	}

	public BankAccount(String accno, Customer customer) {
		super();
		this.accno = accno;
		this.customer = customer;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	



}
