package vo.LogVo;

import java.util.Date;

import po.logPO.LogPO;


public class LogVO {
	public Date d;

	public  String identityID;
	public  String message;

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


	public String getMessage() {
		return message;
	}



	public String getIdentityID() {
		return identityID;
	}



}
