package com.hit.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CacheUnitView extends java.util.Observable implements IView {
	
	private CacheUnitLayout panel;
	
	public CacheUnitView() {
		super();
		panel = new CacheUnitLayout(this);
	}
	
	public void start() {
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				createAndShow();
			}
		});
	}
	
	public void createAndShow()
	{
		JFrame frame = new JFrame("CacheUnitUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
	    frame.setVisible(true);
	    frame.setResizable(false);
	}
	
	public <T> void updateUIData(T t) {
		
		if(t.equals("getStatistics") || t.equals(panel.getFilePath()))
		{
			setChanged();
			notifyObservers(t);
		}
		else
		{
			String[] newT = ((String) t).split(";");
			for(int i=0; i< newT.length; i++)
				panel.setInput(newT[i]);
		}
	}
}




//package com.hit.view;
//
//public class CacheUnitView extends java.util.Observable implements IView {
//	public void start()
//	{
//		
//	}
//	
//	public <T> void	 updateUIData(T t)
//	{
//		
//	}
//}
