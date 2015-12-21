package po.logPO;

import java.io.Serializable;
import java.util.Date;

import util.DateUtil;

/**
 * 操作日志的po
 * 
 * @author 王栋
 *
 */
public class LogPO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date d;

	private String identityID;
	private String message;

	/**
	 * 构造函数
	 * 
	 * @param d
	 * @param message
	 */
	public LogPO(Date d, String identityID, String message) {
		super();
		this.d = d;
		this.identityID = identityID;
		this.message = message;
	}

	public LogPO(String data) {
		super();
		String temp[] = data.split(" ");
		this.d = DateUtil.stringToDateDetail(temp[0]);
		this.identityID = temp[1];
		this.message = temp[2];
	}

	public String toString() {
		return DateUtil.dateToStringDetail(d) + " " + this.identityID + " "
				+ this.message + "\n";
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
