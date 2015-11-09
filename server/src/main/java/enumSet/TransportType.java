package enumSet;

public enum TransportType {
	PLANE("飞机"),TRAIN("火车"),CAR("汽车");
	
private String transportType;
	
	private TransportType(String string){
		transportType = string ;
	}
	
	public static TransportType getTransportType(String string){
		switch(string){
		case "飞机":
			return PLANE;
		case "火车":
			return TRAIN;
		case "汽车":
			return CAR;
		default :
			return null;
		}
	}
	
	
	public String getTransportTypeString(){
		return transportType;
	}
}
