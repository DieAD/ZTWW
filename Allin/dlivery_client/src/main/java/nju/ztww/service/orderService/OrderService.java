package nju.ztww.service.orderService;
import java.util.ArrayList;

import nju.ztww.common.ResultMessage;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListVO;

/**
 * Order模块Service
 * @author TQ
 * 
 * */
public interface OrderService {

    /**
     * 获取一个新的vo（在ui层已选择单据类型后）
     * 
     * @param number 单据对应的号码（一个单据对应一个号码，通过号码返回单据）
     * @return 返回一个对应的vo
     * 
     * */
	public OrderVO getOrder(int number);
	
	
	/**
	 * 结束输入
	 * 
	 * @param order OrderVO要保存的vo
	 * @return
	 * 
	 * */
	public void endSales(OrderVO order);
	
	
}
