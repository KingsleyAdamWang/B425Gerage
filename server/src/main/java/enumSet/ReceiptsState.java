package enumSet;

public enum ReceiptsState {

	approve("已审批"),unapprove("未审批");
	
	private String receiptsState ;
	
	private ReceiptsState(String string){
		receiptsState = string;
	}
	
	public static ReceiptsState getReceiptsState(String string){
		switch(string){
		case "已审批":
			return approve;
		case "未审批":
			return unapprove;
		default:
			return null;
		}
	}
	
	public String getReceiptsStateString(){
		return receiptsState;
	}
}
