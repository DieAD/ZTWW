package nju.ztww.service_driver;

import nju.ztww.service_stub.ManageService_stub;
/*
 * 驱动ManageService的部分方法
 */

public class ManageService_driver {
   public  static void main(String[] args){
	   ManageService_stub manageService_stub = new ManageService_stub();
	   manageService_stub.addSupervisee("001");
	   manageService_stub.deleteSupervisee("001");
	   manageService_stub.modifySupervisee("001");
   }
}
