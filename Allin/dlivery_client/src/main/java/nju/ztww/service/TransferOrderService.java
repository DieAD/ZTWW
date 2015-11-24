package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.common.ResultMessage;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListVO;
import nju.ztww.vo.TransferVO;

/**
 * 录入中转单Service
 * @author TQ
 * 
 * */

public interface TransferOrderService {
	
	 /**
     * 获取一个新的vo（在ui层已选择单据类型后）
     * 
     * @return 返回一个对应的vo
     * 
     * */
	public TransferVO getOrder();
	
	
	/**
	 * 结束输入
	 * 
	 * @param order TransferVO要保存的vo
	 * @return
	 * 
	 * */
	public String endSales(TransferVO transferorder);
	
	 /**
     * 获得全部库存信息
     * 
     * @return 返回库存信息列表
     * 
     * */
	public ArrayList<StorageListVO> getCommodity();
	
	/**
	 * 删除一条库存信息
	 * 
	 * @param idOfCenter 货物ID
	 * @return ResultMessage
	 * 
	 * */
	public ResultMessage removeCommodity(int idOfCenter );

}
