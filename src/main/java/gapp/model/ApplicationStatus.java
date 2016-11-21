package gapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applicationStatuses")
public class ApplicationStatus implements Serializable {

	@Id
	@GeneratedValue
	private Integer AppStatusId;

	private String status;

	private String dateChanged;

	private String comments;

	@OneToOne
	private User updatedBy;

	@OneToOne
	private Application appId;

	public ApplicationStatus() {

	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Application getAppId() {
		return appId;
	}

	public void setAppId(Application appId) {
		this.appId = appId;
	}

	public Integer getAppStatusId() {
		return AppStatusId;
	}

	public void setAppStatusId(Integer appStatusId) {
		AppStatusId = appStatusId;
	}



	public String getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(String dateChanged) {
		this.dateChanged = dateChanged;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
