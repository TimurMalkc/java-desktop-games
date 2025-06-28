package com.games.snakegame;

import javax.swing.JFrame;

public class Frame extends JFrame{

	AnimationPanel panel = new AnimationPanel();
	
	Frame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setTitle("Snake Game");
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
	}

}
