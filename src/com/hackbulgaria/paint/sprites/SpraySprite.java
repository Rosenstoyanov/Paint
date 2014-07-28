package com.hackbulgaria.paint.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class SpraySprite extends Sprite{
	public static final int DOT_SIZE = 1;

	public SpraySprite(int x, int y, int size, Color color) {
		super(x, y, size, color);
	}

	@Override
	public void draw(Graphics graphics) {
		Random rn = new Random();
		
		for(int i = size*-1; i <= size; i++){
			for(int j = size*-1; j <= size; j++){
				int distance_from_center = i*i + j*j;
				if(distance_from_center == 0)
					graphics.fillOval(x, y, DOT_SIZE, DOT_SIZE);
				else{
				if(distance_from_center<= size*size)
				{
					int random = rn.nextInt(10*distance_from_center);
					if(random*distance_from_center < 5*distance_from_center)
						graphics.fillOval(x+i, y+j, DOT_SIZE, DOT_SIZE);
					
				}
				}	
				
			}
		}

		
	}

}

