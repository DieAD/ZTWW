package nju.ztww.ui.main;

import nju.ztww.RMI.RMIHelper;

public class TestIfConnect {
	
	private static String IP = "127.0.0.1";
	 private static RMIHelper rhelper = new RMIHelper(IP,"1010");
	
	public  static boolean ifConnect(){
		Object ifTrue=rhelper.findService("OrderDataService");
		if(ifTrue==null){
			return false;
		}
		return true;
	}

}
