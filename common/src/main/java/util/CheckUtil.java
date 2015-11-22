package util;

public class CheckUtil {
	
	public static boolean checkInsID(String id){
		if(id.length()!=8){
			return false;
		}
		for(int i=0;i<id.length();i++){
			if(id.charAt(i)<'0'||id.charAt(i)>'9'){
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean checkStaffID(String id){
		if(id.length()!=10){
			return false;
		}
		for(int i=0;i<id.length();i++){
			if(id.charAt(i)<'0'||id.charAt(i)>'9'){
				return false;
			}
		}
		return true;
	}
}
