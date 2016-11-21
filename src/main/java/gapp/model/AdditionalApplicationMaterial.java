package gapp.model;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materials")
public class AdditionalApplicationMaterial implements Serializable {

	@Id
	@GeneratedValue
	private Integer Id;

	private String materialName;

	private File material;

	@ManyToOne
	private Application appli;

	@ManyToOne
	private User user;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public File getMaterial() {
		return material;
	}

	public void setMaterial(File material) {
		this.material = material;
	}

	public Application getAppli() {
		return appli;
	}

	public void setAppli(Application appli) {
		this.appli = appli;
	}
}
