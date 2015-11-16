package enumSet;

public enum PayType {

	
	staff1("营业厅业务员"),staff2("中转中心业务员"),staff3("仓库管理员"),staff4("快递员"),staff5("司机"),other("其他");
	
	private String type;
	
	private PayType(String string){
		type = string;
	}
	
	public static PayType getPayType(String string){
		switch(string){
		case "营业厅业务员":
			return staff1;
		case "中转中心业务员":
			return staff2;
		case "仓库管理员":
			return staff3;
		case "快递员":
			return staff4;
		case "司机":
			return staff5;
		default:
			return other;
		}
		
	}
	
	
	public String getPayTypeString(){
		return type;
	}
}
