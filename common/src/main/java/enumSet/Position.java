package enumSet;

public enum Position {

	JOB_1("快递员"), JOB_2("营业厅业务人员"), JOB_3("中转中心业务人员"), JOB_4("中转中心仓库管理员"), JOB_5(
			"财务人员（高）"), JOB_6("财务人员（低）"), JOB_7("总经理"), JOB_8("管理员");
	
	private String position;
	
	private Position(String string){
		this.position = string ;
	}

   public static Position getPosition(String string){
	   
	   
	   switch(string){
	   case "快递员":
		   return JOB_1;
	   case "营业厅业务人员":
		   return JOB_2;
	   case "中转中心业务人员":
		   return JOB_3;
	   case "中转中心仓库管理员":
		   return JOB_4;
	   case "财务人员（高）":
		   return JOB_5;
	   case "财务人员（低）":
		   return JOB_6;
	   case "总经理":
		   return JOB_7;
	   case "管理员":
		   return JOB_8;
	   default:
		   return null;

		   
	   }
   }
   
   
   public String getPositionString(){
	   return  position;
   }
}
