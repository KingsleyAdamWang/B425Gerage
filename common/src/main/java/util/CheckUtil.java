package util;

import enumSet.InsType;

public class CheckUtil {
	
	public static boolean checkInsID(String id,InsType insType){
		if((insType==InsType.businessHall&&id.length()!=6)||(insType==InsType.intermediate&&id.length()!=4)){
			return false;
		}
		for(int i=0;i<id.length();i++){
			if(id.charAt(i)<'0'||id.charAt(i)>'9'){
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean checkStaffID(String id,String insID){
		if(id.length()!=(insID.length()+2)){
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
