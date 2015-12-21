package po.logisticsPO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 物流信息的po
 * 
 * @author 王栋
 *
 */
public class LogisticsPO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 快递单号
	private String id;
	// 快递的名称
	private String name;
	// 快递的物流信息
	private List<String> messages;

	public LogisticsPO(String data) {
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

	/**
	 * 构造函数
	 * 
	 * @param id
	 * @param name
	 */
	public LogisticsPO(String id, String name) {

		this.id = id;
		this.name = name;
		this.messages = new ArrayList<String>();
	}

	
	public LogisticsPO(String id, String name, List<String> messages) {
		super();
		this.id = id;
		this.name = name;
		this.messages = messages;
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

	public void addMessages(String string) {
		messages.add(string);

	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	
 public String toString(){
	 
	 StringBuilder  result = new StringBuilder(this.id+" "+this.name+" ");
	 for(String str:messages)
		 result.append(str+";");
	 return result.toString()+"\n";
	 
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
	LogisticsPO other = (LogisticsPO) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
 
 
}
