package com.hackbulgaria.paint.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.hackbulgaria.paint.sprites.DotSprite;
import com.hackbulgaria.paint.tools.Tool;
import com.hackbulgaria.paint.view.PaintWindow;

public class PaintController {
	private final PaintWindow window;
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
		@Override
		public void mousePressed(MouseEvent e) {
			// System.out.println("Click!");
			DotSprite dotSprite = new DotSprite(e.getX(), e.getY(), Color.white);
			window.addSprite(dotSprite);
			window.repaint();
			super.mousePressed(e);
		}


	}
}
