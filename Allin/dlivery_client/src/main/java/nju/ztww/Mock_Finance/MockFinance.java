package nju.ztww.Mock_Finance;

import nju.ztww.bl.finance.*;
import nju.ztww.vo.AccountVO;
import nju.ztww.vo.SalaryVO;

public class MockFinance extends Ex{
	AccountVO account;
	double fund;
	double expend;
	double income;
	
	
	public  MockFinance(double fund, double expend, double income, AccountVO account ){
		this.account = account;
		this.fund = fund;
		this.expend = expend;
		this.income = income;
	}
	
	
	public double getFund(){
		return fund;
	}
	
	public double getExpend(){
		return expend;
	}
	
	public double getIncome(){
		return income;
	}
	
	public AccountVO getAccount(){
		return account;
	}
}
