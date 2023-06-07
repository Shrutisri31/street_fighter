package com.brainmentors.streetfighter.views;

import javax.swing.JFrame;

import com.brainmentors.streetfighter.utils.GameConstants;

public class GameFrame extends JFrame implements GameConstants{
	public GameFrame() {
		Board board = new Board();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(GWIDTH,GHEIGHT); //size of frame
		setLocationRelativeTo(null); //center of screen 
		setResizable(false);
		setTitle(Title);
		setVisible(true);
		add(board); //ADD Board in Frame 
		
//		Board board = new Board();
//		setTitle(TITLE);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(GWIDTH, GHEIGHT);
//		
//		setResizable(false);
//		add(board); // Add Board in a Frame
//		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		GameFrame obj = new GameFrame();
		
		
	}
}
