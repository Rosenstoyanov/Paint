package com.hackbulgaria.paint.controller;

import javax.swing.JFrame;

import com.hackbulgaria.paint.view.PaintWindow;

public class PaintController {
	private final PaintWindow window;
	private final Tool currentTool;

	public PaintController() {
		this.window = new PaintWindow();
		window.setTitle("Paint!");
		currentTool = Tool.DOT;
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setVisible(true);
		window.setSize(800, 600);
	}
}
