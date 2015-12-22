package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.po.TracePO;

public interface CheckOrderDataService extends Remote{
  public ArrayList<TracePO>findTrace(String id)throws RemoteException;
  public void modifyBaoJing(String idofcenter, String number)throws RemoteException;
  public void modifyDao(String idofcenter, String number)throws RemoteException;
  }

