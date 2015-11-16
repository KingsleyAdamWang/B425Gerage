package po;

import java.io.Serializable;
import java.util.Date;

import enumSet.ReceiptsState;

public class ReceivePO extends ReceiptsPO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	//快递单号
	private String id;
	//收件人的姓名
	private String name;
	//日期
	private Date d;


	


	
	//构造方法
	public ReceivePO(ReceiptsState state, String userID, String id, String name,
			Date d) {
		super(state, userID);
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
