package com.games.tictactoe;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main implements ActionListener{

	static Main instance = new Main();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static String turn = "X";
	static boolean gameOver = false;
	static boolean isDraw = false;
	static JLabel label = new JLabel("It's "+turn+"'s turn to play");
	static URL urlX = Main.class.getResource("/resources/x.png");
	static URL urlO = Main.class.getResource("/resources/o.png");
	static URL urlRestart = Main.class.getResource("/resources/restart.png");
	static URL urlIcon = Main.class.getResource("/resources/icon.jpg");
	static ImageIcon iconX = new ImageIcon(urlX);
	static ImageIcon iconO = new ImageIcon(urlO);
	static ImageIcon iconRestart = new ImageIcon(urlRestart);
	static ImageIcon iconIcon = new ImageIcon(urlIcon);
	
	static JButton button1 = new JButton();
	static JButton button2 = new JButton();   
	static JButton button3 = new JButton();
	static JButton button4 = new JButton();
	static JButton button5 = new JButton();
	static JButton button6 = new JButton();
	static JButton button7 = new JButton();
	static JButton button8 = new JButton();
	static JButton button9 = new JButton();
	static JButton buttonRestart = new JButton();
	
	public static void main(String[] args) {
		
		firstFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {  
			selectTile(button1);
		}else if(e.getSource() == button2) {
			selectTile(button2);
		}else if(e.getSource() == button3) {
			selectTile(button3);
		}else if(e.getSource() == button4) {
			selectTile(button4);
		}else if(e.getSource() == button5) {
			selectTile(button5);
		}else if(e.getSource() == button6) {
			selectTile(button6);
		}else if(e.getSource() == button7) {
			selectTile(button7);
		}else if(e.getSource() == button8) {
			selectTile(button8);
		}else if(e.getSource() == button9) {
			selectTile(button9);
		}else if(e.getSource() == buttonRestart) {
			refreshGame();
		}
		
	}
	
	public static void selectTile(JButton argButton) {
		argButton.setIcon(turn == "X" ? iconX : iconO);
		checkTiles();
		if(gameOver) {
			if(isDraw) {
				label.setText("It's A Draw!");
			}else {
				label.setText(turn == "X" ? "X Wins" : "O Wins!");
			}
			
			button1.removeActionListener(instance);
			button2.removeActionListener(instance);
			button3.removeActionListener(instance);
			button4.removeActionListener(instance);
			button5.removeActionListener(instance);
			button6.removeActionListener(instance);
			button7.removeActionListener(instance);
			button8.removeActionListener(instance);
			button9.removeActionListener(instance);
			buttonRestart.setVisible(true);
			
		}else {
			turn = turn == "X" ? "O" : "X";
			System.out.println(turn);
			argButton.removeActionListener(instance);
			label.setText("It's "+turn+"'s turn to play");
		}
			
	}
	
	public static void checkTiles() {
		if(button1.getIcon() == button2.getIcon() && button2.getIcon() == button3.getIcon() && button1.getIcon() != null && button2.getIcon() != null) {
			gameOver = true;
		}else if(button4.getIcon() == button5.getIcon() && button5.getIcon() == button6.getIcon() && button4.getIcon() != null && button5.getIcon() != null) {
			gameOver = true;
		}else if(button7.getIcon() == button8.getIcon() && button8.getIcon() == button9.getIcon() && button7.getIcon() != null && button8.getIcon() != null) {
			gameOver = true;
		}else if(button1.getIcon() == button4.getIcon() && button4.getIcon() == button7.getIcon() && button1.getIcon() != null && button4.getIcon() != null) {
			gameOver = true;
		}else if(button2.getIcon() == button5.getIcon() && button5.getIcon() == button8.getIcon() && button2.getIcon() != null && button5.getIcon() != null) {
			gameOver = true;
		}else if(button3.getIcon() == button6.getIcon() && button6.getIcon() == button9.getIcon() && button3.getIcon() != null && button6.getIcon() != null) {
			gameOver = true;
		}else if(button1.getIcon() == button5.getIcon() && button5.getIcon() == button9.getIcon() && button1.getIcon() != null && button5.getIcon() != null) {
			gameOver = true;
		}else if(button3.getIcon() == button5.getIcon() && button5.getIcon() == button7.getIcon() && button3.getIcon() != null && button5.getIcon() != null) {
			gameOver = true;
		}else if(button1.getIcon() != null && button2.getIcon() != null && button3.getIcon() != null &&
				button4.getIcon() != null && button5.getIcon() != null && button6.getIcon() != null &&
				button7.getIcon() != null && button8.getIcon() != null && button9.getIcon() != null && gameOver == false) {
			gameOver = true;
			isDraw = true;
		}
	}
	
	public static void firstFrame() {
		frame.setSize(600,750);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		label.setBounds(0,600,600,150);
		label.setFont(new Font("MV Bolis",Font.BOLD,40));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		frame.add(label);
		
		panel.setSize(600,600);
		panel.setLayout(new GridLayout(3,3));
		
		button1.addActionListener(instance);
		button2.addActionListener(instance);
		button3.addActionListener(instance);
		button4.addActionListener(instance);
		button5.addActionListener(instance);
		button6.addActionListener(instance);
		button7.addActionListener(instance);
		button8.addActionListener(instance);
		button9.addActionListener(instance);
		buttonRestart.addActionListener(instance);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		
		frame.add(buttonRestart);
		buttonRestart.setBounds(450,600,120,120);
		buttonRestart.setFont(new Font("MV Bolis",Font.BOLD,10));
		buttonRestart.setIcon(iconRestart);
		buttonRestart.setVisible(false);
		
		frame.setResizable(false);
		frame.setTitle("Tic Tac Toe");
		frame.setIconImage(iconIcon.getImage());
		frame.setVisible(true);
	}
	
	public static void refreshGame() {
		frame.dispose();
		button1.setIcon(null);
		button2.setIcon(null);
		button3.setIcon(null);
		button4.setIcon(null);
		button5.setIcon(null);
		button6.setIcon(null);
		button7.setIcon(null);
		button8.setIcon(null);
		button9.setIcon(null);
		gameOver = false;
		isDraw = false;
		label.setText("It's "+turn+"'s turn to play");
		buttonRestart.setVisible(false);
		newFrame();
		
	}
	
	public static void newFrame() {
		
		button1.addActionListener(instance);
		button2.addActionListener(instance);
		button3.addActionListener(instance);
		button4.addActionListener(instance);
		button5.addActionListener(instance);
		button6.addActionListener(instance);
		button7.addActionListener(instance);
		button8.addActionListener(instance);
		button9.addActionListener(instance);
		buttonRestart.setVisible(false);
		frame.setVisible(true);
		
	}
	
}
