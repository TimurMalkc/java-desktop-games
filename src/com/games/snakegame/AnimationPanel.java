package com.games.snakegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener,KeyListener{

	Timer timer = new Timer(40,this);
	int direction = 2;
	List<Integer> xSnake = new ArrayList<Integer>();
	List<Integer> ySnake = new ArrayList<Integer>();
	ReplayButton rButton = new ReplayButton();
	Random rand = new Random();
	Rectangle foodRect;
	boolean isFull = false;
	boolean isInvincible = false;
	int panelWidth = 500;
	int panelHeight = 500;
	int cellNum = 1;
	int xHead = 0;
	int yHead = 0;
	int xFood;
	int yFood;
	int foodHeight = 20;
	int foodWidth = 20;
	int snakeHeight = 20;
	int snakeWidth = 20;
	int velocity = 20;
	
	AnimationPanel(){
		
		this.setPreferredSize(new Dimension(panelWidth,panelHeight));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(this);
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setLayout(new GridBagLayout());
		this.add(rButton);
		xSnake.add(xHead);
		ySnake.add(yHead);
		spawnFood();
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setPaint(Color.green);
		
		for(int i = 0; i < xSnake.size(); i++) {
			g2D.fillRect(xSnake.get(i), ySnake.get(i), snakeWidth, snakeHeight);

		}
		
		
		g2D.setPaint(Color.white);
		
		g2D.fillRect(xFood, yFood, foodWidth, foodHeight);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		
		for(int i = xSnake.size() - 1; i > 0; i-- ) {
			xSnake.set(i, xSnake.get(i-1));
			ySnake.set(i, ySnake.get(i-1));
		}
		
		switch(direction) {
			case 2:
				xSnake.set(0, xSnake.get(0) + velocity);
				break;
			case -2:
				xSnake.set(0, xSnake.get(0) - velocity);
				break;
			case 1:
				ySnake.set(0, ySnake.get(0) - velocity);
				break;
			case -1:
				ySnake.set(0, ySnake.get(0) + velocity);
				break;
			}
		
		for(int i = 0; i < xSnake.size(); i++) {
			if((xFood <= xSnake.get(i) && xSnake.get(i) <= xFood + 20) && 
			   (yFood <= ySnake.get(i) && ySnake.get(i) <= yFood + 20)	) {
				ySnake.add(yFood);
				xSnake.add(xFood);
				spawnFood();
				
			}
		}
		
		for(int i = 1; i < xSnake.size(); i++ ) {
			if(xSnake.get(i) == xSnake.get(0) && ySnake.get(i) == ySnake.get(0)) {
				timer.stop();
				rButton.setText("Game Over");
				rButton.setVisible(true);
				repaint();
			}
			
		if(xSnake.get(0) > panelWidth-snakeWidth || xSnake.get(0) < 0 ||
				ySnake.get(0) > panelHeight-snakeHeight || ySnake.get(0) < 0) {
				timer.stop();
				rButton.setText("Game Over");
				rButton.setVisible(true);
				repaint();
			}
			
		}
		
		repaint();		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 2) {
					direction = -2;
				}	
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != -2) {
					direction = 2;
				}	
				break;
			case KeyEvent.VK_UP:
				if(direction != -1) {
					direction = 1;
				}	
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 1) {
					direction = -1;
				}	
				break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void spawnFood() {
		xFood = rand.nextInt(panelWidth/foodWidth) * foodWidth;
		yFood = rand.nextInt(panelHeight/foodHeight) * foodHeight;
		foodRect = new Rectangle(xFood, yFood, foodWidth, foodHeight);
	}
	
}
