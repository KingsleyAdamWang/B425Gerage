package enumSet;

//到达单所需要填写的状态
public enum ArrivalState {
	
	//三种状态 完整损坏和丢失
	complete("完整"),spoiled("损坏"),missed("丢失");
	
	private String state;
	
	private ArrivalState(String string){
		state = string;
	}
	
	public static ArrivalState getArrivalState(String string){
	
		switch(string){
		case "完整":
			return complete;
		case "损坏":
			return spoiled;
		case "丢失":
			return missed;
		default:
			return null;
		}
	}
	
	public String getStateString(){
		return state;
	}

}
