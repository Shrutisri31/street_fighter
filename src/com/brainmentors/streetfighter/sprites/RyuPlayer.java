package com.brainmentors.streetfighter.sprites;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.brainmentors.streetfighter.utils.GameConstants;

public class RyuPlayer implements GameConstants{
  
	private int x;
	private int y;
	private int w;
	private int h;
	private int force;
	private int state;
	private int speed;
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

	private boolean isJumping;
	private BufferedImage playerImage ;
	private BufferedImage[] loadImages = new BufferedImage[6];	
	private BufferedImage[] punchImages = new BufferedImage[6];
	private BufferedImage[] kickImages = new BufferedImage[6];
	public RyuPlayer() {
		loadImage();
		x = 100;
		h = 200;
		w = 200;
		y = FLOOR - h;
		loadDefaultMove();
		loadPunch();
		loadkick();
	}
	public void setState(int state) {
		this.state = state;
	}
	public void jump() {
		if(!isJumping) {
		force = -15;
		y = y + force;
		isJumping = true;
	   }
	}
	
	public void fall() {
		if(y<=(FLOOR-h)) {
		force = force + GRAVITY;
		y = y + force;
		}
		if(y>=(FLOOR-h)) {
			isJumping = false;
		}
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void move() {
		x = x + speed;
	}
	
	public void loadDefaultMove() {
		loadImages[0]=playerImage.getSubimage(62,234,70,102);
		loadImages[1]=playerImage.getSubimage(141, 230, 74, 105);
		loadImages[2]=playerImage.getSubimage(224, 231, 67, 103);
		loadImages[3]=playerImage.getSubimage(302, 231, 62, 104);
		loadImages[4]=playerImage.getSubimage(374, 232, 66, 100);
		loadImages[5]=playerImage.getSubimage(454, 234, 67, 104);
		
	}
	public void loadPunch() {
		punchImages[0]= playerImage.getSubimage(27, 821, 66, 98);
		punchImages[1]= playerImage.getSubimage(107, 821, 70, 97);
		punchImages[2]= playerImage.getSubimage(193, 823, 107, 96);
		punchImages[3]= playerImage.getSubimage(309, 822, 80, 95);
		punchImages[4]= playerImage.getSubimage(402, 819, 104,96);
		punchImages[5]= playerImage.getSubimage(516, 818, 81, 100);
		
	}
	public void loadkick() {
		kickImages[0] = playerImage.getSubimage(114, 1044, 72, 96);
		kickImages[1] = playerImage.getSubimage(200, 1049, 121, 95);
		kickImages[2] = playerImage.getSubimage(331, 1048, 66, 96);
		kickImages[3] = playerImage.getSubimage(410, 1048, 65, 93);
		kickImages[4] = playerImage.getSubimage(484, 1050, 94, 93);
		kickImages[5] = playerImage.getSubimage(7, 1157, 105, 99);
	}
	private int imageIndex;
	public void setImageIndex(int imageIndex) {
		this.imageIndex = imageIndex;
	}
	private BufferedImage printDefaultMove(BufferedImage images[]) {
		
		if(imageIndex>5) {
			imageIndex = 0;
			
			state = DEFAULT;
		}
		BufferedImage currentImage = images[imageIndex]; 
		imageIndex ++;
		
		return currentImage;
	}

	
	private BufferedImage images(int imageIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	public void paintPlayer(Graphics brush) {
//		brush.drawImage(standing(),x,y,w,h, null);
		if(state == PUNCH) {
			brush.drawImage(printDefaultMove(punchImages), x, y, w, h, null);
		}
		else if(state == KICK) {
			brush.drawImage(printDefaultMove(kickImages), x, y, w, h, null);
		}
		else {
			brush.drawImage(printDefaultMove(loadImages), x, y, w, h, null);
		}
	}
	private BufferedImage standing() {
		return playerImage.getSubimage(452, 233, 67, 112);  
	}
	private void loadImage() {
		try {
			playerImage = ImageIO.read(RyuPlayer
					.class.
					getResource(RYU_PLAYER_IMAGE));
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
}
