
/* Author: Zubair Ab Aziz
 * Assignment: Project4
 * Lab Section: MW, 1230-1345
 * TA Name: Sofia
 * Collaboration: I did not collaborate with anyone on this assignment
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;

	protected static int life = 3;
	protected int ballWidth = 20;
	protected int ballHeight = 20;
	protected static int ballX = 10;
	protected static int ballY = 10;
	protected static int barX;
	protected static int barY;
	protected static int velocityX = 4;
	protected static int velocityY = 1;
	protected int angle = -45;
	protected static double g = 9.8;
	protected static int qwe = (int) (.5 * g);
	protected int t = Game.t;
	protected static int score = 0;
	protected int borderRight = 900;
	protected int borderDown = 700;

	public int getBallX() {
		return ballX;
	}

	public int getBallY() {
		return ballY;
	}

	public int getBarX() {
		return barX;
	}

	public int getBarY() {
		return barY;
	}

	public void incrBarX() {
		barX += 10;
	}

	public void decrBarX() {
		barX -= 10;
	}

	public void setLocation() {

		t++;
		ballX += (velocityX);
		ballY += (velocityY + qwe * t) / 20;

		if (GamePanel.ballY >= borderDown) {
			life -= 1;
			t = 0;
			ballY = 10;
			ballX = 10;
			System.out.println(life);
			if (life == 0) {
				g = 0;
				t = 0;
				velocityX = 0;
				velocityY = 0;
				ballY = 1;
				ballX = 1;
			}
		}
		if (ballY <= 5) {
			velocityY = -velocityY;
			ballY = 5;
			t = -t;
		}
		if (ballX >= borderRight - 35) {
			velocityX = -velocityX;
		}
		if (ballX <= 0) {
			velocityX = -velocityX;
		}
		if (ballY >= barY && ballX >= barX - 5 && ballX <= barX + 120) {
			velocityY = -velocityY;
			ballY = barY - 70;
			t = -t;
		}
	}

	public GamePanel() {
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		barY = getHeight() - 25;
		g.setColor(Color.BLACK);
		g.fillRect(barX, barY, 120, 10);
		g.setColor(Color.RED);
		g.fillOval(ballX, ballY, ballWidth, ballHeight);
		g.setColor(Color.BLACK);
		g.drawString("Lives: " + life, 5, 10);
		g.drawString("Score: " + score, 5, 22);

		if (life == 0) {
			g.drawString("GAME OVER. You ended with " + score + " points.", 350, 300);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			incrBarX();

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			decrBarX();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
