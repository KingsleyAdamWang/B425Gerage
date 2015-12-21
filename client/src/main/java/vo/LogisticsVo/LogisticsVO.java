package vo.LogisticsVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.LogisticsPO;

public class LogisticsVO {
	// 快递单号
	public  String id;
	// 快递的名称
	public  String name;
	// 快递的物流信息
	public  List<String> messages;

	public LogisticsVO(LogisticsPO po) {

		this(po.getId(), po.getName(), po.getMessages());

	}

	public LogisticsVO(String data) {
		messages = new ArrayList<String>();
		String[] temp = data.split(" ");
		this.id = temp[0];
		this.name = temp[1];

		if (temp.length == 3) {
			String[] message = temp[2].split(";");
			for (String str : message)
				messages.add(str);
		}

	}

	public LogisticsPO transToPO() {
		return new LogisticsPO(this.getId(), this.getName(), this.getMessages());

	}

	/**
	 * 构造函数
	 * 
	 * @param id
	 * @param name
	 */
	public LogisticsVO(String id, String name) {

		this.id = id;
		this.name = name;
		this.messages = new ArrayList<String>();
	}

	public LogisticsVO(String id, String name, List<String> messages) {
		super();
		this.id = id;
		this.name = name;
		this.messages = messages;
	}

	public String getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	

	public void addMessages(String string) {
		messages.add(string);

	}

	public List<String> getMessages() {
		return messages;
	}

	
	public String toString() {

		StringBuilder result = new StringBuilder(this.id + " " + this.name
				+ " ");
		for (String str : messages)
			result.append(str + ";");
		return result.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogisticsVO other = (LogisticsVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
