package po;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志的po
 * @author 王栋
 *
 */
public class LogPO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Date d;
	
	private String message;

	
	/**
	 * 构造函数
	 * @param d
	 * @param message
	 */
	public LogPO(Date d, String message) {
		super();
		this.d = d;
		this.message = message;
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
	
	
	
	
	
	
}
