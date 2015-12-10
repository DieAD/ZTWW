package confligUI;

import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.plaf.metal.MetalComboBoxUI;


public class MyComboBox extends JComboBox {
	Font myFont = new Font("微软雅黑", Font.PLAIN, 15);
	public MyComboBox(){
		super();
		this.setFont(myFont);
	}
	
	public MyComboBox(ComboBoxModel aModel) {
        super(aModel);
        this.setFont(myFont);
    }
 
    public MyComboBox(final Object items[]) {
        super(items);
        this.setFont(myFont);
    }
 
    public MyComboBox(Vector<?> items) {
        super(items);
        this.setFont(myFont);
    }
 
	@Override
    public void updateUI() {
        setUI(new MyComboBoxUI());
    }
	
	
	 class MyComboBoxUI extends MetalComboBoxUI {
		 
		 @Override
//	        public void configureArrowButton() {
//	            super.configureArrowButton();
//	            if (arrowButton != null) {
//	                arrowButton.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//	               
//	                arrowButton.setIcon(new ImageIcon("photo/comboBox.png"));
//	            }
//	        }
		 
	        protected JButton createArrowButton() {
	        	JButton button = new JButton();
	        	button.setOpaque(false);
	        	button.setContentAreaFilled(false);
	        	button.setBorder(null);
	        	button.setIcon(new ImageIcon("photo/comboBox.png"));
//	            button.setName("ComboBox.arrowButton");
	            return button;
	        } 
	    }
}
