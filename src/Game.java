
/* Author: Zubair Ab Aziz
 * Assignment: Project4
 * Lab Section: MW, 1230-1345
 * TA Name: Sofia
 * Collaboration: I did not collaborate with anyone on this assignment
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	protected JButton launchButton;
	protected JPanel controlPanel, toppanel;
	protected Timer timer;
	protected JLabel lives;
	protected JLabel livestext;
	protected JLabel score;
	protected JLabel scoretext;
	protected JLabel timetext;
	protected static int gametime;
	protected static JProgressBar time;
	protected GamePanel game;
	protected static int t;

	public Game() {

		setSize(900, 700);
		setTitle("LOB PONG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		new BackgroundMusic();

		timer = new Timer(30, this);
		gametime = 500;

		game = new GamePanel();

		controlPanel = new JPanel();
		launchButton = new JButton("START");
		launchButton.setFocusable(false);
		launchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFocusable(true);
				addKeyListener(game);
				timer.start();
			}
		});
		controlPanel.add(launchButton);

		toppanel = new JPanel();
		toppanel.setLayout(new GridLayout(3, 1));

		timetext = new JLabel("Time Remaining: ");
		toppanel.add(timetext);
		time = new JProgressBar(0, gametime);
		time.setValue(gametime);
		toppanel.add(time);

		add(toppanel, BorderLayout.NORTH);
		add(controlPanel, BorderLayout.SOUTH);
		add(game, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		new Game().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (gametime == 0) {
			GamePanel.score += 100;
			gametime = 500;
		} else
			gametime--;

		time.setValue(gametime);
		if (GamePanel.life == 0) {
			gametime = 1;
		}

		game.getLocation();

		game.setLocation();

		game.repaint();
	}

}