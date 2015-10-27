package nju.ztww.service;

import nju.ztww.po.SuperviseePO;

/*
 * Date:
 * Author:
 */
public interface ManageDataService {
//TODO// 插入一个被管理者的信息
	public void insert(SuperviseePO po);
	//删除一个被管理者的信息
	public void delete(SuperviseePO po);
	//找到一个被管理者信息
	public SuperviseePO find(String id);
	//更新一个被管理者的具体信息
	public void update(SuperviseePO po);
}
