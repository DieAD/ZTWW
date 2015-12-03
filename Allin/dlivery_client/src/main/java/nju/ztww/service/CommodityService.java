package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.StorageListLineofOutPO;
import nju.ztww.vo.OrderVO;

import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;
import nju.ztww.vo.StorageListVO;

public interface CommodityService {
	//根据中转中心编号，得到中转中心库存列表
   
    
    //根据订单号显示订单信息
    public OrderVO getOrder(String idOfOrder);
       
    //计算分区的库存数量
    //id ： 库存分区的代号
    public int getTotal(int id);
     //根据订单号在库存中添加订单
    public void addOrder(OrderVO order);
    // 根据订单号在库存中删除此订单
    public void deleteOrder(String idofOrder,String idofcenter);
    //快件编号和中转中心编号
    
    //判断库存是否已经超出报警界线
    //number是自己设定的一个标准，实现时与每个分区的数量相比较 
    //return 比较的结果
    public boolean isOutofIndex(int number);
    //增加出库的信息
	public void addoutOrder(ArrayList<StorageListLineofOutVO> arraylist,String idofcenter);
	//增加入库的信息
	public void addinOrder(ArrayList<StorageListLineofInVO> arraylist,String idofcenter);
	public String getLastidofcenter(String idofcenter);
}
