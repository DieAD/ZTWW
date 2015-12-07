package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.po.ManaUserPO;
import nju.ztww.po.MemberPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.UserPO;


public interface UserDataService extends Remote{
	/*
	 * 用户输入账号密码验证身份
	 * 输入：MemberPO member: 用户的信息的PO
	 * 输出：MemberPO : 该账号对应的用户信息，若不匹配则返回Null
	 */
	public MemberPO checkMember(String id, String password) ;
	
	/*
	 * 用户输出正确的订单号格式后调用该函数调出订单信息
	 * 输入：String order : 订单号
	 * 输出：OrderPO : 订单信息PO
	 */
	public OrderPO checkOrder(String id) ;
	
	/*
	 * 用于查询个人信息
	 */
	public UserPO findUser(String ID);
	
	//管理员添加用户
	public boolean addUser(ManaUserPO user);
	
	public ArrayList<ManaUserPO> findAll();
	
	public ManaUserPO findByID(String ID);
	
	public String update(ManaUserPO user);
}
