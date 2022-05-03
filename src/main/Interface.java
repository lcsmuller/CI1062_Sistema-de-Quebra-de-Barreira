package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
    private JPanel extraPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JLabel lblIRA;
    private JLabel lblSus;
    private JTable classTable;
    private JTable requestTable;
    private JButton btnOpenCSVFile;
    private JButton btnOpenSaveFile;
    private JButton btnAdd;
    private JButton btnSave;
    private JButton btnSend;
    
    private float ira;
    private String arquivoAluno;
    
    //private Vector<String> cabeca = new Vector<>();
    private String [] cabeca = new String[8];
    /*private Vector<String> cabeca = new Vector<String>(Arrays.asList("1º periodo",
    				"2º periodo","3º periodo","4º periodo","5º periodo","6º periodo",
    				"7º periodo","8º periodo"));*/
    
    private Interface() {

    }

    public void montaCabeca () {
    	for(int i = 1; i < 9; i++)
        this.cabeca[i-1] = i + "º periodo";
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
        extraPanel = new JPanel();
        //splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        
        tablePanel.setLayout(new BorderLayout());
        this.add(tablePanel, BorderLayout.CENTER);
        
        upperPanel.setLayout(new FlowLayout());
        this.add(upperPanel, BorderLayout.NORTH);
        
        lowerPanel.setLayout(new FlowLayout());
        this.add(lowerPanel, BorderLayout.SOUTH);
        
        
        //middlePanel = new JPanel(new BoxLayout());
        //tablePanel.setTopComponent(tableScrollPane);
        //tablePanel.setBottomComponent(requestScrollPane);
        //tablePanel.add(classTable);//tableScrollPane);
        //splitPane.setDividerLocation(500);
        //tablePanel.add(splitPane);
        classTable = new JTable();
        requestTable = new JTable();
		//tablePanel.add(new JLabel("Possíveis escolhas"), BorderLayout.NORTH);
        lblIRA = new JLabel("IRA: --");
        
        btnSave = new JButton("Salvar");
        btnSend = new JButton("Enviar");
        btnOpenCSVFile = new JButton("Abrir arquivo CSV");
        btnOpenSaveFile = new JButton("Abrir arquivo Save");
        btnAdd = new JButton("Adicionar matéria selecionada");
        upperPanel.add(lblIRA);
        lblSus = new JLabel("Amogus");
        upperPanel.add(lblSus);
        upperPanel.add(btnOpenCSVFile);
        upperPanel.add(btnOpenSaveFile);
        
        tablePanel.add(btnAdd, BorderLayout.NORTH);
        lowerPanel.add(new JLabel("sonegação de imposto"));
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
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addSubject();
			}
		});
		
    }
    
    private void addSubject() {
		int r = classTable.getSelectedRow();
		int c = classTable.getSelectedColumn();
		if (r > 0) {
			String str = (String) classTable.getValueAt(r, c);
			try {
				if (!str.equals(""))
					lblSus.setText(str);
					int materia = controle.getLista_materia().procurarMateria(str);
					controle.getPedidos().inserir(controle.getLista_materia().listaGetAt(materia));
					controle.getPedidos().imprimeLista();
			} catch (Exception erro) {}	
		}
	}
	
    private void refresh(){
		this.revalidate();
		this.repaint();
	}
    
    //Abre e le o arquivo CSV selecionado pelo usuario
    private void OpenAndReadCSVFile() {
    	JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			//FileSaveReader fsr = new FileSaveReader();
			arquivoAluno  = file.getName();
			String tokens[][] = Csv.tokeniza(file.getName());
			controle.getMat_aluno().tokensToLista(tokens);
			this.ira = controle.ira();
			lblIRA.setText("IRA: " + this.ira);
			controle.possiveisPedidos();
			String [][] tabela = controle.tabelaMateria();
			classTable = new JTable(tabela,cabeca);
			classTable.setBounds(0, 0, 400, 400);
			tablePanel.add(classTable, BorderLayout.CENTER);
			classTable.setDefaultEditor(Object.class, null); // REMOVER DPS PRA BRINCAR
			tablePanel.add(requestTable, BorderLayout.SOUTH);
			//splitPane.setTopComponent(classTable);
        
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
			arquivoAluno  = file.getName();
			String tokens[][] = FileSaveReader.leArquivo(file.getName());
			controle.getMat_aluno().tokensToLista(tokens);
			this.ira = controle.ira();
			lblIRA.setText("IRA: " + this.ira);
			controle.possiveisPedidos();
			String [][] tabela = controle.tabelaMateria();
			classTable = new JTable(tabela,cabeca);
			classTable.setBounds(0, 0, 400, 400);
			tablePanel.add(classTable, BorderLayout.CENTER);
			classTable.setDefaultEditor(Object.class, null); // REMOVER DPS PRA BRINCAR
			tablePanel.add(requestTable, BorderLayout.SOUTH);
		}
    }

    private void save() {
        String[][] tokens = controle.getPedidos().listaToTokens();
        FileSaveReader.setFonte(arquivoAluno);
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