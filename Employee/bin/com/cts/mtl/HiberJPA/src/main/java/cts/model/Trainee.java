package cts.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Trainees")
public class Trainee implements Comparable<Trainee> {

	@Id
	private int admNo;
	private String sName;
	
	@ManyToOne
	@JoinColumn(name="cId")
	private Course course;

	public Trainee() {
		super();
		
	}

	public Trainee(int admNo, String sName, Course course) {
		super();
		this.admNo = admNo;
		this.sName = sName;
		this.course = course;
	}

	public int getAdmNo() {
		return admNo;
	}

	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
	public int compareTo(Trainee o) {
		return(this.admNo<o.admNo?-1:(this.admNo>admNo?1:0));
	}
}

