package vo;

import java.util.Date;

import po.DriverPO;
import util.DateUtil;

public class DriverVO {
	/**
	 * 司机的编号
	 */
	private String id;
	/**
	 * 司机的姓名
	 */
	private String name;
	/**
	 * 司机的身份证号
	 */
	private String IDnumber;
	/**
	 * 司机的出生日期
	 */
	private Date d;
	/**
	 * 手机号码
	 */
	private String telNumber;
	/**
	 * 司机的所属的机构的编号
	 */
	private String institutionID;
	/**
	 * 车牌号
	 */
	private String truckID;
	/**
	 * 工作年限 若不填则为零
	 */
	private int workYears;
	/**
	 * 行驶证期限 也就是行驶证的能用到什么时候 额没有行驶证大致猜测一下就是这个功能
	 */
	private Date driveLicence;

	public DriverVO(String id, String name, String iDnumber, Date d, String telNumber, String institutionID,
			String truckID, int workYears, Date driveLicence) {
		super();
		this.id = id;
		this.name = name;
		this.IDnumber = iDnumber;
		this.d = d;
		this.telNumber = telNumber;
		this.institutionID = institutionID;
		this.truckID = truckID;
		this.workYears = workYears;
		this.driveLicence = driveLicence;
	}

	public DriverVO(DriverPO po) {
		this(po.getId(), po.getName(), po.getIDnumber(), po.getD(), po.getTelNumber(), po.getInstitutionID(),
				po.getTruckID(), po.getWorkYears(), po.getDriveLicence());
	}
	
	public DriverPO transtoPO(){
		return new DriverPO(id, name, IDnumber,  d,  telNumber,  institutionID,
				 truckID,  workYears, driveLicence);
		
	}

	public String getTelNumber() {
		return telNumber;
	}

	public String getIDnumber() {
		return IDnumber;
	}

	public Date getD() {
		return d;
	}

	public String getInstitutionID() {
		return institutionID;
	}

	public String getTruckID() {
		return truckID;
	}

	public Date getDriveLicence() {
		return driveLicence;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}




}
