package po;

import java.io.Serializable;

public class DriverPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public DriverPO(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public DriverPO(){
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
