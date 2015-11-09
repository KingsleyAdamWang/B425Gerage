package po;

import java.util.ArrayList;
import java.util.List;

/**
 * 物流信息的po
 * @author 王栋
 *
 */
public class LogisticsPO {
	
	//快递单号
    private String id;
    //快递的名称
    private String name;
    //快递的物流信息
    private List<String> messages;
    
    public LogisticsPO(String id , String name){
    	
    	this.id = id;
    	this.name =name;
    	this.messages = new ArrayList<String>();
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

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
    
    
  
}
