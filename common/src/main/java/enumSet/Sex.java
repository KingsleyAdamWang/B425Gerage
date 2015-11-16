package enumSet;

public enum Sex {

	MALE("男"),FEMALE("女");
	
	private String sex;
	private Sex(String string){
		sex = string;
	}
	
	public static Sex getSex(String string){
		switch(string){
		case "男":
			return MALE;
		case "女":
			return FEMALE;
		default:
			return null;
		}
	}
	
	public String getSexString(){
		return sex;
	}
//	
//	public static void main(String[] args) {
//		Sex sex = FEMALE;
//		System.out.println(sex.getSexString());
//		
//		Sex temp = Sex.getSex(sex.getSexString());
//		System.out.println(temp.getSexString());
//		
//	}
//	
}
