package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;



public class Player extends Entity{
		
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_up2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_up3.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_down2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_down3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_right2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_right3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_left2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player_Arthur/arthur_left3.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
public void update() {
		
	if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
		if(keyH.upPressed == true) {
			direction = "up";
			y -= speed;
		}else if(keyH.downPressed == true) {
			direction = "down";
			y += speed;
		}else if(keyH.leftPressed == true) {
			direction = "left";
			x -= speed;
		}else if(keyH.rightPressed == true) {
			direction = "right";
			x += speed;
		}
		
		spriteCounter++;
		if(spriteCounter > 20) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 3;
			}else {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	
}

public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		
//		g2.fillRect(x, y, gp.scaledTiles, gp.scaledTiles);
	
		BufferedImage image = null;
		
		switch(direction) {
			case "up":
				//changes pngs when sprite num reaches a certain number
				if(spriteNum == 1) {
					image = up1;
				}
				if(spriteNum == 2) {
					image = up2;
				}
				if(spriteNum == 3) {
					image = up3;
				}
				break;
				
			case "down":
				if(spriteNum == 1) {
					image = down1;
				}
				if(spriteNum == 2) {
					image = down2;
				}
				if(spriteNum == 3) {
					image = down3;
				}
				break;
				
			case "left":
				if(spriteNum == 1) {
					image = left1;
				}
				if(spriteNum == 2) {
					image = left2;
				}
				if(spriteNum == 3) {
					image = left3;
				}
				break;
				
			case "right":
				if(spriteNum == 1) {
					image = right1;
				}
				if(spriteNum == 2) {
					image = right2;
				}
				if(spriteNum == 3) {
					image = right3;
				}
				break;	
		}
		g2.drawImage(image, x, y, gp.scaledTiles, gp.scaledTiles, null);
	}
}

