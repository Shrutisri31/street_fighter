package com.brainmentors.streetfighter.sprites;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.brainmentors.streetfighter.utils.GameConstants;

public class KenPlayer implements GameConstants{
	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage playerImage ;
	private int state;
	
	public KenPlayer()  {
		x = GWIDTH - 500;
		w = 250;
		h=250;
		y = FLOOR - h;
		
		
		loadImage();
		
	}

	
	public void paintPlayer(Graphics brush) {
		brush.drawImage(standing(),x,y,w,h, null);
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	private BufferedImage standing() {
		return playerImage.getSubimage(10987, 1142, 74, 103);  
	}

	private void loadImage() {
		try {
			playerImage = ImageIO.read(KenPlayer
					.class.
					getResource(KEN_PLAYER_IMAGE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Player Image Not Found...");
			System.exit(0);
		}
	}
		public void setstate(int state) {
			// TODO Auto-generated method stub
			this.state = state;
		}
		public void setImageIndex(int i) {
			// TODO Auto-generated method stub
			
		}
}
