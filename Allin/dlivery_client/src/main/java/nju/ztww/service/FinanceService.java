package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.vo.AccountVO;
import nju.ztww.vo.CollectionVO;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.PCVO;
import nju.ztww.vo.PaymentVO;
import nju.ztww.vo.SalaryVO;

public interface FinanceService {
	/*
	 * 在用户正确输入银行账户格式后调用此函数
	 * 输入：String account : 账户号码
	 * 输出：AccountVO : 返回的银行账户信息VO，
	 */
	public AccountVO checkAccount(String account);
	
	/*
	 * 选定某用户后在数据库中更改工资信
	 * 输入：SalaryVO salary : 要被修改的员工对应的工资信息VO
	 * 输出：boolean : 返回是否设置成功，如果是返回true,如果否返回false
	 */
	public boolean setSalary(SalaryVO salary);
	
	/*
	 * 在受到鼠标键入审判单据时调出单据概述
	 * 输出： ArrayList<ListPO> : 返回的单据                    
	 */
	public ArrayList<OrderVO> viewList();
	
	public ArrayList<CollectionVO> queryCollection(String querydate,String queryholl);
	
	public boolean addPaymentForm(ArrayList<PaymentVO> list);
	
	public ArrayList<PCVO> queryPC(String startTime,String endTime,String holl);
	
}
