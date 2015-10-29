package vo;

import java.util.Date;

public class ReceiveVO {
	String id, name;
	Date d;

	public ReceiveVO(String id, String name, Date d) {
		super();
		this.id = id;
		this.name = name;
		this.d = d;
	}

	public ReceiveVO() {
		// TODO Auto-generated constructor stub
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
