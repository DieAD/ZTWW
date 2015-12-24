package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.dao.AccountDO;
import nju.ztww.dao.InsDO;
import nju.ztww.dao.StockDO;
import nju.ztww.dao.UserDO;
import nju.ztww.dao.matrixDO;
import nju.ztww.po.AccountPO;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.CollectionPO;
import nju.ztww.po.MemberPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.PaymentPO;

/*
 * Date:
 * Author:
 */
public interface FinanceDataService extends Remote {
//TODO
	/*
	 * 当更改某用户的工资时调用此函数，在数据库中更改工资信息
	 * 输入：MemberPO member : 输入当前要被修改工资的用户PO
	 * 输入：double salary : 被修改后的工资的数额
	 * 输入：String pattern : 修改后的工资设定方式
	 */
		public boolean update(MemberPO member, double salary, String pattern) throws RemoteException;
		
		/*
		 * 当需调出某账户信息时调用此函数，返回该银行账户信息
		 * 输入：String accountID : 需要被调出的账户的账户ID
		 * 输出：AccountPO : 需要被调出的账户的账户信息PO
		 */
		public AccountPO checkAccount(String accountID) throws RemoteException;
		
		/*
		 * 当对某一单据进行状态更改的时候调用此函数，在数据库中更改该单据当前状态
		 * 输入：OrderPO order : 需要被修改状态的单据的信息PO
		 * 输出：boolean : 返回该状态是否被更改，若是则返回true, 若否则返回false
		 */
		public boolean checkList(OrderPO order) throws RemoteException;
		
		/*
		 * 当要在数据库中添加某一表格时，调用此函数
		 * 输入：String diagram : 被添加的表格的位置
		 * 输出：boolean : 返回该表格是否添加成功
		 */
		public boolean add(String diagram)throws RemoteException;
		
		/*
		 * 当要在数据库中删除某一表格时，调用此函数
		 * 输入：String diagram : 被删除的表格的位置
		 * 输出：boolean : 返回该表格是否删除成功
		 */
		public boolean delete(String diagram)throws RemoteException;
		
		/*
		 * 当需要得到从月初到当前的总收入时调用此函数，返回当前总收入
		 * 输入：ArrayList<double> everyList : 从月初到当前的每条订单的收入的顺序表
		 * 输出：double : 总收入
		 */
		public double calcuIncome(ArrayList everyList)throws RemoteException;
		/*
		 * 	按照日期和营业厅查找收款单
		 */
		public ArrayList<CollectionPO> queryCollection(String querydate,String queryholl)throws RemoteException;
		
		public boolean addPaymentForm(ArrayList<PaymentPO> list)throws RemoteException;
		
		public ArrayList<CollectionPO> queryPCC(String beginTime, String endTime, String holl)throws RemoteException;
		public ArrayList<PaymentPO> queryPCP(String beginTime, String endTime, String holl)throws RemoteException;
		public ArrayList<CollectionPO> totalCollection()throws RemoteException;
		public ArrayList<PaymentPO>  totalPayment()throws RemoteException;
		public void init(ArrayList<InsDO> list)throws RemoteException;
		public void initCar(ArrayList<CarManagePO> listPO)throws RemoteException;
		public void initStock(ArrayList<StockDO> list)throws RemoteException;
		public void initAccount(AccountDO account)throws RemoteException;
		public ArrayList<AccountDO> selectAllAccount()throws RemoteException;
		public void updateAccount(AccountDO account)throws RemoteException;
		public void initUser(ArrayList<UserDO> list)throws RemoteException;
		public ArrayList<PaymentPO> getAllPaymentDO()throws RemoteException;
		public String getInsName(String id)throws RemoteException;
		public void insertM(matrixDO form)throws RemoteException;
		public ArrayList<matrixDO> queryM()throws RemoteException;
	/*
	 * 在数据库中更改信息？？
	 */
}
