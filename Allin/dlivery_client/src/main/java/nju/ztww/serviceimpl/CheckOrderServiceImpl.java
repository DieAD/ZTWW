package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.commodity.CheckOrderBL;
import nju.ztww.po.TracePO;
import nju.ztww.service.CheckOrderService;

public class CheckOrderServiceImpl implements CheckOrderService {

	public ArrayList<TracePO> findTrace(String id) {
		ArrayList<TracePO> tracelist=new ArrayList<TracePO>();
		CheckOrderBL checkorderbl=new CheckOrderBL();
		tracelist=checkorderbl.findTrace(id);
		System.out.println(tracelist.get(0).getTrace());
		// TODO Auto-generated method stub
		return tracelist;
	}
   public static void main(String[]args){
	   CheckOrderServiceImpl o=new CheckOrderServiceImpl();
	   ArrayList<TracePO> tracelist=new ArrayList<TracePO>();
	   tracelist=o.findTrace("000000002");
   }
}
