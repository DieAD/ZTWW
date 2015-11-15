package nju.ztww.Mock_Order;

import nju.ztww.vo.OrderVO;

public class MockOrderVO {
    OrderVO orderVO;
    
    public MockOrderVO(){
    	orderVO = new OrderVO(1);
    }
    
    public OrderVO getOrderVO(){
    	return orderVO;
    }
}
