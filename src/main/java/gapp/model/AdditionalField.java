package gapp.model;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "additionalfields")
public class AdditionalField implements Serializable {

	@Id
	@GeneratedValue
	private Integer addFieldId;

	private String fieldName;

	private String fieldType;

	private Boolean isRequired;

	private Integer numberValue;

	private String textValue;

	private File fileValue;

	@ManyToOne
	private Application application;

	@ManyToOne
	private Department dept;

	public AdditionalField() {

	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Integer getNumberValue() {
		return numberValue;
	}

	public void setNumberValue(Integer numberValue) {
		this.numberValue = numberValue;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public File getFileValue() {
		return fileValue;
	}

	public void setFileValue(File fileValue) {
		this.fileValue = fileValue;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Integer getAddFieldId() {
		return addFieldId;
	}

	public void setAddFieldId(Integer addFieldId) {
		this.addFieldId = addFieldId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

}
