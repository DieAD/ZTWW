package nju.ztww.service_stub;

import java.util.ArrayList;

import nju.ztww.common.ResultMessage;
import nju.ztww.service.OrderService;
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.ReceiveVO;
import nju.ztww.vo.StorageListVO;

public class OrderService_stub implements OrderService {
	int id;
	int idOfCenter;
	String location;
	String date;
	/*
	 *OrderService 的桩程序
	 * 
	 */
	public OrderService_stub(){
		
	}
	

	public OrderVO getOrder(int number) {
		// TODO Auto-generated method stub
		/*
		 * 默认返回 ReviceVO的一个实例，具体参数值未定
		 */
		return new ReceiveVO(id);
	}

	public StorageListVO getCommodity(int id) {
		// TODO Auto-generated method stub
		/*
		 * 默认返回一个StorageListVO的实例，具体参数值未定
		 */
		return null;
	}

	public ResultMessage addCommodity(int idOfCenter, String data,
			String location) {
		// TODO Auto-generated method stub
		/*
		 * 默认返回一个ResultMessage 的实例；
		 */
		return new ResultMessage();
	}

	public ArrayList getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	public String endSales(OrderVO order,int number) {
		// TODO Auto-generated method stub
		System.out.println("END Sale!");
		return null;
	}





	public double getMoney(String city, String city2, int type) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getDate(String city, String city2, int type) {
		// TODO Auto-generated method stub
		return null;
	}





	public String deleteOrder(String id, String type) {
		return type;
		
	}

	public double getCost(DeliverFeesVO deliverFees) {
		// TODO Auto-generated method stub
		return 0;
	}




	public String getOrderID() {

		// TODO Auto-generated method stub
		return null;
	}


//	public void endSales(OrderVO order, int number) {
//		// TODO Auto-generated method stub
//		
//	}

}
