package businessLogicService.businessHallBLService;

import vo.BussinessHallVo.DriverVO;

public interface DriverBLService {
	public DriverVO find(String id);
	
	public String addDriver(DriverVO vo);
	
	public String delete(DriverVO vo);
	
	public String modify(DriverVO vo);
}
