package nju.ztww.ui.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	
	public static String getDate(){
		Date now = new Date();
		SimpleDateFormat matter= new SimpleDateFormat("yyyy/MM/dd");
		String date = matter.format(now);
		return date;
	}
	
	public static String getDate2(){
		Date now = new Date();
		SimpleDateFormat matter= new SimpleDateFormat("yyyyMMdd");
		String date = matter.format(now);
		return date;
	}

}
