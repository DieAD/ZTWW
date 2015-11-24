package nju.ztww.service_driver;

import nju.ztww.service_stub.OrderService_stub;
import nju.ztww.vo.OrderVO;

public class OrderService_driver {
     public static void main(String[] args){
    	 OrderService_stub orderService_stub = new OrderService_stub();
    	 orderService_stub.endSales(new OrderVO(0),1);
     }
}
