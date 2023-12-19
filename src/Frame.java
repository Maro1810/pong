import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, KeyListener{
	JFrame f = new JFrame("Pong");
	
	int paddleLeftX = 0;
	int paddleLeftY = 150;
	
	int paddleRightX = 956;
	int paddleRightY = 150;
	
	int ballX = 470;
	int ballY = 200;
	
	int ballVx = 1;
	int ballVy = 1;
	
	boolean paddleLeftUp;
	boolean paddleLeftDown;
	
	boolean paddleRightUp;
	boolean paddleRightDown;
	
	int scoreLeft;
	int scoreRight;
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.fillRect(paddleLeftX, paddleLeftY, 30, 200);
		g.fillRect(paddleRightX, paddleRightY, 30, 200);
		g.fillOval(ballX, ballY, 40, 40);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
		g.drawString(scoreLeft+"", 380, 60);
		g.drawString(scoreRight+"", 525, 60);
		g.drawString("-", 460, 60);
		repaint();
		update();
	}
	public void update(){
		ballX += ballVx;
		ballY += ballVy;
		
		if (ballY == 530) {
			ballVy *= -1;
		}
		if (ballY == 0) {
			ballVy *= -1;
		}
		if (ballX < -9) {
			ballX = 670;
			ballY = 200;
			ballVy *= -1;
			scoreRight++;
		}
		if (ballX > 1009) {
			ballX = 370;
			ballY = 200;
			ballVy *= -1;
			scoreLeft++;
		}
		if (ballX == 926 && (ballY+30) >= (paddleRightY) && ballY <= (paddleRightY+200)) {
			ballVx *= -1;
		}
		if (ballX == 30 && (ballY+30) >= (paddleLeftY) && ballY <= (paddleLeftY+200)) {
			ballVx *= -1;
		}
		if (paddleLeftUp) {
			paddleLeftY -= 1;
		}
		if (paddleLeftDown) {
			paddleLeftY += 1;
		}
		if (paddleRightUp) {
			paddleRightY -= 1;
		}
		if (paddleRightDown) {
			paddleRightY += 1;
		}
		if (paddleLeftY <= 0) {
			paddleLeftY = 1;
		}
		if (paddleLeftY >= 367) {
			paddleLeftY = 366;
		}
		if (paddleRightY <= 0) {
			paddleRightY = 1;
		}
		if (paddleRightY >= 367) {
			paddleRightY = 366;
		}
	}
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	public Frame() {
		f.setSize(new Dimension(1000, 600));
		f.setBackground(Color.green);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addKeyListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	@Override
	public void keyPressed(KeyEvent key) {
		if (key.getKeyCode() == 87) {
			paddleLeftUp = true;
		}
		if (key.getKeyCode() == 83) {
			paddleLeftDown = true;
		}
		if (key.getKeyCode() == 38) {
			paddleRightUp = true;
		}
		if (key.getKeyCode() == 40) {
			paddleRightDown = true;
		}
		
		
	} 
	@Override
	public void keyReleased(KeyEvent key) {
		if (key.getKeyCode() == 87) {
			paddleLeftUp = false;
		}
		if (key.getKeyCode() == 83) {
			paddleLeftDown = false;
		}
		if (key.getKeyCode() == 38) {
			paddleRightUp = false;
		}
		if (key.getKeyCode() == 40) {
			paddleRightDown = false;
		}
	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
