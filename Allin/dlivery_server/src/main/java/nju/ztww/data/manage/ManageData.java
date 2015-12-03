package nju.ztww.data.manage;

import java.util.ArrayList;

import nju.ztww.DBHelper.DBForCenterreciForm;
import nju.ztww.DBHelper.DBForDeliveryForm;
import nju.ztww.DBHelper.DBForEntryForm;
import nju.ztww.DBHelper.DBForHollReciForm;
import nju.ztww.DBHelper.DBForLoadForm;
import nju.ztww.DBHelper.DBForOrderForm;
import nju.ztww.DBHelper.DBForOutStockForm;
import nju.ztww.DBHelper.DBForPayeeForm;
import nju.ztww.DBHelper.DBForPaymentForm;
import nju.ztww.DBHelper.DBForTrainForm;
import nju.ztww.dao.CenterreciFormDO;
import nju.ztww.dao.DeliveryFormDO;
import nju.ztww.dao.EntryFormDO;
import nju.ztww.dao.HollReciFormDO;
import nju.ztww.dao.LoadFormDO;
import nju.ztww.dao.OrderFormDO;
import nju.ztww.dao.OutStockFormDO;
import nju.ztww.dao.PayeeFormDO;
import nju.ztww.dao.PaymentFormDO;
import nju.ztww.dao.TrainFormDO;
import nju.ztww.po.GeneratePO;

public class ManageData {
	DBForOrderForm dbOrder = new DBForOrderForm();
	DBForLoadForm  dbLoad = new DBForLoadForm();
	DBForHollReciForm dbHoll = new DBForHollReciForm();
	DBForPayeeForm dbPayee = new DBForPayeeForm();
	DBForDeliveryForm dbDelivery = new DBForDeliveryForm();
	DBForCenterreciForm dbCenter = new DBForCenterreciForm();
	DBForEntryForm dbEntry = new DBForEntryForm();
	DBForTrainForm dbTrain = new DBForTrainForm();
	DBForOutStockForm dbOut = new DBForOutStockForm();
	DBForPaymentForm dbPayment = new DBForPaymentForm();
	
	public ArrayList<GeneratePO> getCheckOrder(int index){
		ArrayList<GeneratePO> listPO = new ArrayList<GeneratePO>();
		if(index==1){
			dbOrder.init();
			ArrayList<OrderFormDO> listDO ;
			listDO = dbOrder.selectAll();
			for(OrderFormDO form : listDO){
				GeneratePO po = new GeneratePO();
				po.setId(form.getOrdernumber());
				//po.setState(form.getExe());
				po.setDealmen(form.getRecip());
				listPO.add(po);
			}
			dbOrder.close();		
		}
		if(index==2){
			dbLoad.init();
			ArrayList<LoadFormDO> listDO;
			listDO = dbLoad.selectAll();
			for(LoadFormDO form : listDO){
				GeneratePO po  = new GeneratePO();
				po.setId(form.getId());
				po.setDealmen(form.getLoadmen());
				listPO.add(po);
			}
			dbLoad.close();
		}
		if(index==3){
			dbHoll.init();
			ArrayList<HollReciFormDO> listDO;
			listDO = dbHoll.selectAll();
			for(HollReciFormDO form : listDO){
				GeneratePO po = new GeneratePO();
				po.setId(form.getId());
				po.setDealmen(form.getGoodsid());
				listPO.add(po);
			}
			dbHoll.close();
		}
		if(index==4){
			dbPayee.init();
			ArrayList<PayeeFormDO> listDO;
			listDO = dbPayee.selectAll();
			for(PayeeFormDO form : listDO){
				GeneratePO po = new GeneratePO();
				po.setId(form.getId());
				po.setDealmen(form.getCourierid());
				listPO.add(po);
			}
			dbPayee.close();
		}
		if(index==5){
			dbDelivery.init();
			ArrayList<DeliveryFormDO> listDO;
			listDO = dbDelivery.selectAll();
			for(DeliveryFormDO form : listDO){
				GeneratePO po = new GeneratePO();
				po.setId(form.getId());
				po.setDealmen(form.getCourierid());
				listPO.add(po);
			}
			dbDelivery.close();
		}
		if(index==6){
			dbCenter.init();
			ArrayList<CenterreciFormDO> listDO;
			listDO = dbCenter.selectAll();
			for(CenterreciFormDO form : listDO){
				GeneratePO po = new GeneratePO();
				po.setId(form.getId());
				po.setDealmen(form.getCenterid());
				listPO.add(po);
			}
			dbCenter.close();
		}
		if(index==7){
			dbEntry.init();
			ArrayList<EntryFormDO> listDO;
			listDO = dbEntry.selectAll();
			for(EntryFormDO form : listDO){
				GeneratePO po = new GeneratePO();
				po.setId(form.getId());
				po.setDealmen(form.getGoodsid());
				listPO.add(po);
			}
			dbEntry.close();
		}
		if(index ==8){
			dbTrain.init();
			ArrayList<TrainFormDO> listDO;
			listDO = dbTrain.selectAll();
			for(TrainFormDO form : listDO){
				GeneratePO po = new GeneratePO();
				po.setId(form.getId());
				po.setDealmen(form.getGoodsid());
			}
			dbTrain.close();
			
		}
		if(index==9){
			dbOut.init();
			ArrayList<OutStockFormDO> listDO;
			listDO = dbOut.selectAll();
			for(OutStockFormDO form : listDO){
				GeneratePO po = new GeneratePO();
				po.setId(form.getId());
				po.setDealmen(form.getGoodsid());
				listPO.add(po);
			}
			dbOut.close();
		}
		if(index==10){
			dbPayment.init();
			ArrayList<PaymentFormDO> listDO;
			listDO = dbPayment.selectAll();
			for(PaymentFormDO form : listDO){
				GeneratePO po = new GeneratePO();
				po.setId(form.getId());
				po.setDealmen(form.getPaymen());
				listPO.add(po);
			}
			dbPayment.close();
		}
		return listPO;
		
	}
}
