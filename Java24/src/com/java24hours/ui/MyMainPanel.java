package com.java24hours.ui;

import javax.swing.*;

@SuppressWarnings("serial")
class MyMainPanel extends JPanel {

	JTextField oKeyText = new JTextField(80);
	JButton oButton = new JButton("EMO");
	JCheckBox oCheckBox = new JCheckBox("My CheckBox", false);
	JComboBox<String> oComboBox = new JComboBox<String>();
	
	public MyMainPanel( MyMainWindow mainWindow ){
		super();
		setupComboBox();
		setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
		oKeyText.addKeyListener(new MyKeyListener(mainWindow));
		oButton.addActionListener(new MyActionListener(mainWindow, oKeyText));
		oCheckBox.addItemListener(new MyItemListener(mainWindow));
		oComboBox.addItemListener(new MyItemListener(mainWindow));
		add( oKeyText );
		add( oButton );
		add( oCheckBox );
		add( oComboBox );
		setVisible(true);
	}
	
	private void setupComboBox (){
		oComboBox.addItem("Option 1");
		oComboBox.addItem("Option 2");
	}
}
