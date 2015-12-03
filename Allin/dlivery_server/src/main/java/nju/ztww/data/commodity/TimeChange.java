package nju.ztww.data.commodity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TimeChange {
 
  public ArrayList<String> timechange(String begintime,String endtime) throws ParseException{
	  ArrayList<String>  timetlist=new ArrayList<String>();
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd"); 
	java.util.Date   begin= sdf.parse(begintime);      
	java.util.Date   end=  sdf.parse(endtime);      
	double   between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒      
	double  day=between/(24*3600);
	for(int i = 1;i<=day;i++){

  Calendar cd = Calendar.getInstance();   
  cd.setTime(sdf.parse(begintime));   
  cd.add(Calendar.DATE, i);//增加一天   
  //cd.add(Calendar.MONTH, n);//增加一个月
 System.out.println(sdf.format(cd.getTime()));
  timetlist.add(sdf.format(cd.getTime()));
	}
  return timetlist;
	
  }
  public static void main(String[]args) throws ParseException{
	  TimeChange time=new TimeChange();
	  ArrayList<String>  timetlist=new ArrayList<String>();
	  timetlist=time.timechange("15/11/15", "15/12/1");
  }
}
