package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 操作日志的po
 * @author 王栋
 *
 */
public class LogPO {
	
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
