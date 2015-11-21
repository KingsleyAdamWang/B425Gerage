package businessLogicService.adminBLService;

import java.util.List;

import po.InstitutionPO;
import po.UserPO;

public interface AdminBLService {


   //查找某一个特定的用户
   public List<UserPO> search(String Key);
   //修改一个用户的秘密
   public String modify(String identityID,String newPassWord);
   //输入机构的id 返回属于这个机构的所有的UserPO
   public List<UserPO> getUserListByInsID(String institutionID);
   //刚开始的时候是显示各个机构的列表
   public List<InstitutionPO> getInsList();
  
   
   
   
}
