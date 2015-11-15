package nju.ztww.Mock_Storage;

import java.util.ArrayList;

import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListVO;

public class MockStorageListVO extends StorageListVO {
	static String idOfCenter;
	static ArrayList<OrderVO>arraylist;
  public MockStorageListVO() {
	// TODO Auto-generated constructor stub
	  super(idOfCenter, arraylist);
}
  
}
