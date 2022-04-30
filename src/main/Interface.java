package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Interface extends JFrame {
    private static Interface uniqueInstance = null;
    private JPanel tablePanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JTable classTable;
    
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
        this.setTitle("Trabalho Paradigmas");
        this.setLayout(new BorderLayout());
        this.setIconImage(null);
        this.setSize(600, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        tablePanel = new JPanel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        classTable = new JTable();
        
        tablePanel.setLayout(new BorderLayout());
        this.add(tablePanel, BorderLayout.CENTER);
        
        upperPanel.setLayout(new FlowLayout());
        this.add(upperPanel, BorderLayout.NORTH);
        
        lowerPanel.setLayout(new FlowLayout());
        this.add(lowerPanel, BorderLayout.SOUTH);
        
        tablePanel.add(classTable);
    }
 
    public static void main(String args[]) {
        Interface frame = getInstance();
        
    }

}