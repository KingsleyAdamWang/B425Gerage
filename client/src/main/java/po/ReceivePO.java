package po;

import java.util.Date;

public class ReceivePO {
	String id, name;
	Date d;

	public ReceivePO(){
		
	}
	
	public ReceivePO(String id, String name, Date d) {
		super();
		this.id = id;
		this.name = name;
		this.d = d;
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

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}
}
