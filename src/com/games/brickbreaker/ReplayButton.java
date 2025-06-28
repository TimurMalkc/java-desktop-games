package com.games.brickbreaker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ReplayButton extends JButton implements ActionListener{
	
	ArrayList<Frame> frameList = Main.getFrameList();
	
	ReplayButton(){
	
		this.setPreferredSize(new Dimension(300,150));
		this.setText("Replay");
		this.setBackground(Color.white);
		this.setFocusable(false);
		this.addActionListener(this);
		this.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frameList.get(0).dispose();
		Frame newFrame = new Frame();
		frameList.clear();
		frameList.add(newFrame);
	}
	
	
}
