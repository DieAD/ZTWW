package nju.ztww.service_driver;

import nju.ztww.service_stub.FinanceService_stub;
import nju.ztww.vo.SalaryVO;

/*
 * 
 * 驱动FinanceService的部分方法；
 */
public class FinanceService_driver {
    public static void main(String[] args){
    	FinanceService_stub financeService_stub = new FinanceService_stub();
    	financeService_stub.checkAccount("iii");
    	financeService_stub.setSalary(new SalaryVO(null, null, null, 0));
    	financeService_stub.viewList();
    }
}
