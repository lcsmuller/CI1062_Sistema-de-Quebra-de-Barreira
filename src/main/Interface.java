package main;

import java.awt.BorderLayout;
//import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import java.io.Console;
import java.io.File;
//import java.util.Arrays;
//import java.util.Vector;

//import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.table.TableModel;


public class Interface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controle controle = new Controle();
    private static Interface uniqueInstance = null;
    private JPanel tablePanel;
    //private JPanel extraPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JLabel lblIRA;
    private JLabel lblSus;
    private JLabel lblDes; 
    private JTable classTable;
    private JTable requestTable;
    private JTable fTable;
    private JButton btnOpenCSVFile;
    private JButton btnOpenSaveFile;
    private JButton btnAdd;
    private JButton btnSave;
    private JButton btnSend;
    private JButton btnHist;
    private JButton btnDel;
    private JPanel tablePanel1;
    private JPanel tablePanel2;
    private JPanel tablePanel3;
    private JPanel tablePanel4;
    
    private float ira;					// ira 
    private String arquivoAluno;		// nome do arquivo do aluno, salvo para poder ser usado na escrita
    private String nomeAluno;   		// quando o programa estiver pronto trocar o amogus por isso
    
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
        this.setSize(900, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void addSubPanels() {
    	tablePanel1 = new JPanel();
        tablePanel2 = new JPanel();
        tablePanel3 = new JPanel();
        tablePanel4 = new JPanel();
        tablePanel1.setLayout(new BorderLayout());
        tablePanel2.setLayout(new BorderLayout());
        tablePanel3.setLayout(new BorderLayout());
        tablePanel4.setLayout(new BorderLayout());
        tablePanel.add(tablePanel1);
        tablePanel.add(tablePanel2);
        tablePanel.add(tablePanel3);
        tablePanel.add(tablePanel4);
    }
    //Adiciona componentes da interface
    private void addSwingComponents() {
    	tablePanel = new JPanel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        //splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        
        tablePanel.setLayout(new GridLayout(4,1));
        this.add(tablePanel, BorderLayout.CENTER);
        addSubPanels();
        
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
        btnHist = new JButton("Ver seu historico na materia");
        btnDel = new JButton("Remover matéria selecionada");
        btnOpenCSVFile = new JButton("Abrir arquivo CSV");
        btnOpenSaveFile = new JButton("Abrir arquivo Save");
        btnAdd = new JButton("Adicionar matéria selecionada");
        upperPanel.add(lblIRA);
        lblSus = new JLabel("Amogus");
        lblDes = new JLabel("Desempenho no ultimo semestre: --");
        upperPanel.add(lblSus);
        upperPanel.add(btnOpenCSVFile);
        upperPanel.add(btnOpenSaveFile);
        upperPanel.add(lblDes);
        
        lowerPanel.add(new JLabel("sonegação de imposto"));
        tablePanel1.add(btnAdd, BorderLayout.SOUTH);
        tablePanel2.add(btnHist, BorderLayout.SOUTH);
        tablePanel3.add(btnDel, BorderLayout.SOUTH);
        JLabel cansasso = new JLabel("<html>mudei coisa pra krl, o motivo pra estar assim é na linha 94 da interface, o gridlayout permite usar mais espaco e imprimir mais coisas sem bugar tudo ou explodir , tbm mudei os arquivos e suas leituras entao pega do git, <br>se tudo estiver certo ai quando vc abrir o csv vai aparecer 2 tabelas, 1 com as materias a fazer a outra com as materias feitas<br> e descobri como fazer jlables de varias linhas, sao extamente 4:59 eu vou dormir, ate<html>");
        // tirando isso eu mudei coisa pra krl na tentativa experimental de fazer a interface funcionar
        tablePanel4.add(cansasso, BorderLayout.SOUTH);
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
		
		btnHist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				geraNovoPainel();
			}
		});
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RemoveElemento();
			}
		});
    }
    
    private void RemoveElemento() {
    	int r = requestTable.getSelectedRow();
		int c = requestTable.getSelectedColumn();
		if (r > 0) {
			String str = (String) requestTable.getValueAt(r, c);
			try {
				if (!str.equals("")) {
					//lblSus.setText(str);
					int materia = controle.getPedidos().procurarMateria(str);
					int falt = controle.getFaltantes().procurarMateria(str);
					if (falt == -1)
						controle.getFaltantes().inserir(controle.getPedidos().listaGetAt(materia));
					controle.getPedidos().removerEm(materia);
					
					tablePanel3.remove(requestTable);
					requestTable = new JTable(controle.tabelaMateriapedidas(), cabeca);  
					tablePanel3.add(requestTable,BorderLayout.NORTH);
				}
			} catch (Exception erro) {}	
		}
		refresh();
    }
    
    private void addSubject() {
		int r = classTable.getSelectedRow();
		int c = classTable.getSelectedColumn();
		if (r > 0) {
			String str = (String) classTable.getValueAt(r, c);
			//try {
				if (!str.equals("")) {
					//lblSus.setText(str);
					int materia = controle.getLista_materia().procurarMateria(str);
					controle.getPedidos().inserir(controle.getLista_materia().listaGetAt(materia));
					int falt = controle.getFaltantes().procurarMateria(str);
					if (falt != -1)
						controle.getFaltantes().removerEm(falt);
					System.out.println("tamanho: " + controle.getFaltantes().tamanhoLista());
					controle.analizarPedido();
					tablePanel3.remove(requestTable);
					requestTable = new JTable(controle.tabelaMateriapedidas(), cabeca);  
					tablePanel3.add(requestTable,BorderLayout.NORTH);
				}
			//} catch (Exception erro) {}	
		}
		refresh();
	}
    
    private void geraNovoPainel() {
    	int r = fTable.getSelectedRow();
		int c = fTable.getSelectedColumn();
		if (r > 0) {
			String str = (String) fTable.getValueAt(r, c);
			try {
				if (!str.equals("")) {
					//lblSus.setText(str);
					int materia = controle.getMat_aluno().procurarMateriaNome(str);
					AlunoMateria mat = controle.getMat_aluno().listaGetAt(materia);
					JFrame novaPanel = new JFrame();
			    	novaPanel.setTitle("Informacao de materia feita");
			    	novaPanel.setLayout(new BorderLayout());
			    	novaPanel.setIconImage(null);
			    	novaPanel.setSize(400, 200);
			    	novaPanel.setVisible(true);
			    	//novaPanel.setDefaultCloseOperation(EXIT_ON_CLOSE);
			    	JPanel info = new JPanel(new GridLayout(4,2));
			    	novaPanel.add(info);
					JLabel matMateria = new JLabel("Nome:");
					JLabel matNota = new JLabel("Nota:");
					JLabel matFrequencia = new JLabel("Frequencia:");
					JLabel matSituacao = new JLabel("Situacao:");
					JLabel nome = new JLabel(mat.getNome());
					JLabel nota = new JLabel(String.valueOf(mat.getNota()));
					JLabel freq = new JLabel(String.valueOf(mat.getFrequencia()));
					JLabel sit = new JLabel("");
					info.add(matMateria);
					info.add(nome);
					info.add(matNota);
					info.add(nota);
					info.add(matFrequencia);
					info.add(freq);
					info.add(matSituacao);
					switch (mat.getCodSituacao()){
						case 1:
							sit = new JLabel("aprovado");
						break;
						case 2:
							sit = new JLabel("Reprovado por nota");
						break;	
						case 3:	
							sit = new JLabel("Reprovado por frequencia");
						break;
						default:
						break;
					}
					info.add(sit);
					info.setLayout(new GridLayout(4,2));
			        novaPanel.add(info);
				}
			} catch (Exception erro) {
				System.out.println("Erro ao Criar nova janela de materia(provavelmente nome vazio)");
			}
		} 
    }
    
    private void refresh(){
		this.revalidate();
		this.repaint();
	}
    
    private void geraJtable(){
    	controle.possiveisPedidos();
		String [][] tabela = controle.tabelaMateria();
		String[][] tabelaf = controle.tabelaMateriaFeitas();
		fTable = new JTable(tabelaf,cabeca);	
		classTable = new JTable(tabela,cabeca);
		requestTable = new JTable(controle.tabelaMateriapedidas(), cabeca); 
		//BLOCO DE INSERIR NA TELA
		tablePanel1.add(classTable, BorderLayout.CENTER);
		tablePanel2.add(fTable, BorderLayout.CENTER);
		tablePanel3.add(requestTable, BorderLayout.NORTH);
		//BLOCO DE REMOVER CONTROLE DO USUARIO 
		classTable.setDefaultEditor(Object.class, null); // REMOVER DPS PRA BRINCAR
		fTable.setDefaultEditor(Object.class, null); // REMOVER DPS PRA BRINCAR
		requestTable.setDefaultEditor(Object.class, null); // REMOVER DPS PRA BRINCAR
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
			nomeAluno = tokens[2][1];
			lblSus.setText(nomeAluno);
			controle.getMat_aluno().tokensToLista(tokens);
			this.ira = controle.ira();
			lblIRA.setText("IRA: " + this.ira);
			lblDes.setText("Desempenho no ultimo semestre:" + controle.getDesempenho());
			controle.possiveisPedidos();
			controle.preencheFaltantes();
			geraJtable();
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
			String tokens[][] = FileSaveReader.leArquivo(file.getName());
			controle.getPedidos().tokensToLista(tokens);
			arquivoAluno = FileSaveReader.getFonte();
			tokens = Csv.tokeniza(arquivoAluno);
			nomeAluno = tokens[2][1];
			lblSus.setText(nomeAluno);
			controle.getMat_aluno().tokensToLista(tokens);
			this.ira = controle.ira();
			lblIRA.setText("IRA: " + this.ira);
			lblDes.setText("Desempenho no ultimo semestre:" + controle.getDesempenho());
			controle.preencheFaltantes();
			geraJtable();
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
 
    @SuppressWarnings("unused")
	public static void main(String args[]) {
        Interface frame = getInstance();
        
    }

}