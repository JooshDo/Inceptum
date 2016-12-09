package com.jooshdo.inceptum.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jooshdo.inceptum.listener.MouseListener;

public class MouseInput extends MouseAdapter {

	public void mouseClicked( MouseEvent e ) {
		MouseListener.mouseClicked(e);
	}
	
}
