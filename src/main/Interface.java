package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

public class Interface extends JFrame {
    private static Interface uniqueInstance = null;
    private JPanel tablePanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JTable classTable;
    private JButton btnOpenFile;
    
    private Interface() {

    }

    
    public static synchronized Interface getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Interface();
            uniqueInstance.initialize();
        }
        return uniqueInstance;
    }
    
    //Configura parametros para a funcionalidade da interface
    private void setInterfaceParameters() {
    	this.setTitle("Trabalho Paradigmas");
        this.setLayout(new BorderLayout());
        this.setIconImage(null);
        this.setSize(900, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //Adiciona componentes da interface
    private void addSwingComponents() {
    	tablePanel = new JPanel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        
        tablePanel.setLayout(new BorderLayout());
        this.add(tablePanel, BorderLayout.CENTER);
        
        upperPanel.setLayout(new FlowLayout());
        this.add(upperPanel, BorderLayout.NORTH);
        
        lowerPanel.setLayout(new FlowLayout());
        this.add(lowerPanel, BorderLayout.SOUTH);
        
        JScrollPane scrollPane = new JScrollPane(classTable);
        tablePanel.add(scrollPane);
        
        btnOpenFile = new JButton("Abrir arquivo");
        upperPanel.add(new JLabel());
        upperPanel.add(new JLabel("sus"));
        upperPanel.add(btnOpenFile);
        
        lowerPanel.add(new JLabel("sonegação de imposto"));
    }
    
    //Conecta metodos aos botoes da interface
    private void addButtonListeners() {
    	btnOpenFile.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				OpenAndReadCSVFile();
			}
		});
    }
    
    //Abre e le o arquivo CSV selecionado pelo usuario
    private void OpenAndReadCSVFile() {
    	JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			FileSaveReader fsr = new FileSaveReader();
			/*leitura do arquivo aqui*/
			//fsr.leArquivo(file.getName());
			//classTable = new JTable((TableModel) new Controle().tabelaMateria());
		}
    }

    private void initialize() {
    	
        setInterfaceParameters();
        addSwingComponents();
        addButtonListeners();
        
        
        this.revalidate();
        this.repaint();
    }
 
    public static void main(String args[]) {
        Interface frame = getInstance();
        
    }

}