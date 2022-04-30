package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
        this.setSize(900, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        
        JScrollPane scrollPane = new JScrollPane(classTable);
        tablePanel.add(scrollPane);
        
        upperPanel.add(new JLabel("among us"));
        upperPanel.add(new JLabel("sus"));
        upperPanel.add(new JButton("pipis"));
        
        lowerPanel.add(new JLabel("sonegação de imposto"));
    }
 
    public static void main(String args[]) {
        Interface frame = getInstance();
        
    }

}