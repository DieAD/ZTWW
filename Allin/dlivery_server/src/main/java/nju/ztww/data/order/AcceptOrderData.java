package nju.ztww.data.order;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForReciveForm;
import nju.ztww.dao.ReciveFormDO;
import nju.ztww.po.AcceptPO;
import nju.ztww.po.TrackPO;

public class AcceptOrderData {
	DBForReciveForm dbForReciveForm;
	private ArrayList<ReciveFormDO> list = new ArrayList<ReciveFormDO>();
	private ReciveFormDO reciveFormDO;///

	public String insert(AcceptPO acceptPO) {
		reciveFormDO = new ReciveFormDO();
		dbForReciveForm = new DBForReciveForm();
		dbForReciveForm.init();
		reciveFormDO.setHoll(acceptPO.getBusinID());
		reciveFormDO.setRecip(acceptPO.getAccepter());
		reciveFormDO.setId(acceptPO.getAcceptID());
		reciveFormDO.setRealtime(acceptPO.getAcceptTime());
		reciveFormDO.setCourierid(acceptPO.getCourier());
		reciveFormDO.setState(acceptPO.getState());
		reciveFormDO.setExe(acceptPO.getExe());
		list.add(reciveFormDO);
        String result=dbForReciveForm.insert(list, "reciveform");
		dbForReciveForm.close();
		System.out.println("Insert successful!");
		return result;
	}
///
	public TrackPO passOrder(String order) {
		
		dbForReciveForm = new DBForReciveForm();
		dbForReciveForm.init();
		ArrayList<ReciveFormDO> reciveFormDOs = dbForReciveForm.queryByID(
				order, "reciveform");
		TrackPO acceptTrackPO = new TrackPO();

		//System.out.println("order : "+order);

		if (!reciveFormDOs.isEmpty()) {
			ReciveFormDO receive = new ReciveFormDO();
			receive.setExe(1);
			ArrayList<ReciveFormDO> newList = new ArrayList<ReciveFormDO>();
			newList.add(receive);
			dbForReciveForm.insert(newList, "recivetable");

			acceptTrackPO.setID(receive.getId());
			acceptTrackPO.setTrack(receive.getHoll() + "/"
					+ receive.getRealtime() + "/" + receive.getRecip());
			
		}
		dbForReciveForm.close();
		return acceptTrackPO;
		/////
	}
}
