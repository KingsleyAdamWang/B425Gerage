package businessLogicService.businessHallBLService;

import vo.BussinessHallVo.TruckVO;

public interface TruckBLService {
	public TruckVO find(String id);

	public String add(TruckVO vo);

	public String delete(TruckVO vo);

	public String modify(TruckVO vo);
	
}
