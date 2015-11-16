package businessLogicService.manageBLService;

import java.util.List;

import vo.InstitutionVO;

public interface InstitutionBLService {
	public List<InstitutionVO> show();
	
	public String addStaff(InstitutionVO insVO);
	
	public String deleteStaff(InstitutionVO insVO);
	
	public String addIns(InstitutionVO insVO);
	
	public String deleteIns(InstitutionVO insVO);
	
	public InstitutionVO search(String id);
}
