package com.brainmentors.streetfighter.views;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.brainmentors.streetfighter.sprites.KenPlayer;
import com.brainmentors.streetfighter.sprites.RyuPlayer;
import com.brainmentors.streetfighter.utils.GameConstants;
//painting
public class Board extends JPanel implements GameConstants{
	BufferedImage backgroundImage;
	RyuPlayer ryu;
	KenPlayer ken;
	public Board() {
		loadBackground();
		ryu = new RyuPlayer();
		ken = new KenPlayer();
		boolean isCollideFlag;
		setFocusable(true);
		bindEvents();
		gameLoop();
	}
	
	private boolean isCollide() {
		int xDistance = Math.abs(ryu.getX() - ken.getX());
		int yDistance = Math.abs(ryu.getX()- ken.getY());
		int maxH = Math.max(ryu.getH(), ken.getH());
		int maxW = Math.max(ryu.getW(), ken.getW());
		return xDistance<=(maxW-40) && yDistance<=maxH;
	}
	
	private void loadBackground() {
		try {
			// throw new IOException(); //Implicit throw
		backgroundImage = ImageIO.read(Board.class.getResource(BACKGROUND_IMAGE_NAME));
	    
		}
		catch(IOException e) {
			System.out.println("OOPS Something Went Wrong..");
			System.exit(0);
			
		}
	}

	private void bindEvents() {
		this.addKeyListener(new KeyAdapter() {
		
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_P) {
				ryu.setstate(PUNCH);
				ryu.setImageIndex(0);
			}
			else if(e.getKeyCode()==KeyEvent.VK_K) {
//				System.out.print("KICK State not reach");
				ryu.setstate(KICK);
			}
		}
		@Override
		public void keyPressed(KeyEvent e) {
			//TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				ryu.jump();
			}
			else {
				if(e.getKeyCode()== KeyEvent.VK_X) {
					
				}
			}
		   }
		
		});
		}
	public void Collision() {
		if(isCollide()) {
			ryu.setSpeed(0);
		}
	}
	Timer timer;
	private void gameLoop() {
		//start a new Thread 
		 timer = new Timer(90,(x)->{
			 ryu.move();
			 repaint();
		 });
		 timer.start();
	}
    //Need a Thread 
	// Thread - Code in Execution is called Thread
	// e.g main Thread (Stack)
	// Per Thread Per Stack 

	
   @Override
   public void paintComponent(Graphics brush) {
	   super.paintComponent(brush); //for clean board
	   brush.drawImage(backgroundImage,0,0,GWIDTH,GHEIGHT,null);
	   ryu.paintPlayer(brush);
//	   ken.paintPlayer(brush);
   }
}
