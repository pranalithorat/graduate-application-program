package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "programs")
public class Program implements Serializable {

	@Id
	@GeneratedValue
	private Integer prgmId;

	private String programName;
	
	

	@ManyToOne
/*	@JsonBackReference*/
	private Department dept;

	@OneToMany(mappedBy = "program",cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Application> applications;



	public Program() {
		super();

	}

	public Integer getPrgmId() {
		return prgmId;
	}

	public void setPrgmId(Integer prgmId) {
		this.prgmId = prgmId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public List<Application> getApplications() {
		return applications;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	

 
}
