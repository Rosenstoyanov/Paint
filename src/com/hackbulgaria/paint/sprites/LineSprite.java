package com.hackbulgaria.paint.sprites;

import java.awt.Color;
import java.awt.Graphics;

public class LineSprite extends Sprite {
	private final int xEnd;
	private final int yEnd;

	public LineSprite(int xStart, int yStart, int xEnd, int yEnd, Color color) {
		super(xStart, yStart, 5, color);
		this.xEnd = xEnd;
		this.yEnd = yEnd;
	}

	@Override
	public void draw(Graphics graphics) {
		if (color != null) {
			graphics.setColor(color); // set Color to use for FUTURE draw and
										// fill calls
		}
		graphics.drawLine(x, y, xEnd, yEnd);

	}

}
