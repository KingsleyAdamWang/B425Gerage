package enumSet;

public enum InsType {
	businessHall("营业厅"),intermediate("中转中心");
	
	private String type;
	private InsType(String string){
		this.type=string;
		
	}
	
	public InsType getInsType(String string){
		switch(string){
		case "营业厅":
			return businessHall;
		case "中转中心":
			return intermediate;
		default:
			return null;
		}
	}
	
	public String getInsTypeString(){
		return type;
	}

}
