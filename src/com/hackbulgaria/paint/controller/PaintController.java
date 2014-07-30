package com.hackbulgaria.paint.controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;

import com.hackbulgaria.paint.sprites.DotSprite;
import com.hackbulgaria.paint.sprites.LineSprite;
import com.hackbulgaria.paint.sprites.SpraySprite;
import com.hackbulgaria.paint.tools.Tool;
import com.hackbulgaria.paint.view.PaintWindow;

public class PaintController {
	private final PaintWindow window;
	private Tool currentTool;

	public PaintController() {
		MouseListener mouse = new MouseListener();
		this.window = new PaintWindow();
		window.addMouseListener(mouse);
		window.addMouseMotionListener(mouse);
		window.setTitle("Paint!");
		currentTool = Tool.DOT;
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setVisible(true);
	}

	private void changeTool() {
		if (this.currentTool == Tool.DOT) {
			this.currentTool = Tool.SPRAY;
		} else {
			this.currentTool = Tool.SPRAY;
		}
	}
	public class MouseListener extends MouseInputAdapter{
		private Point start;
		private int state;

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == 2) {
				changeTool();
			}
			if (e.getButton() == 3) {
				// BlankSprite blank = new BlankSprite();
				// window.addSprite(blank);
				window.clearWindow();
			}
			else{
				if (state == e.MOUSE_CLICKED) {
					if (currentTool == Tool.DOT) {
						System.out.println("asdasd");
						DotSprite dot = new DotSprite(start.x, start.y,
								Color.green);
						window.addSprite(dot);
					} else {
						SpraySprite spray = new SpraySprite(start.x, start.y,
								20, Color.BLUE);
						window.addSprite(spray);
					}

				} else if (state == e.MOUSE_DRAGGED){
					if (currentTool == Tool.DOT) {
						LineSprite line = new LineSprite(start.x, start.y,
								e.getX(), e.getY(), Color.green);
						window.addSprite(line);
					}
				}}
			
			window.repaint();
			super.mouseReleased(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			state = e.MOUSE_CLICKED;
			start = e.getPoint();
			super.mousePressed(e);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			state = e.MOUSE_DRAGGED;
			super.mouseDragged(e);
		}
		


	}
}
