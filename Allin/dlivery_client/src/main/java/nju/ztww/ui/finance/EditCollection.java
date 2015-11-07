package nju.ztww.ui.finance;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditCollection extends EditPanel{
	 private  Header header = new Header();
	 
     public EditCollection(String[] strings, Object[][] objects) {
		// TODO Auto-generated constructor stub
    	 super( strings, objects);
    	 this.scrollPane.setBounds(0, 25, 690, 395);
    	 this.header.setBounds(0, 0, 690, 25);
    	 this.add(header);
    	 this.remove(button1);
    	 this.remove(button2);
    	 this.remove(button3);
	}

//	public void setUp(){
//    	 this.setUp();
//    	 this.scrollPane.setBounds(0, 10, 690, 420);
//     }
     
    public class Header extends JPanel{
    	public JLabel label1  = new JLabel("日期：",JLabel.CENTER);
    	public JLabel label2 = new JLabel("营业厅编号：",JLabel.CENTER);
    	public JButton button1  = new JButton("查看");
    	public JTextField text1 = new JTextField();
    	public JTextField text2 = new JTextField();
    	public Header(){
    		this.setLayout(new GridLayout(1,5));
    		this.add(label1);
    		this.add(text1);
    		this.add(label2);
    		this.add(text2);
    		this.add(button1);
    	}
    }
}
