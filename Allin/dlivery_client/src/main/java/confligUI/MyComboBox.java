package confligUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalComboBoxUI;

public class MyComboBox<E> extends JComboBox {
	Font myFont = new Font("微软雅黑", Font.PLAIN, 15);
	Border border = new LineBorder(new Color(44,76,120));
	private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();

	public MyComboBox() {
		super();
		init();
		this.setFont(myFont);
		this.setBorder(border);
		this.setBackground(new Color(225,225,225));
	}

	public MyComboBox(ComboBoxModel aModel) {
		super(aModel);
		init();
		this.setFont(myFont);
		this.setBorder(border);
		this.setBackground(new Color(225,225,225));
	}

	public MyComboBox(final Object items[]) {
		super(items);
		init();
		this.setFont(myFont);
		this.setBorder(border);
		this.setBackground(new Color(225,225,225));
	}

	public MyComboBox(Vector<?> items) {
		super(items);
		init();
		this.setFont(myFont);
		this.setBorder(border);
		this.setBackground(new Color(225,225,225));
	}

	@Override
	public void updateUI() {
		setUI(new MyComboBoxUI());
	}

	private void init() {
		setOpaque(false);
		setUI(new MyComboBoxUI());
		setRenderer(new MyComboBoxRenderer());
		setBackground(Color.BLACK);
	}

	
	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}

	class MyComboBoxUI extends MetalComboBoxUI {

		@Override
		public void configureArrowButton() {
			super.configureArrowButton();
			if (arrowButton != null) {
				arrowButton.setBorder(BorderFactory.createEmptyBorder(3, 3, 3,
						3));

				arrowButton.setIcon(new ImageIcon("photo/comboBox.png"));
			}
		}

		// protected JButton createArrowButton() {
		// JButton button = new JButton();
		// button.setOpaque(false);
		// button.setContentAreaFilled(false);
		// button.setBorder(null);
		// button.setIcon(new ImageIcon("photo/comboBox.png"));
		// // button.setName("ComboBox.arrowButton");
		// return button;
		// }
		 public void paint(Graphics g, JComponent c) {
			  hasFocus = comboBox.hasFocus();
			  Graphics2D g2 = (Graphics2D)g;
			  if (!comboBox.isEditable()) {
			   Rectangle r = rectangleForCurrentValue();
			   //重点:JComboBox的textfield 的绘制 并不是靠Renderer来控制 这点让我很吃惊.
			   //它会通过paintCurrentValueBackground来绘制背景
			   //然后通过paintCurrentValue();去绘制JComboBox里显示的值
			   paintCurrentValueBackground(g2, r, hasFocus);
			   paintCurrentValue(g2, r, hasFocus);
	}
		 }
}
	class MyComboBoxRenderer implements ListCellRenderer {

		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			// TODO Auto-generated method stub
			JLabel renderer = (JLabel) defaultCellRenderer
					.getListCellRendererComponent(list, value, index,
							isSelected, cellHasFocus);
			if (isSelected) {
				renderer.setBackground(new Color(44,76,120));//选择时鼠标滑动颜色
				renderer.setForeground(Color.WHITE);
			} else {
				renderer.setBackground(Color.WHITE);
			}
			list.setSelectionBackground(new Color(225,225,225));//选中后一栏颜色
			list.setBorder(null);
			// renderer.setFont(XUtil.defaultComboBoxFont);
//			renderer.setHorizontalAlignment(JLabel.CENTER);
			return renderer;
		}
	}
	}

	


