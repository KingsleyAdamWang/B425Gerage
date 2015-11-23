package vo;

import java.util.Date;

import po.LogPO;


public class LogVO {
	private Date d;

	private String identityID;
	private String message;

	/**
	 * 构造函数
	 * 
	 * @param d
	 * @param message
	 */
	public LogVO(Date d, String identityID, String message) {
		super();
		this.d = d;
		this.identityID = identityID;
		this.message = message;
	}

	public LogVO(LogPO po) {
		this(po.getD(), po.getIdentityID(), po.getMessage());
	}

	public LogPO transToPO() {
		
		return new LogPO(d, identityID, message);
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIdentityID() {
		return identityID;
	}

	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}

}
