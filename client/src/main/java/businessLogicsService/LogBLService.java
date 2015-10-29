package businessLogicsService;

import java.util.List;

import vo.LogVO;

public interface LogBLService {
	public void update(LogVO vo);
	
	public List<LogVO> check();
}
