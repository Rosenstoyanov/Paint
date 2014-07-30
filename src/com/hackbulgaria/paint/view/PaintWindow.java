package com.hackbulgaria.paint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.hackbulgaria.paint.sprites.Sprite;

public class PaintWindow extends JFrame {
	private final List<Sprite> sprites = new ArrayList<>();	
	private final List<Sprite> undoSprites = new ArrayList<>();
	
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK); //set color
        g.fillRect(0, 0, getWidth(), getHeight()); //fill the whole window with black

        for (Sprite sprite : sprites) {
            sprite.draw(g);
        }
    }

	public void undo() {
		undoSprites.add(sprites.get(sprites.size() - 1));
		sprites.remove(sprites.size() - 1);
	}

	public void redo() {
		sprites.add(undoSprites.get(undoSprites.size() - 1));
		undoSprites.remove(undoSprites.size() - 1);
	}
	public void clearWindow() {
		sprites.clear();
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
