package nju.ztww.Mock_Finance;

import nju.ztww.bl.finance.*;
import nju.ztww.vo.AccountVO;
import nju.ztww.vo.SalaryVO;

public class MockFinance extends Ex{
	public AccountVO MockCheckAccount(String id){
		AccountVO account = new AccountVO("1234566789", 123456, "Tom");
		return account;
	}
	
	public boolean MockSetSalary(SalaryVO salary){
		return true;
	}
	
	public boolean MockaddDiagram(String diagID){
		return true;
	}
	
	public boolean MockdeleteDiagram(String diagID){
		return true;
	}
	
	public double MockgetFund(){
		return 33.2;
	}
	
	public double MockgetExpend(){
		return 11.1;
	}
	
	public double MockgetIncome(){
		return 102.3;
	}
	
	public boolean MockAddAccount(AccountVO account){
		return true;
	}
	
	public boolean MockDeleteAccount(String id){
		return true;
	}
	
	public boolean MockModifyAccount(AccountVO account){
		return true;
	}
}
