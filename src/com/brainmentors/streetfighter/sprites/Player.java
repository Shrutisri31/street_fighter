package com.brainmentors.streetfighter.sprites;
 
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Player {
	BufferedImage playerImage ;
	public Player() {
try {
			
			playerImage= ImageIO
					.read(Player.class.getResource
							("player-sprite.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drawPlayer(Graphics brush) {
		brush.drawImage(playerImage, 0, 0 ,100,100, null);
	}

}
