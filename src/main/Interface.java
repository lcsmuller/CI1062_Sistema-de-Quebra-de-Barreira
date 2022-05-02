package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.File;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;


public class Interface extends JFrame {
	private Controle controle = new Controle();
    private static Interface uniqueInstance = null;
    private JPanel tablePanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JLabel lblIRA;
    private JPanel middlePanel;
    private JTable classTable;
    private JScrollPane tableScrollPane; 
    private JButton btnOpenCSVFile;
    private JButton btnOpenSaveFile;
    private JButton btnSave;
    private JButton btnSend;
    
    private float ira;
    
    //private Vector<String> cabeca = new Vector<>();
    private String [] cabeca = new String[9];
    /*private Vector<String> cabeca = new Vector<String>(Arrays.asList("1К periodo",
    				"2К periodo","3К periodo","4К periodo","5К periodo","6К periodo",
    				"7К periodo","8К periodo"));*/
    
    private Interface() {

    }

    /*public void montaCabeca () {
        this.cabeca.addElement("1К periodo");
        this.cabeca.addElement("2К periodo");
        this.cabeca.addElement("3К periodo");
        this.cabeca.addElement("4К periodo");
        this.cabeca.addElement("5К periodo");
        this.cabeca.addElement("6К periodo");
        this.cabeca.addElement("7К periodo");
        this.cabeca.addElement("8К periodo");
    }*/
    public void montaCabeca () {
    	for(int i = 1; i < 9; i++)
        this.cabeca[i-1] = i + "К periodo";
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
    	this.setTitle("Pedido Quebra de Barreiras");
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
        
        tableScrollPane = new JScrollPane(classTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane requestScrollPane = new JScrollPane();//aqui fica a listinha de coisas requisitadas
        
        //middlePanel = new JPanel(new BoxLayout());
        //tablePanel.setTopComponent(tableScrollPane);
        //tablePanel.setBottomComponent(requestScrollPane);
        tablePanel.add(tableScrollPane);
        //splitPane.setDividerLocation(500);
        
        lblIRA = new JLabel("IRA: --");
        
        btnSave = new JButton("Salvar");
        btnSend = new JButton("Enviar");
        btnOpenCSVFile = new JButton("Abrir arquivo CSV");
        btnOpenSaveFile = new JButton("Abrir arquivo Save");
        upperPanel.add(lblIRA);
        upperPanel.add(new JLabel("Amogus"));
        upperPanel.add(btnOpenCSVFile);
        upperPanel.add(btnOpenSaveFile);
        
        lowerPanel.add(new JLabel("sonegaчуo de imposto"));
        lowerPanel.add(btnSave);
        lowerPanel.add(btnSend);
    }
    
    //Conecta metodos aos botoes da interface
    private void addButtonListeners() {
    	btnOpenCSVFile.addActionListener(new ActionListener() {
    		@Override
        	public void actionPerformed(ActionEvent e) {
				OpenAndReadCSVFile();
			}
		});
    	
    	btnOpenSaveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OpenAndReadSaveFile();
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
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
			//FileSaveReader fsr = new FileSaveReader();
			String tokens[][] = Csv.tokeniza(file.getName());
			controle.getMat_aluno().tokensToLista(tokens);
			this.ira = controle.ira();
			lblIRA.setText("IRA: " + this.ira);
			controle.possiveisPedidos();
			String [][] tabela = controle.tabelaMateria();
			classTable = new JTable(tabela,cabeca);
			classTable.setBounds(0, 0, 400, 400);
			tableScrollPane.add(classTable);
        
			/*leitura do arquivo aqui*/
			//fsr.leArquivo(file.getName());
			//classTable = new JTable((TableModel) new Controle().tabelaMateria());
		}
    }
    
    private void OpenAndReadSaveFile() {
    	JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Save", "save");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			//FileSaveReader fsr = new FileSaveReader();
			/*leitura do arquivo aqui*/
		}
    }

    private void save() {
        String[][] tokens = controle.getPedidos().listaToTokens();
        FileSaveReader.escreveArquivo(tokens);
    }
    
    private void send() {
		
	}

    private void initialize() {
    	
        setInterfaceParameters();
        addSwingComponents();
        addButtonListeners();
        this.montaCabeca();
        String [][] tokens = Csv.tokeniza("exemplo_trabalho_TAP_Disciplinas_2019.csv");
        controle.getLista_materia().tokensToLista(tokens);
        
        this.revalidate();
        this.repaint();
    }
 
    public static void main(String args[]) {
        Interface frame = getInstance();
        
    }

}