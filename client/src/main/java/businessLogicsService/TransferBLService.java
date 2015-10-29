package businessLogicsService;

import vo.TransferVO;

public interface TransferBLService {
	public void add(String id);

	public void end();

	public boolean submit(TransferVO vo);
}
