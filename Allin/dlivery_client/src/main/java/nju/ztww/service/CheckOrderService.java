package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.po.TracePO;

public interface CheckOrderService {
  public ArrayList<TracePO> findTrace(String id);
}
