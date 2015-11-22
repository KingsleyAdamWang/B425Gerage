package enumSet;

public enum InsType {
	businessHall("营业厅"),intermediate("中转中心"),management("管理层机构");
	
	private String type;
	private InsType(String string){
		this.type=string;
		
	}
	
	public static InsType getInsType(String string){
		switch(string){
		case "营业厅":
			return businessHall;
		case "中转中心":
			return intermediate;
		case "管理层机构":
			return management;
		default:
			return null;
		}
	}
	
	public String getInsTypeString(){
		return type;
	}

}
