package com.hit.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CacheUnitLayout extends JPanel implements ActionListener {
	
	private CacheUnitView gui;
	private JButton		StatisticsBtn;
	private JButton		LoadRequestBtn;
	private String		filePath;
	private boolean		newReq = false;
	private boolean		newStat = false;
	private JTextArea	input;
	private JButton		aboutBtn;
	
	public CacheUnitLayout(CacheUnitView gui)
	{
		this.gui = gui;
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		LoadRequestBtn = new JButton("Load a Request");
		StatisticsBtn = new JButton("Statistics");
		LoadRequestBtn.addActionListener(this);
		StatisticsBtn.addActionListener(this);
		input = new JTextArea(30,30);
		input.setBorder(border);
		input.setVisible(true);
		
		aboutBtn = new JButton("About");
		aboutBtn.addActionListener(this);
		
		add(LoadRequestBtn,BorderLayout.PAGE_START);
		add(StatisticsBtn,BorderLayout.PAGE_START);
		add(aboutBtn,BorderLayout.PAGE_START);
		add(input,BorderLayout.PAGE_END);
		
	}
	
	//@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == aboutBtn)
		 {
		   JOptionPane.showMessageDialog(null, "This project was made by Yoav Keren and Michael Waserman", "About this project", JOptionPane.INFORMATION_MESSAGE);
		 } else {
			input.setText("");
			if(e.getSource() == LoadRequestBtn)
			{
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File("src/main/resources"));
				FileNameExtensionFilter f = new FileNameExtensionFilter("TEXT FILES", "txt","text"); // here you choose which files to show
				fc.setFileFilter(f);
				int i = fc.showOpenDialog(this);
				if(i == JFileChooser.APPROVE_OPTION)
				{
					File file = fc.getSelectedFile();
					filePath = file.getPath();
					gui.updateUIData(filePath);
				}
			}
			if(e.getSource() == StatisticsBtn)
				gui.updateUIData("getStatistics");
		 }

	}
	
	public CacheUnitView getGui() { return(gui); }
	public void setGui(CacheUnitView gui) { this.gui = gui; }
	public JButton getStatisticsBtn() { return(StatisticsBtn); }
	public void setStatisticsBtn(JButton statisticsBtn) { StatisticsBtn = statisticsBtn; }
	public JButton getLoadRequestBtn() { return(LoadRequestBtn); }
	public void setLoadRequestBtn(JButton loadRequestBtn) { LoadRequestBtn = loadRequestBtn; }
	public String getFilePath() {return(filePath); }
	public void setFilePath(String filePath) {this.filePath = filePath; }
	public JTextArea getInput() { return(input); }
	public void setInput(String input) {
		this.input.append(input);
		this.input.append("\n");
		this.input.updateUI();
	}

	public boolean isNewReq() {
		return newReq;
	}

	public void setNewReq(boolean newReq) {
		this.newReq = newReq;
	}

	public boolean isNewStat() {
		return newStat;
	}

	public void setNewStat(boolean newStat) {
		this.newStat = newStat;
	}
	
	
	
	
}
