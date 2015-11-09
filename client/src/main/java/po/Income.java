package po;

import java.util.Date;
import java.util.List;

/**
 * 收款单
 * @author 王栋
 *
 */
public class Income {
	
	
	//收款单时间
    private Date d;
    //机构编号
    private String institutionID;
    
    //快递员姓名
    private String deliverMan;
    
    //对应的所有的快递条形码号
    private List<String> IDList;

	public Income(Date d, String institutionID, String deliverMan,
			List<String> iDList) {
		super();
		this.d = d;
		this.institutionID = institutionID;
		this.deliverMan = deliverMan;
		IDList = iDList;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}

	public String getDeliverMan() {
		return deliverMan;
	}

	public void setDeliverMan(String deliverMan) {
		this.deliverMan = deliverMan;
	}

	public List<String> getIDList() {
		return IDList;
	}

	public void setIDList(List<String> iDList) {
		IDList = iDList;
	}
    
    
    
    

}
