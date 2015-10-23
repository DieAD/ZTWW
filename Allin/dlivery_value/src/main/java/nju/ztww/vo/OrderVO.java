package nju.ztww.vo;

import nju.ztww.common.Customer;
import nju.ztww.common.OrderInfo;





public class OrderVO {
	public final String idOfOrder;
	public final Customer customer;
	public final OrderInfo info;
	
	public OrderVO(String idOfOrder,Customer customer,OrderInfo info){
		this.idOfOrder = idOfOrder;
		this.customer=  customer;
		this.info = info;
	}
	

}
