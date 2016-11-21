package gapp.model;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "applications")
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer appId;
	
	@ManyToOne
	private User user;
	
	private Date dateSubmitted;
	

	@OneToOne
	private ApplicationStatus status;

	@ManyToOne
	private Program program;

	private File transcript;

	private String term;
	
	private String fname;
	
	private String lname;
	
	private String email;
	
	private String cin;

	private Long phoneNo;

	private String gender;
	
	private String citizenship;

	private String dob;
	
	private Integer tofelScore;

	private Integer greScore;

	private Boolean isInternationalStudent;
	
	private String filename;
	

	

	@ManyToOne
	private Department department;


	@OneToMany(mappedBy = "applicationId")
	private List<EducationalBackground> education;
	

	@OneToMany(mappedBy = "application")
	private List<AdditionalField> additionalFields;
	

	@OneToMany(mappedBy = "appli")
	private List<AdditionalApplicationMaterial> additionalMaterial;
	
	

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<AdditionalApplicationMaterial> getAdditionalMaterial() {
		return additionalMaterial;
	}

	public void setAdditionalMaterial(List<AdditionalApplicationMaterial> additionalMaterial) {
		this.additionalMaterial = additionalMaterial;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	

	
	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}
	
	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getTofelScore() {
		return tofelScore;
	}

	public void setTofelScore(Integer tofelScore) {
		this.tofelScore = tofelScore;
	}

	public Integer getGreScore() {
		return greScore;
	}

	public void setGreScore(Integer greScore) {
		this.greScore = greScore;
	}

	public Boolean getIsInternationalStudent() {
		return isInternationalStudent;
	}

	public void setIsInternationalStudent(Boolean isInternationalStudent) {
		this.isInternationalStudent = isInternationalStudent;
	}



	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<EducationalBackground> getEducation() {
		return education;
	}

	public void setEducation(List<EducationalBackground> education) {
		this.education = education;
	}

	public List<AdditionalField> getAdditionalFields() {
		return additionalFields;
	}

	public void setAdditionalFields(List<AdditionalField> additionalFields) {
		this.additionalFields = additionalFields;
	}

	public File getTranscript() {
		return transcript;
	}

	public void setTranscript(File transcript) {
		this.transcript = transcript;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
