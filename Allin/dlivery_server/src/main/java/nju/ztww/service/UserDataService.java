package nju.ztww.service;

import nju.ztww.po.MemberPO;
import nju.ztww.po.OrderPO;

/* Date:
 * Author:
 * 
 * 
 * 
 */

public interface UserDataService {
//TODO
	/*
	 * 用户输入账号密码验证身份
	 * 输入：String id : 用户的ID
	 * 输入：String password : 对应的密码
	 * 输出：MemberPO : 该账号对应的用户信息，若不匹配则返回Null
	 */
	public MemberPO checkMember(String id, String password);
	
	/*
	 * 用户输出正确的订单号格式后调用该函数调出订单信息
	 * 输入：String order : 订单号
	 * 输出：OrderPO : 订单信息PO
	 */
	public OrderPO checkOrder(String id);
	
	
	
}