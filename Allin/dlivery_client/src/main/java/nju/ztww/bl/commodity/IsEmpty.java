package nju.ztww.bl.commodity;

import java.util.ArrayList;

public class IsEmpty {
	boolean isempty=false;
     public boolean isempty(ArrayList<String> arraylist){
    	 for(int i=0;i<arraylist.size();i++){
    		 if(arraylist.get(i).equals("")){
    		 isempty=true;
    		 break;
    		 }
    		 
    }
    	 return isempty;
    	 
     }
}
