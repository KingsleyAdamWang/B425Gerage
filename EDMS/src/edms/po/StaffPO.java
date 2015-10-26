package edms.po;

import java.io.Serializable;

public class StaffPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public StaffPO(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public StaffPO(){
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return name;
	}
}
