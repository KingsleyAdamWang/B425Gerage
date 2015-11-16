package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//日期配置类 实现日期date对象与String类型之间的相互转换
public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	
	
	public static String dateToString(Date d) {

		return sdf.format(d);
	}

	
	
	public static String dateToString() {
		Date date = Calendar.getInstance().getTime();
		return sdf.format(date);
	}
	
	
	
	public static Date stringToDate(String d){
		try {
			return sdf.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("日期输入不符合逻辑");
			return Calendar.getInstance().getTime();
		}
	}
}
