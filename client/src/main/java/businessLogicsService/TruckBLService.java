package businessLogicsService;

import vo.TruckVO;

public interface TruckBLService {
	public TruckVO check(String message);

	public void add(String message);

	public void delete(String id);

	public void end();
}
