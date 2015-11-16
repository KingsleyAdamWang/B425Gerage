package enumSet;

public enum InventoryArea {
	
	AREA_FOR_PLANE("飞机分区"),AREA_FOR_TRAIN("火车分区"),AREA_FOR_CAR("汽车分区"),AREA_AUTO("自动分区");
	
	private String area;
	private InventoryArea(String string){
		area = string ;
	}
	
	public static InventoryArea getInventoryArea(String string){
		switch (string){
		case "飞机分区":
			return AREA_FOR_PLANE;
		case "火车分区":
			return AREA_FOR_TRAIN;
		case "汽车分区":
			return AREA_FOR_CAR;
		case "自动分区":
			return AREA_AUTO;
		default:
			return null;
		}
	}
	
	
	public String getAreaString(){
		return area;
	}

}
