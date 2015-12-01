package nju.ztww.data.finance;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DateHelper {
	private static final DateFormat FORMATTER = new SimpleDateFormat(
			"yy/MM/dd");

//	public static void main(String[] args) throws ParseException {
//		Calendar startDay = Calendar.getInstance();
//		Calendar endDay = Calendar.getInstance();
//
//		startDay.setTime(FORMATTER.parse("10/02/01"));
//		endDay.setTime(FORMATTER.parse("10/05/09"));
//
//		printDay(startDay, endDay);
//	}
	public ArrayList<String> printDay(Calendar startDay, Calendar endDay) {
		// 给出的日期开始日比终了日大则不执行打印
		ArrayList<String> dateList = new ArrayList<String>();
		if (startDay.compareTo(endDay) >= 0) {
			return dateList;
		}
		// 现在打印中的日期
		Calendar currentPrintDay = startDay;
		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.DATE, 1);
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) == 0) {
				
				break;
			}
			// 打印日期
			System.out.println(FORMATTER.format(currentPrintDay.getTime()));
			String date = FORMATTER.format(currentPrintDay.getTime());
			dateList.add(date);
		}
		return dateList;
	}
	
	public ArrayList<String> SetTime(String startTime,String endTime){
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();

		try {
			startDay.setTime(FORMATTER.parse(startTime));
			endDay.setTime(FORMATTER.parse(endTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//endDay.setTime(FORMATTER.parse("10/05/09"));

		return printDay(startDay, endDay);
	}
}
