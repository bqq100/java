package com.java24hours.ui;

import java.awt.event.*;

class MyItemListener implements ItemListener {

	private MyMainWindow oSourceWindow;
	
	public MyItemListener( MyMainWindow sourceWindow ){
		oSourceWindow = sourceWindow;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if ( e.getStateChange() == ItemEvent.SELECTED )
		{
			oSourceWindow.setDisplayText( "Selected " + e.getItem().toString() );
		}
		else
		{
			oSourceWindow.setDisplayText( "Unselected " + e.getItem().toString() );
		}
		
	}

}
