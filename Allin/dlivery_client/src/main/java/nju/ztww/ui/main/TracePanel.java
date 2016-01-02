package nju.ztww.ui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.bl.commodity.CheckOrderBL;
import nju.ztww.po.TracePO;
import confligUI.MyLabel;
import confligUI.MyTextField;
/**
 * 
 * @author Administrator
 * to do : 根据 ID 花去trace 的 String 数组
 *
 */
public class TracePanel extends JPanel {
	JFrame frame = new JFrame();
	String id;
    partTracePanel part1 = new partTracePanel(1,"2015/11/25 12:00 ：  营业厅已揽件     上海");
    partTracePanel part2 = new partTracePanel(0,"2015/11/29 01:00 ：    中转中心已接收  南京");
    String[] trace = {"2015/11/25 12:00 ：  营业厅已揽件     上海","2015/11/29 01:00 ： 中转中心已接收  南京",
    		"2015/11/29 01:00 ： 快件已入库等待出库  南京","2015/11/29 01:00 ：  快件已出库  南京","2015/11/29 01:00 ：  中转中心已接收  南京",
    		"2015/11/29 01:00 ：  营业厅已接收  南京","2015/11/29 01:00 ：    阿呆派送中  南京"} ;
   // Image title;
    Image background;
    ArrayList<partTracePanel> tracelist = new ArrayList<partTracePanel>();
    Thread thread ;
    JButton button = new JButton("");
    CheckOrderBL checkOrder = new CheckOrderBL();
    MyLabel title = new MyLabel("物流轨迹");	
    public void getTrace(){
    	ArrayList<TracePO> traceList = checkOrder.findTrace(id);
    	int size = traceList.size();
//    	trace = new String[size];
//    	for(int i=0;i<size;i++){
//    		trace[i] = traceList.get(i).getTrace();
//    	}
    }
    public TracePanel(String id){
    	this.id = id;
    	getTrace();
    	this.setLayout(null);
    	//
    	Font myFont = new Font("微软雅黑", Font.PLAIN, 24);
    	
    	title.setBounds(80, 50, 100, 30);
    	title.setFont(myFont);
    	title.setForeground(new Color(255,255,255));
    	this.add(title);
    	title.setOpaque(false);
    	button.setBounds(700,500,103,30);
    	button.setLayout(null);
    	button.setIcon(new ImageIcon("photo2/back(2).png"));
    	button.setOpaque(false);
    	this.add(button);
    	button.addActionListener(new Listener_Return());
    	//
    	getImage();
    	getPart();
    	//setFrame();
    	thread = new Thread(){
     	   public void run(){
     	     animate();
     	   }
     	};
     	
     	thread.start();
     	
    }
    public void animate(){
    	for(partTracePanel panel : tracelist){
    		this.add(panel);
    		this.repaint();
    		try   
    		{   
    		Thread.currentThread().sleep(300);//毫秒   
    		}   
    		catch(Exception e){}
    	}
    }
    
	public void setFrame() {
		//getPart();
		//
//		frame.setSize(900, 600);
//		frame.setTitle("Bussiness");
//		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//		frame.setLocation((width - 900) / 2, (height - 600) / 2);
//		frame.setResizable(false);
//		// add panel;
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(null);
//		this.setBounds(0,0,900,600);
//		//frame.add(this);
//		frame.setVisible(true);
	}
	public void getPart(){
		this.setLayout(null);
		for(int i=0;i<trace.length;i++){
			if((i==0&&trace.length>1)){
			tracelist.add(new partTracePanel(1,trace[i]));}
			else if(i!=trace.length-1){
			tracelist.add(new partTracePanel(0,trace[i]));	
			}else if(trace.length>1&&i==trace.length-1){
				tracelist.add(new partTracePanel(2,trace[i]));	
			}
		}
		int count = 0;
		for(partTracePanel panel : tracelist){
			panel.setBounds(100, 100+50*count, 700, 50);
			count++;		//	this.add(panel);
		}
	}
	
	public void getImage(){
		 try {
		//	title =ImageIO.read(new FileInputStream("Trace/title2.png"));
			background = ImageIO.read(new FileInputStream("photo2/bg.png"));
			//button = ImageIO.read(new FileInputStream("photo2/bg.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(background, 0, 0, 900, 600, null);
	   // g.drawImage(title, -30, 20, 700, 70, null);
	}
	
//	public static void main(String[] args){
//		new TracePanel().animate();;
//	}
	
	/**
	 * 内部类 
	 * 每有一条trace 就加载一个 panel
	 * 
	 */
	public class partTracePanel extends JPanel{
		Image state;
		MyTextField Date = new MyTextField();
		int index;
		String info;
		public partTracePanel(int index,String info){
			this.index = index;		
			this.info = info;
			preState();
			init();
			this.setOpaque(false);
		}
		public void init(){
			Font myFont = new Font("微软雅黑", Font.PLAIN, 18);
			this.setLayout(null);
			Date.setEditable(false);
			Date.setText(info);
			Date.setBounds(100, 3, 800, 30);
			Date.setFont(myFont);
			Date.setOpaque(false);
			Date.setForeground(new Color(255,255,255));
			Date.setBorder(null);
			this.add(Date);
		}
		public void preState(){
			try {
				if(index ==1){
				state = ImageIO.read(new FileInputStream("photo2/top(2).png"));}
				else if(index==0){
				state = ImageIO.read(new FileInputStream("photo2/middle.png"));	
				}else if(index==2){
				state = ImageIO.read(new FileInputStream("photo2/bottom.png"));	
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
//			g.drawImage(background, 0, 0, 900, 600, null);
			g.drawImage(state, 60,0, null);
		}
	}
}
