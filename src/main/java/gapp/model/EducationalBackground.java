package gapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "educationalbackgrounds")
public class EducationalBackground implements Serializable {

	@Id
	@GeneratedValue
	private Integer edBckId;// id

	private String univName;

	private String timeAttendedTo;
	
	private String timeAttendedFrom;

	private String degreeEarned;

	private String degreeMajor;

	private String gpa;

	@ManyToOne
	private User user;

	@ManyToOne
	private Application applicationId;

	public EducationalBackground() {

	}

	public Integer getEdBckId() {
		return edBckId;
	}

	public void setEdBckId(Integer edBckId) {
		this.edBckId = edBckId;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}



	public String getTimeAttendedTo() {
		return timeAttendedTo;
	}

	public void setTimeAttendedTo(String timeAttendedTo) {
		this.timeAttendedTo = timeAttendedTo;
	}

	public String getTimeAttendedFrom() {
		return timeAttendedFrom;
	}

	public void setTimeAttendedFrom(String timeAttendedFrom) {
		this.timeAttendedFrom = timeAttendedFrom;
	}

	public String getDegreeEarned() {
		return degreeEarned;
	}

	public void setDegreeEarned(String degreeEarned) {
		this.degreeEarned = degreeEarned;
	}

	

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Application getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Application applicationId) {
		this.applicationId = applicationId;
	}

	public String getDegreeMajor() {
		return degreeMajor;
	}

	public void setDegreeMajor(String degreeMajor) {
		this.degreeMajor = degreeMajor;
	}

}
