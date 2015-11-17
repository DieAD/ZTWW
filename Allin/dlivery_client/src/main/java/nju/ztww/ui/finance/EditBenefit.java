package nju.ztww.ui.finance;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditBenefit extends EditPanel {
    private Header  header = new Header();
	public EditBenefit(String[] strings, Object[][] objects ){
		super(strings,objects);
		this.scrollPane.setBounds(0,25,690,395);
		this.header.setBounds(0, 0, 690, 25);
		this.add(header);
		this.remove(button1);
		this.remove(button3);
		button2.setText("更新");
		}
	
	class Header extends JPanel{
		JLabel label1 = new JLabel();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String info = "截止"+df.format(new Date())+"成本收益表为：";
	    public Header(){
	    	this.add(label1);
	    	label1.setText(info);
	    }
		
	}
}
