package com.java24hours.ui;

import java.awt.event.*;
import javax.swing.JTextField;

class MyActionListener implements ActionListener {

	private MyMainWindow oSourceWindow;
	private JTextField oTextFieldToRead;
	
	public MyActionListener ( MyMainWindow sourceWindow, JTextField textField ){
		oSourceWindow = sourceWindow;
		oTextFieldToRead = textField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		oSourceWindow.setDisplayText( "Pushed " + e.getActionCommand() + " and read " + oTextFieldToRead.getText() );
	}

}
