package po.businessPO;

import java.io.Serializable;
import java.util.Date;

import enumSet.Sex;
import util.DateUtil;

/**
 * 储存司机信息的PO
 * 
 * @author 汪盼
 *
 */
public class DriverPO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 司机的编号a
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
	private Date birth;
	/**
	 * 司机的性别
	 */
	private Sex sex;
	/**
	 * 手机号码
	 */
	private String telNumber;
	/**
	 * 司机的所属的机构的编号
	 */
	private String institutionID;

	/**
	 * 行驶证期限 也就是行驶证的能用到什么时候 额没有行驶证大致猜测一下就是这个功能
	 */
	private Date driveLicence;

	public DriverPO(String id, String name, String iDnumber, Date d,Sex sex,
			String telNumber, String institutionID, Date driveLicence) {
		super();
		this.id = id;
		this.name = name;
		IDnumber = iDnumber;
		this.birth = d;
		this.sex = sex;
		this.telNumber = telNumber;
		this.institutionID = institutionID;
		this.driveLicence = driveLicence;
	}

	public DriverPO(String data) {
		String strs[] = data.split(" ");
		this.id = strs[0];
		this.name = strs[1];
		this.IDnumber = strs[2];
		this.birth = DateUtil.stringToDate(strs[3]);
		this.sex = Sex.getSex(strs[4]);
		this.telNumber = strs[5];
		this.institutionID = strs[6];
		this.driveLicence = DateUtil.stringToDate(strs[7]);
	}

	public String toString() {
		return id + " " + name + " " + IDnumber + " "
				+ DateUtil.dateToString(birth) + " "+sex.getSexString()+" " + telNumber + " "
				+ institutionID + " " + DateUtil.dateToString(driveLicence)+"\n";
	}

	public String getTelNumber() {
		return telNumber;
	}

	public String getIDnumber() {
		return IDnumber;
	}

	public String getInstitutionID() {
		return institutionID;
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

	public Date getBirth() {
		return birth;
	}

	public Sex getSex(){
	  return sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((institutionID == null) ? 0 : institutionID.hashCode());
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
		DriverPO other = (DriverPO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (institutionID == null) {
			if (other.institutionID != null)
				return false;
		} else if (!institutionID.equals(other.institutionID))
			return false;
		return true;
	}

}
