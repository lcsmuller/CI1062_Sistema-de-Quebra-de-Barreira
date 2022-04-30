package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JFrame {
	private static Interface uniqueInstance = null;
	private JPanel panel;
	private JButton button;

	private Interface() {

	}

	public static synchronized Interface getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Interface();
			uniqueInstance.initialize();
		}
		return uniqueInstance;
	}

	private void initialize() {
		this.setTitle("Trabalho :)");
		this.setLayout(new BorderLayout());
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		button = new JButton();
		panel.setLayout(new BorderLayout());
		this.add(panel);
		panel.add(button, BorderLayout.CENTER);
	}
	/*
	 * public static void main(String args[]) { Interface frame = getInstance(); }
	 */
}