package nju.ztww.data.order;


public class NowPlace {
	
	public String findCity(String ID){
		String city=ID.substring(0, 3);
		if(city=="025"){
			return "北京";
		}else if(city=="035"){
			return "上海";
		}else if(city=="045"){
			return "广州";
		}else{
			return "南京";
		}
	}
	public String findTransfer(String ID){
		
		String transfer=ID.substring(3, 5);
		if(transfer=="01"){
			return "中转中心一";
		}else{
			return "中转中心二";
		}
		
	}
	public String findBussiness(String ID){
	    String bussiness=ID.substring(5, 8);
	    if(bussiness=="001"){
	    	return "营业厅一";
	    }else  if(bussiness=="002"){
	    	return "营业厅二";
	    }else{
	    	return "营业厅其他";
	    }
		
	}
	
	public String findBusinessPlace(String ID){
		return findCity(ID.substring(0, 3))+findTransfer(ID.substring(3, 5))+findBussiness(ID.substring(5, 8));
	}
	public String findTransferPlace(String ID){
		return findCity(ID.substring(0, 3))+findTransfer(ID.substring(3, 5));
	}
}
