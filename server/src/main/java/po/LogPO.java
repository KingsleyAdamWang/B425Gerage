package po;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作日志的po
 * @author 王栋
 *
 */
public class LogPO {
	
	//操作日志每个信息列表
	private  List<String> records;
	
	public LogPO(){
		records = new ArrayList<String>();
	}

	public List<String> getRecords() {
		return records;
	}

	public void setRecords(List<String> records) {
		this.records = records;
	}
	
	
	
	
}
