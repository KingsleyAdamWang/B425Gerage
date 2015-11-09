package enumSet;

public enum Express {
	//经济快递，标准快递，特快专递

	ECONOMY("经济"),STANDARD("标准"),FAST("特快");
	
	private String type;
	
	private Express(String string){
		type = string;
	}
	
	
	//将字符串转换为  枚举类型
	public static Express getExpress(String string){
		switch(string){
		case  "经济":
		return ECONOMY;
		case  "标准":
		return STANDARD;
		case "特快":
		return FAST;
		default:
		return null;
		}
	}
	
	
	//将该枚举类型转化为字符串
	public  String getExpressString(){
		return type;
	}
	
//	public static void main(String[] args) {
//		Express ex = Express.FAST;
//		System.out.println(ex.getType());
//		String str = ex.getType();
//		if(Express.getExpress(str)!=null)
//			System.out.println("true");
//		else System.out.println("false");
//	}
}