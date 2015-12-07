package nju.ztww.ui.commodity;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public class MovingMessagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private String message = " ";
	private int xCoordinate = 0;
	private int yCoordinate = 20;
	
	public MovingMessagePanel(String message)
	{   
		this.message = message;
		Timer timer = new Timer(100, new TimerListener());
		timer.start();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (xCoordinate > getWidth())
		{
			xCoordinate = -100;
		}

		xCoordinate += 1;
		g.drawString(message, xCoordinate, yCoordinate);
	}

	class TimerListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			repaint();
		}
	}

}

