package po;

public class InstitutionPO {

	private String institutionID;
	private String name;
	
	public InstitutionPO(String institutionID,String Name){
		this.institutionID=institutionID;
		this.name = name;
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
	
	

}
