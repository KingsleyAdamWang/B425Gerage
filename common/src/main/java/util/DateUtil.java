package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//日期配置类 实现日期date对象与String类型之间的相互转换
/**
 * 关于时间操作的一些实现的工具方法  完全是为了时间而存在 
 * 存在
 * 存在
 * 在
 * zai
 * @author 王栋
 *
 */
public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd|hh:mm:ss");
	
	//将传入的时间对象转化为 string类型
	public static String dateToString(Date d) {

		return sdf.format(d);
	}

	
	//默认将当下时间转化为String 只是精确年月日
	public static String dateToString() {
		Date date = Calendar.getInstance().getTime();
		return sdf.format(date);
	}
	
	//默认将当下时间转化为String 精确到 年月日时分秒   
	/**
	 * 主要是针对操作日志产生的方法 个人认为操作日志需要详细一些  应该精确到时分秒
	 * @return
	 */
	public static String dateToStringDetail(){
		Date date = Calendar.getInstance().getTime();
		return sdf2.format(date);
	}
	
	
	public static String dateToStringDetail(Date d){
		return sdf2.format(d);
	}
	/**
	 * 将string 转为date对象  是精确到时分秒的
	 * @param d
	 * @return
	 */
	public static Date stringToDateDetail(String d){
		try {
			return sdf2.parse(d);
		} catch (ParseException e) {
			
			System.out.println("输入的时间费事不对");
			e.printStackTrace();
			return null;
		}
	}
	
	//将一个String转化为Date对象 利用SimpleDateFormat 来实现
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
	
	//判断输入的时间字符串是否合法 
	public static String isVaild(String date){
		try{
			Date d = stringToDate(date);
			if(Calendar.getInstance().getTime().getTime()<d.getTime())
				return "输入超出了本机时间!";
		}
		catch(Exception e){
			return "输入的格式有误!";
		}
		return null;
	}
	

	//判断输入的起止时间是否合法
	public static String isVaild(String start,String end){
		if(isVaild(start)!=null)
			return "开始时间"+isVaild(start);
		if(isVaild(end)!=null)
			return "结束时间"+isVaild(end);
	    if(stringToDate(end).getTime()<stringToDate(start).getTime())
	    	return "结束时间在开始时间前面咯！";	
		return null;
	}
	
}

