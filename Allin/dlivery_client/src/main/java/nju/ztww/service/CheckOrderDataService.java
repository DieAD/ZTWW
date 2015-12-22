package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.po.TracePO;

public interface CheckOrderDataService {
  public ArrayList<TracePO>findTrace(String id);

public void modifyBaoJing(String idofcenter, String number);

public void modifyDao(String idofcenter, String number);
}
