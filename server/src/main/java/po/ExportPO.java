package po;

import java.util.Date;
import java.util.List;

/**
 * 出库单的PO
 * @author 王栋
 *
 */
public class ExportPO {
	//出库时间
    private Date d;
    
    //快递编号 
    private List<String> IDList;
    
    //目的地
    private String destination;
    
    //监装员
    private UserPO checkPeople;
    
    //中转单编号
    private String id;
    
    //运费
    private double fare;

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public List<String> getIDList() {
		return IDList;
	}

	public void setIDList(List<String> iDList) {
		IDList = iDList;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public UserPO getCheckPeople() {
		return checkPeople;
	}

	public void setCheckPeople(UserPO checkPeople) {
		this.checkPeople = checkPeople;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}
    
    
}
