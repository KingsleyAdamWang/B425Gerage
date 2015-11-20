package po;

import java.io.Serializable;

import enumSet.InsType;

public class InstitutionPO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String institutionID;
	private String city;
	private String name;
	private InsType type;

	public InstitutionPO(String institutionID, String city, String Name,InsType type) {
		this.institutionID = institutionID;
		this.name = name;
		this.city = city;
		this.type = type;

	}

	public String toString() {
		return institutionID + " " + city + " " + name + "\n";
	}

	public String getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((institutionID == null) ? 0 : institutionID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstitutionPO other = (InstitutionPO) obj;
		if (institutionID == null) {
			if (other.institutionID != null)
				return false;
		} else if (!institutionID.equals(other.institutionID))
			return false;
		return true;
	}

	public InsType getType() {
		return type;
	}

	public void setType(InsType type) {
		this.type = type;
	}
	
	

}
