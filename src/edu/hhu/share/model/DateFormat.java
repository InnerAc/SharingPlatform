package edu.hhu.share.model;

import java.util.Date;


public class DateFormat {

	public static int YYMMDD = 1;
	
	public static String format(Date date){
		String res = "";
		String month = (date.getMonth()+1)<10?("0"+(date.getMonth()+1)):((date.getMonth()+1)+"");
		String day = (date.getDate())<10?("0"+(date.getDate())):((date.getDate())+"");
		res += (date.getYear()+1900)+"-"+month+"-"+day;
		String hour = (date.getHours())<10?("0"+(date.getHours())):((date.getHours())+"");
		String minu = (date.getMinutes())<10?("0"+(date.getMinutes())):((date.getMinutes())+"");
		String seco = (date.getSeconds())<10?("0"+(date.getSeconds())):((date.getSeconds())+"");
		res += " "+hour+":"+minu+":"+seco;
		return res;
	}
	
	public static String format(Date date,int i){
		String res = "";
		String month = (date.getMonth()+1)<10?("0"+(date.getMonth()+1)):((date.getMonth()+1)+"");
		String day = (date.getDate())<10?("0"+(date.getDate())):((date.getDate())+"");
		res += (date.getYear()+1900)+"-"+month+"-"+day;
		return res;
	}
}
