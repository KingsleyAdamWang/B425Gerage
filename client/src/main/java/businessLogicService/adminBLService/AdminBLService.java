package businessLogicService.adminBLService;

import java.util.List;

import vo.InstitutionVO;
import vo.UserVO;

public interface AdminBLService {


   //查找某一个特定的用户
   public List<UserVO> search(String Key);
   //修改一个用户的秘密
   public String modify(String identityID,String newPassWord);
   //输入机构的id 返回属于这个机构的所有的UserPO
   public List<UserVO> getUserListByInsID(String institutionID);
   //刚开始的时候是显示各个机构的列表
   public List<InstitutionVO> getInsList();
  
   
   
   
}
