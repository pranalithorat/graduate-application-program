package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "departments")
public class Department implements Serializable {

	@Id
	@GeneratedValue
	private Integer deptId;

	private String deptName;
	
	


	@OneToMany(mappedBy = "dept")
	
	private List<Program> graduateProgrms;

	@OneToMany(mappedBy = "dept")
	private List<AdditionalField> additionalFields;

	@OneToMany(mappedBy = "department")
	private List<Application> application;

	

	public Department() {
		

	}


	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Program> getGraduateProgrms() {
		return graduateProgrms;
	}

	public void setGraduateProgrms(List<Program> graduateProgrms) {
		this.graduateProgrms = graduateProgrms;
	}

	public List<AdditionalField> getAdditionalFields() {
		return additionalFields;
	}

	public void setAdditionalFields(List<AdditionalField> additionalFields) {
		this.additionalFields = additionalFields;
	}
	
	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}


	

}
