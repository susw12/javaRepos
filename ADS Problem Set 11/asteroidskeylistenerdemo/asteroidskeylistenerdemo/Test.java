package asteroidskeylistenerdemo;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test implements KeyListener {
	boolean isKey1 = false;
	boolean isAnotherKey = false;
	
	
	public Test() {
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_1:
	            // handle up
	        	isKey1 = true;	        	
	            break;
	        default:
	        	isAnotherKey = true;
	     }
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_1:
	            // handle up
	        	isKey1 = false;	        	
	            break;
	        default:
	        	isAnotherKey = false;
	     }
		
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void paint(Graphics brush) {
		if (isKey1) {
			brush.drawString("You are holding 1",100,100);
		}
		if (isAnotherKey) {
			brush.drawString("You are holding another key",100,200);
		}
	}
	
	
	
}
