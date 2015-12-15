package vo;

import java.util.Date;

import po.DriverPO;
import enumSet.Sex;

public class DriverVO {
	/**
	 * 司机的编号
	 */
	String id;
	/**
	 * 司机的姓名
	 */
	String name;
	/**
	 * 司机的身份证号
	 */
	String IDnumber;
	/**
	 * 司机的出生日期
	 */
	Date birth;
	/**
	 * 司机的性别
	 */
	Sex sex;
	/**
	 * 手机号码
	 */
	String telNumber;
	/**
	 * 司机的所属的机构的编号
	 */
	String institutionID;
	/**
	 * 行驶证期限 也就是行驶证的能用到什么时候 额没有行驶证大致猜测一下就是这个功能
	 */
	Date driveLicence;

	public DriverVO(String id, String name, String iDnumber, Date d, Sex sex,
			String telNumber, String institutionID, 
			 Date driveLicence) {
		super();
		this.id = id;
		this.name = name;
		this.IDnumber = iDnumber;
		this.birth = d;
		this.sex = sex;
		this.telNumber = telNumber;
		this.institutionID = institutionID;
		this.driveLicence = driveLicence;
	}

	public DriverVO(DriverPO po) {
		this(po.getId(), po.getName(), po.getIDnumber(), po.getBirth(), po
				.getSex(), po.getTelNumber(), po.getInstitutionID(), po
				.getDriveLicence());
	}

	public DriverPO transtoPO() {
		return new DriverPO(id, name, IDnumber, birth, sex, telNumber,
				institutionID, driveLicence);

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
		DriverVO other = (DriverVO) obj;
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
