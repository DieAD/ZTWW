package StorageTester;
import static org.junit.Assert.*;

import org.junit.Test;

import nju.ztww.Mock_Storage.MockOrderVO;
import nju.ztww.bl.commodity.StorageLineItem;
import nju.ztww.bl.commodity.StorageList;

public class TotalTest {
	@Test
  public void total(){
		MockOrderVO order1=new MockOrderVO("0000000001");
		MockOrderVO order2=new MockOrderVO("0000000002");
		StorageLineItem salesLineItem1=new StorageLineItem(order1);
		StorageLineItem salesLineItem2=new StorageLineItem(order2);
		StorageList storagelist=new StorageList();
		storagelist.addStorageLineItem(salesLineItem1);
		storagelist.addStorageLineItem(salesLineItem2);
		assertEquals(2,storagelist.gettotal());
	}
  
}
