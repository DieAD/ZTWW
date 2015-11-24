package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.order.TransferOrderBl;
import nju.ztww.common.ResultMessage;
import nju.ztww.service.TransferOrderService;
import nju.ztww.vo.StorageListVO;
import nju.ztww.vo.TransferVO;

public class TransferOrderServiceImpl implements TransferOrderService{

	TransferOrderBl transferOrderBl=new TransferOrderBl();
	
	public TransferVO getOrder() {
		// TODO Auto-generated method stub
		TransferVO transferVO=new TransferVO(8);
		return transferVO;
	}

	public String endSales(TransferVO transferorder) {
		// TODO Auto-generated method stub
		String result=null;
		result=transferOrderBl.handleVO(transferorder);
		return result;
	}

	public ArrayList<StorageListVO> getCommodity() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage removeCommodity(int idOfCenter) {
		// TODO Auto-generated method stub
		return null;
	}

}
