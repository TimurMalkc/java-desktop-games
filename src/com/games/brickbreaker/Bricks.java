package com.games.brickbreaker;

import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Bricks extends Rectangle{

	private boolean isBroken = false;
	
	Bricks(int x, int y, int width, int height){
		super(x,y,width,height);
	}
	
	public void setBroken(boolean arg) {
		this.isBroken = arg;
	}
	
	public boolean getBroken() {
		return this.isBroken;
	}
	
}
