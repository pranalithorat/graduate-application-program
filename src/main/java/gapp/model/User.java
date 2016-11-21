
package gapp.model;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String fname;
	
	private String lname;

	@Column(nullable = false, unique = true)
	private String email;

	private String password;
	
	private boolean isAdmin;
	
	private boolean isStaff;
	
	private boolean isStudent;
	
	@OneToMany(mappedBy = "user")
	private List<EducationalBackground> edBckgrnd;


	@OneToMany(mappedBy = "user")
	private List<Application> application;
	
	@OneToMany(mappedBy = "user")
	private List<AdditionalApplicationMaterial> material;


	public User() {
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isStaff() {
		return isStaff;
	}

	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	public List<EducationalBackground> getEdBckgrnd() {
		return edBckgrnd;
	}

	public void setEdBckgrnd(List<EducationalBackground> edBckgrnd) {
		this.edBckgrnd = edBckgrnd;
	}

	public void setMaterial(List<AdditionalApplicationMaterial> material) {
		this.material = material;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<AdditionalApplicationMaterial> getMaterial() {
		return material;
	}

	

}