package OrderTester;

import static org.junit.Assert.*;
import nju.ztww.Mock_Order.MockOrderVO;
import nju.ztww.bl.order.OrderBL;

import org.junit.Test;

public class TestADD {
	@Test
	public void testADD() {
		OrderBL orderBL = new OrderBL();
		MockOrderVO mockOrderVO = new MockOrderVO();
		assertEquals(true, orderBL.addOrder(mockOrderVO.getOrderVO()));
	}
}
