package nju.ztww.service_stub;

import java.util.ArrayList;

import nju.ztww.service.CommodityService;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListVO;

public class Commodity_stub implements CommodityService{
        String idofCenter;//中转中心的编号
        int  idoforder;//订单的编号
        int id;//具体分区的编号
        int number;//具体的库存数量标准
        public Commodity_stub(String idofCenter,int idoforder,int id,int number) {
        	this.idofCenter=idofCenter;
        	this.idoforder=idoforder;
        	this.id=id;
        	this.number=number;
			// TODO Auto-generated constructor stub
		}
        //输入中转中心的编号得到此中转中心的库存信息
	public StorageListVO getList(String idOfCenter) {
		ArrayList<OrderVO>arraylist=new ArrayList<OrderVO>();
		// TODO Auto-generated method stub
		return new StorageListVO(idOfCenter, arraylist);
	}

	public OrderVO getOrder(String idOfOrder) {
		// TODO Auto-generated method stub
		return new OrderVO(idoforder);
	}

	public int getTotal(int id) {
		// TODO Auto-generated method stub
		return 1;
	}

	public void addOrder(String idofOrder) {
		System.out.println("增加了");
		// TODO Auto-generated method stub
		
	}

	public void deleteOrder(String idofOrder) {
		// TODO Auto-generated method stub
	   System.out.println("减少了");
		
	}

	public boolean isOutofIndex(int number) {
		// TODO Auto-generated method stub
		return false;
	}

}
