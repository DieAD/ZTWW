package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CheckOrderDataService extends Remote{
  public ArrayList<String>findTrace(String id)throws RemoteException;
}
