package com.hackbulgaria.paint.sprites;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Sprite {
	int x;
	int y;  //position
	int size;  // in pixels
	Color color;
	
	public Sprite(){
	}

	public Sprite(int x, int y, int size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}

	public abstract void draw(Graphics graphics);

}