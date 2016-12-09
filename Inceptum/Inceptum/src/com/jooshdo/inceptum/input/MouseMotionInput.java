package com.jooshdo.inceptum.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jooshdo.inceptum.listener.MouseMotionListener;

public class MouseMotionInput extends MouseAdapter {

	public void mouseMoved( MouseEvent e ) {
		MouseMotionListener.mouseMoved(e);
	}
	
}
