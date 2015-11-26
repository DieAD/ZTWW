package nju.ztww.data.order;

import nju.ztww.DBHelper.DBForDCForm;
import nju.ztww.dao.DCFormDO;
import nju.ztww.po.PriceDataPO;

public class MailingOrderData {
	DBForDCForm dbForDCForm ;
	
	public PriceDataPO getPriceInfo(String place1, String place2, String type){
		PriceDataPO priceData;
		dbForDCForm = new DBForDCForm();
		dbForDCForm.init();
		DCFormDO dcForm = dbForDCForm.query(place1, place2);
		double distance = dcForm.getDistance();
		double priceConst = dcForm.getSta();
		double typePrice = 0 ;
		System.out.println("place1 = "+place1+"            place2 = "+place2+"       type = "
				+type);
		if(type.equals("标准")) typePrice = dcForm.getSta()/priceConst;
		else if(type.equals("特快")) typePrice = dcForm.getFas()/priceConst;
		else if(type.equals("经济")) typePrice = dcForm.getEco()/priceConst;
		else System.out.println("error!");
		priceData = new PriceDataPO(priceConst, distance, typePrice);
		System.out.println("priceConst = "+priceConst+"          distance = "+distance+
				"         typePrice = "+typePrice);
		dbForDCForm.close();
		return priceData;
	}
}
