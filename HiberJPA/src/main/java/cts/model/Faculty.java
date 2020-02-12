package cts.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty")

public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long facId;
	private String facName;
	
	@Embedded
	private String Address;
	
	public Faculty() {
		
	}

	public Faculty(Long facId, String facName, String address) {
		super();
		this.facId = facId;
		this.facName = facName;
		Address = address;
	}

	public Long getFacId() {
		return facId;
	}

	public void setFacId(Long facId) {
		this.facId = facId;
	}

	public String getFacName() {
		return facName;
	}

	public void setFacName(String facName) {
		this.facName = facName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}
