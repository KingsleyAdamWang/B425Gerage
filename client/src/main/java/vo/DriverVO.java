package vo;

public class DriverVO {
	private String id;
	private String name;

	public DriverVO(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public DriverVO(){
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
