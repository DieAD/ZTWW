package nju.ztww.thread;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteHandlerThread  implements Runnable{  
    private Socket client;  
    public static boolean ifSend=true;
    public static String message="";
    Thread t=new Thread(this);
    public WriteHandlerThread (Socket client) {  
        this.client = client;  
        t.start();
    }

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			try {
				while(ifSend){};
				PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(client.getOutputStream())),true);
				out.println(message); 
				ifSend=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
			
			}
	}
	
}