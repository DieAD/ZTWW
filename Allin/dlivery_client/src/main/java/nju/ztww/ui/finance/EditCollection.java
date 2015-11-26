package nju.ztww.ui.finance;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    	private Listener listener = new Listener();
    	public Header(){
    		this.setLayout(new GridLayout(1,5));
    		this.add(label1);
    		this.add(text1);
    		this.add(label2);
    		this.add(text2);
    		this.add(button1);
    		button1.addActionListener(listener);
    	}
    	
    	  public class Listener implements ActionListener{

    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				String querydate = text1.getText();
    				String queryholl = text2.getText();
    				tableModel.addRow(new Object[]{new String("2015/11"),new Integer(100),new String("000002"),new String("00000001")});
    				
    			}
    	    	
    	    }

    }
    
    
  
	
}
