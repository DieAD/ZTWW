package nju.ztww.RMI;

import java.awt.Dialog;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import nju.ztww.exception.ConectException;
import nju.ztww.service.UserDataService;
import nju.ztww.ui.main.remindDialog;

public class RMIHelper{
	/*
	 * 
	 * RMIHelper类
	 * 当要使用RMI连接时，实例化一个该类的对象，构造参数为两个String 值，一个ＩＰ，一个ＰＯＲＴ； 
	 * 
	 *然后调用findService(String serviceName)方法，参数为绑定的接口名称，返回的是一个Object对象，需要进行类型转换。 

	 */
    private String IP;
    private String port;
    private String serviceName;
    private Object	service;
    private remindDialog dia;
   
    private int i=0;
    public RMIHelper(String IP,String port){
    	this.IP = IP;
    	this.port = port;
    }
    
    public Object findService(String serviceName) {
    	this.serviceName=serviceName;
    	try{
    		Object	service =(Object) Naming.lookup("rmi://"+IP+":"+port+"/"+serviceName);
    		return service;
    	}catch (NotBoundException e){
    		System.out.println("NOT BOUND");
    		return null;
    	}catch (RemoteException e){
    		System.out.println("和服务器断开连接");
    		remindDialog r=new remindDialog(IP,port,serviceName);
    		while(r.ifLine){};
    		
    		return r.service;
    	}
    	
    	catch(Exception e){
    		System.out.println("RMI error!");
    		return null;
    	}
    	//return service;
    }

	
}
