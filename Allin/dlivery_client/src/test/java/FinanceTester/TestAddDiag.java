package FinanceTester;

import nju.ztww.bl.finance.FinanceBL;

import org.junit.Test;

public class TestAddDiag {
	@Test
	public void testAddDiag(){
		FinanceBL finance = new FinanceBL();
		finance.addDiag();
		equals(true);
	}
}
