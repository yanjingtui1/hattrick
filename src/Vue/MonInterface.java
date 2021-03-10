package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Game.Game;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonInterface window = new MonInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MonInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1185, 839);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNextTrick = new JButton("next trick");
		btnNextTrick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNextTrick.setBounds(543, 738, 113, 27);
		frame.getContentPane().add(btnNextTrick);
		
		JButton btnThisTrick = new JButton("this trick");
		btnThisTrick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThisTrick.setBounds(419, 738, 113, 27);
		frame.getContentPane().add(btnThisTrick);
		
		JButton btnChangeProps = new JButton("change props");
		btnChangeProps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChangeProps.setBounds(252, 738, 153, 27);
		frame.getContentPane().add(btnChangeProps);
		
		JButton btnPerform = new JButton("perform");
		btnPerform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPerform.setBounds(668, 738, 113, 27);
		frame.getContentPane().add(btnPerform);
		
		JButton btnRestart = new JButton("restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRestart.setBounds(795, 738, 113, 27);
		frame.getContentPane().add(btnRestart);
	}
}
