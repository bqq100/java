package com.java24hours.ui;

import java.awt.event.*;

class MyKeyListener implements KeyListener {
	
	private MyMainWindow oSourceWindow;
		
	public MyKeyListener( MyMainWindow sourceWindow ){
		oSourceWindow = sourceWindow;
	}
	
	@Override
	public void keyPressed(KeyEvent input) {
		char key = input.getKeyChar();
		oSourceWindow.setDisplayText("Pressed " + key);		
	}

	@Override
	public void keyReleased(KeyEvent input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent input) {
		
	}
	
}
