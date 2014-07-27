package com.hackbulgaria.paint.controller;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.hackbulgaria.paint.sprites.BlankSprite;
import com.hackbulgaria.paint.sprites.DotSprite;
import com.hackbulgaria.paint.sprites.LineSprite;
import com.hackbulgaria.paint.tools.Tool;
import com.hackbulgaria.paint.view.PaintWindow;

public class PaintController {
	private  PaintWindow window;
	private final Tool currentTool;

	public PaintController() {
		MouseListener m = new MouseListener();
		this.window = new PaintWindow();
		window.addMouseListener(m);
		window.setTitle("Paint!");
		currentTool = Tool.DOT;
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setVisible(true);
		// window.paint(g);
		//window.setSize(800, 600);
	}
	
	public class MouseListener extends MouseAdapter{
		private int xStart;
		private int yStart;
		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getButton() != 3){
			System.out.println(String.format("%s %s %s %s", xStart, yStart, e.getX(), e.getY()));
			if((e.getX() == xStart) && (e.getY() == yStart)){
				DotSprite dot = new DotSprite(xStart, yStart, Color.green);
				window.addSprite(dot);
			}
			else{
				LineSprite line = new LineSprite(xStart, yStart, e.getX(), e.getY(), Color.green);
				window.addSprite(line);
			}
			}
			else{
				BlankSprite blank = new BlankSprite();
				window.addSprite(blank);
			}
			window.repaint();
			super.mouseReleased(e);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {

			xStart = e.getX();
			yStart = e.getY();
			super.mousePressed(e);
		}


	}
}
