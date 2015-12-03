package nju.ztww.bl.commodity;

public class StringToInt {
  public int changetoint(String way){
	  int index=0;
	 if(way.equals("火车")){
		 index=0;
	 }
	 else if(way.equals("飞机")){
		 index=1;
	 }
	 else if(way.equals("汽车")){
		 index=2;
	 }
	 return index;
  }
}
