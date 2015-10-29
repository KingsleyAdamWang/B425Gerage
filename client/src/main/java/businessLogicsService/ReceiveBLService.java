package businessLogicsService;

import vo.ReceiveVO;

public interface ReceiveBLService {
	public void add(String id);

	public void end();

	public boolean submit(ReceiveVO vo);
}
