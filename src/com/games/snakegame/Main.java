package com.games.snakegame;

import java.util.ArrayList;

public class Main {

	private static ArrayList<Frame> frameList = new ArrayList<Frame>();
	
	public static void main(String[] args) {
		
		Frame newFrame = new Frame();
		frameList.add(newFrame);
	}
	
	public static ArrayList<Frame> getFrameList() {
		return frameList;
	}
		
}
