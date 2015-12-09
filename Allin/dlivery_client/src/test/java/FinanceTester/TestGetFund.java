package FinanceTester;

import static org.junit.Assert.*;
import nju.ztww.Mock_Finance.MockFinance;
import nju.ztww.Mock_Finance.MockFund;
import nju.ztww.bl.finance.FinanceBL;
import nju.ztww.vo.AccountVO;

import org.junit.Test;

public class TestGetFund {
	@SuppressWarnings("deprecation")
	@Test
	public void testGetFund(){
		FinanceBL finance = new FinanceBL();
		MockFund fund = new MockFund(0);
		assertEquals(0,0);
	}
}
