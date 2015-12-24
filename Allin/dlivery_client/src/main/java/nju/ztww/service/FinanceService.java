package nju.ztww.service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.dao.AccountDO;
import nju.ztww.dao.InsDO;
import nju.ztww.dao.StockDO;
import nju.ztww.dao.UserDO;
import nju.ztww.dao.matrixDO;
import nju.ztww.po.CarManagePO;
import nju.ztww.vo.AccountVO;
import nju.ztww.vo.BenefitVO;
import nju.ztww.vo.CollectionVO;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.PaymentVO;
import nju.ztww.vo.SalaryVO;

public interface FinanceService {
	/*
	 * 在用户正确输入银行账户格式后调用此函数 输入：String account : 账户号码 输出：AccountVO : 返回的银行账户信息VO，
	 */
	public AccountVO checkAccount(String account);

	/*
	 * 选定某用户后在数据库中更改工资信 输入：SalaryVO salary : 要被修改的员工对应的工资信息VO 输出：boolean :
	 * 返回是否设置成功，如果是返回true,如果否返回false
	 */
	public boolean setSalary(SalaryVO salary);

	/*
	 * 在受到鼠标键入审判单据时调出单据概述 输出： ArrayList<ListPO> : 返回的单据
	 */
	public ArrayList<OrderVO> viewList();

	public ArrayList<CollectionVO> queryCollection(String querydate,
			String queryholl);

	public boolean addPaymentForm(ArrayList<PaymentVO> list);

	public ArrayList<PaymentVO> queryPCP(String startTime, String endTime,
			String holl);

	public ArrayList<CollectionVO> queryPCC(String startTime, String endTime,
			String holl);

	public BenefitVO getBenefit();

	public void init(ArrayList<InsDO> list);

	public void initCar(ArrayList<CarManagePO> list);

	public void initStock(ArrayList<StockDO> list);

	public void initAccount(AccountDO account);
	
	public ArrayList<AccountDO> getAllAccount();
	
	public void updateAccount(AccountDO account);
	
	public void initUser(ArrayList<UserDO> list);
	
	public void exportExcel(int index);
	
	public void insertM(matrixDO form);
	public ArrayList<matrixDO> queryM();
	
}
