package com.java24hours.ui;

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
class MyMainWindow extends JFrame {
	
	MyMainPanel oMainPanel = new MyMainPanel(this);
	JLabel oMessageBox = new JLabel("Test");
	
	public MyMainWindow(){
		super("Main Window");
		setLookAndFeel();
		setSize(350, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(oMessageBox, BorderLayout.NORTH);
		add(oMainPanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void setDisplayText(String displayText){
		oMessageBox.setText(displayText);
	}
	
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel(
				"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
			);
		} catch ( Exception exception ){
			// No error handling
		}
	}
	

	
}
