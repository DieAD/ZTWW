package nju.ztww.RMI;

import java.io.FileReader;
import java.io.Reader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import nju.ztww.ui.main.remindDialog;

public class RMIHelper {
	/*
	 * 
	 * RMIHelper类
	 * 当要使用RMI连接时，实例化一个该类的对象，构造参数为两个String 值，一个ＩＰ，一个ＰＯＲＴ； 
	 * 
	 *然后调用findService(String serviceName)方法，参数为绑定的接口名称，返回的是一个Object对象，需要进行类型转换。 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
    private static String IP;
    private static String port;
    private String serviceName;
    static{
    	Properties prop = new Properties();
		Reader in;
		try {
			in = new FileReader("src\\main\\java\\config.properties");
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IP = prop.getProperty("ip");
		port = prop.getProperty("port");
    }
    
    public RMIHelper(String IP,String port){
    	
//    	this.IP = IP;
//    	this.port = port;
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
    		
    		
    		return null;
    	}
    	
    	catch(Exception e){
    		System.out.println("RMI error!");
    		return null;
    	}
    	//return service;
    }
}
