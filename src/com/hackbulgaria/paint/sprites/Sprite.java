package com.hackbulgaria.paint.sprites;

import java.awt.Color;

public abstract class Sprite {
	int x;
	int y;  //position
	int size;  // in pixels
	Color color;
	
	public Sprite(){
		this.color = Color.red;
	}

}
