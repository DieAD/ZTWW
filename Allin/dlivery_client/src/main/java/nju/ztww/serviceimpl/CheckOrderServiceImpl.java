package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.commodity.CheckOrderBL;
import nju.ztww.service.CheckOrderService;

public class CheckOrderServiceImpl implements CheckOrderService {

	public ArrayList<String> findTrace(String id) {
		ArrayList<String> tracelist=new ArrayList<String>();
		CheckOrderBL checkorderbl=new CheckOrderBL();
		tracelist=checkorderbl.findTrace(id);
		// TODO Auto-generated method stub
		return tracelist;
	}

}
