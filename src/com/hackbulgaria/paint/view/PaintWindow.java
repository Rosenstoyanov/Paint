package com.hackbulgaria.paint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.hackbulgaria.paint.sprites.Sprite;

public class PaintWindow extends JFrame {
	private final List<Sprite> sprites = new ArrayList<>();	
	
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK); //set color
        g.fillRect(0, 0, getWidth(), getHeight()); //fill the whole window with black

        for (Sprite sprite : sprites) {
            sprite.draw(g);
        }
    }

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
	}

	public void addSprite(Sprite sprite) {
		sprites.add(sprite);
	}
	
	public void removeSprite(Sprite sprite){
		if(!sprites.contains(sprite)){
			System.out.println("Object does not exist");
		}
		sprites.remove(sprite);
	}
}
