package nju.ztww.data.order;


public class NowPlace {
	
	public String findCity(String ID){
		
		if(ID=="025"){
			return "北京";
		}else if(ID=="035"){
			return "上海";
		}else if(ID=="045"){
			return "广州";
		}else{
			return "南京";
		}
	}
	public String findTransfer(String ID){
		
		if(ID=="01"){
			return "中转中心一";
		}else{
			return "中转中心二";
		}
		
	}
	public String findBussiness(String ID){
	 
	    if(ID=="001"){
	    	return "营业厅一";
	    }else  if(ID=="002"){
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
