package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Interface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controle controle;
    private static Interface uniqueInstance = null;
    private JPanel tablePanel;
    //private JPanel extraPanel;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JLabel lblIRA;
    private JLabel lblSus;
    private JLabel lblDes; 
    private JLabel lblFaltantes;
    private JLabel lblmaxsel;
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
    private String grrAluno;
    private String nomeCurso;
    
    private String [] cabeca = new String[8];
    
    private Interface() {
    	
    }
    
    public static synchronized Interface getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Interface();
            uniqueInstance.initialize();
        }
        return uniqueInstance;
    }
    
    public void montaCabeca () {
    	for(int i = 1; i < 9; i++)
        this.cabeca[i-1] = i + "º periodo";
    }
    
    //Configura parametros para a funcionalidade da interface
    private void setInterfaceParameters() {
    	this.setTitle("Pedido Quebra de Barreiras");
        this.setLayout(new BorderLayout());
        this.setIconImage(null);
        this.setSize(1300, 700);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        
        upperPanel.setLayout(new GridLayout(2,3));
        this.add(upperPanel, BorderLayout.NORTH);
        upperPanel.setBackground(Color.getHSBColor((float) 0.50, (float) 0.35, (float) 0.5));
        
        lowerPanel.setLayout(new GridLayout(1,2));
        this.add(lowerPanel, BorderLayout.SOUTH);
        upperPanel.setBackground(Color.getHSBColor((float) 0.50, (float) 0.35, (float) 0.5));
        
       
        classTable = new JTable();
        requestTable = new JTable();
       
       
        
        //gera o cabecalho
        btnOpenCSVFile = new JButton("Abrir arquivo CSV");
        btnOpenCSVFile.setFont(new Font("Dialog", Font.PLAIN, 16));
        btnOpenSaveFile = new JButton("Abrir arquivo Save");
        btnOpenSaveFile.setFont(new Font("Dialog", Font.PLAIN, 16));
        lblIRA = new JLabel("IRA: --");
        lblIRA.setFont(new Font("Dialog",Font.PLAIN, 20));
        lblSus = new JLabel("Amogus");
        lblSus.setFont(new Font("Dialog",Font.PLAIN, 20));
        lblDes = new JLabel("Desempenho no ultimo semestre: --");
        lblDes.setFont(new Font("Dialog",Font.PLAIN, 20));
        
        // monta do cabecalho 
        upperPanel.add(lblIRA);
        upperPanel.add(lblSus);
        upperPanel.add(btnOpenCSVFile);
        upperPanel.add(lblDes);
        JLabel coiso = new JLabel(""); 
        upperPanel.add(coiso);
        upperPanel.add(btnOpenSaveFile);
        
        //gera radape
        btnSave = new JButton("Salvar Pedido");
        btnSave.setFont(new Font("Dialog",Font.PLAIN, 16));
        btnSend = new JButton("Enviar Pedido");
        btnSend.setFont(new Font("Dialog",Font.PLAIN, 16));
        
        //monta rodape 
        lowerPanel.add(btnSave);
        lowerPanel.add(btnSend);
        
        //gera meioca
        btnHist = new JButton("Ver seu historico na materia");
        btnHist.setFont(new Font("Dialog", Font.PLAIN, 16));
        btnDel = new JButton("Remover matéria selecionada");
        btnDel.setFont(new Font("Dialog", Font.PLAIN, 16));
        btnAdd = new JButton("Adicionar matéria selecionada");
        btnAdd.setFont(new Font("Dialog", Font.PLAIN, 16));
        lblFaltantes = new JLabel("materias pré barreira faltantes  --",SwingConstants.CENTER);
        lblFaltantes.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblmaxsel = new JLabel("máximo de matérias pós barreira selecionaveis: -- ",SwingConstants.CENTER);
        lblmaxsel.setFont(new Font("Dialog", Font.PLAIN, 20));
        JLabel lblTamFalt = new JLabel("Para pegar materias após o 3º periodo, é necessario pegar todas as materias pré-barreira", SwingConstants.CENTER);
        lblTamFalt.setFont(new Font("Dialog",Font.PLAIN, 20));
        
        //monta meioca
        tablePanel1.add(btnAdd, BorderLayout.SOUTH);
        tablePanel2.add(btnHist, BorderLayout.SOUTH);
        tablePanel3.add(btnDel, BorderLayout.SOUTH);
        
        tablePanel4.add(lblTamFalt, BorderLayout.NORTH);
        JPanel minisub = new JPanel();
        minisub.setLayout(new GridLayout(1,2));
        minisub.setBackground(Color.getHSBColor((float) 0.50, (float) 0.35, (float) 0.5));
        minisub.add(lblFaltantes,BorderLayout.CENTER);
        minisub.add(lblmaxsel,BorderLayout.CENTER);
		tablePanel4.add(minisub, BorderLayout.CENTER);
		tablePanel4.setBackground(Color.getHSBColor((float) 0.50, (float) 0.35, (float) 0.5));
        //tablePanel4.add(cansasso2, BorderLayout.SOUTH);
        
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
					int materia = controle.getListaPedidos().procurarMateriaNome(str);
					int falt = controle.getListaFaltantes().procurarMateriaNome(str);
					if (falt == -1 && controle.getListaPedidos().listaGetAt(materia).getPeriodo() < 4)
						controle.getListaFaltantes().inserir(controle.getListaPedidos().listaGetAt(materia));
					controle.getListaPedidos().removerEm(materia);
					controle.analizarPedido();
					lblFaltantes.setText("materias pré barreira faltantes " +controle.getListaFaltantes().tamanhoLista());
					tablePanel3.remove(requestTable);
					requestTable = new JTable(controle.tabelaMateriaPedidas(), cabeca);  
					tablePanel3.add(requestTable,BorderLayout.NORTH);
					requestTable.setDefaultEditor(Object.class, null);
					requestTable.setRowSelectionAllowed(false);
					requestTable.setGridColor(Color.BLACK);
					requestTable.setBackground(Color.getHSBColor((float) 0.0, (float) 0, (float) 0.8));
					requestTable.setForeground(Color.BLACK);
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
			try {
				if (!str.equals("")) {
					int materia = controle.getListaMateria().procurarMateriaNome(str);
					controle.getListaPedidos().inserir(controle.getListaMateria().listaGetAt(materia));
					int falt = controle.getListaFaltantes().procurarMateriaNome(str);
					if (falt != -1)
						controle.getListaFaltantes().removerEm(falt);
					System.out.println("tamanho: " + controle.getListaFaltantes().tamanhoLista());
					int analise = controle.analizarPedido();
					analisePopup(analise);
					lblFaltantes.setText("materias pré barreira faltantes " +controle.getListaFaltantes().tamanhoLista());
					tablePanel3.remove(requestTable);
					requestTable = new JTable(controle.tabelaMateriaPedidas(), cabeca);
					tablePanel3.add(requestTable,BorderLayout.NORTH);
					requestTable.setDefaultEditor(Object.class, null);
					requestTable.setRowSelectionAllowed(false);
					requestTable.setGridColor(Color.BLACK);
					requestTable.setBackground(Color.getHSBColor((float) 0.0, (float) 0, (float) 0.8));
					requestTable.setForeground(Color.BLACK);
				}
			} catch (Exception erro) {}	
		}
		refresh();
	}
    private void reavaliaPedidos() {
    	ListaPedidos novalista = controle.getListaPedidos();
    	controle.setListaPedidos(new ListaPedidos());
    	for (int i = 0; i < novalista.tamanhoLista(); i++){
			String str = novalista.listaGetAt(i).getNome();
			int materia = controle.getListaMateria().procurarMateriaNome(str);
			controle.getListaFaltantes().inserir(controle.getListaMateria().listaGetAt(materia));
			int falt = controle.getListaFaltantes().procurarMateriaNome(str);
			if (falt != -1)
				controle.getListaFaltantes().removerEm(falt);
			System.out.println("tamanho: " + controle.getListaFaltantes().tamanhoLista());
			controle.analizarPedido();
		}
    	lblFaltantes.setText("materias pré barreira faltantes " +controle.getListaFaltantes().tamanhoLista());
		tablePanel3.remove(requestTable);
		requestTable = new JTable(controle.tabelaMateriaPedidas(), cabeca);
		tablePanel3.add(requestTable,BorderLayout.NORTH);
		requestTable.setDefaultEditor(Object.class, null);
		requestTable.setRowSelectionAllowed(false);
		requestTable.setGridColor(Color.BLACK);
		requestTable.setBackground(Color.getHSBColor((float) 0.0, (float) 0, (float) 0.8));
		requestTable.setForeground(Color.BLACK);
		refresh();
	}
    
    private void analisePopup(int motivo) {
		switch (motivo) {
			case 1:
			case 2:
			case 3:
				JOptionPane.showMessageDialog(this, "Limite de matérias requisitadas ultrapassado", "Erro", JOptionPane.WARNING_MESSAGE);
			break;
			case 4:
				JOptionPane.showMessageDialog(this, "É necessario pegar todas as matérias pré barreira para pedir matérias pós barreira", "Erro", JOptionPane.WARNING_MESSAGE);
			break;
			case 0:
			default:
		}
	}
    
    private void geraNovoPainel() {
    	int r = fTable.getSelectedRow();
		int c = fTable.getSelectedColumn();
		if (r > 0) {
			String str = (String) fTable.getValueAt(r, c);
			try {
				if (!str.equals("")) {
					//lblSus.setText(str);
					int materia = controle.getListaMateriaAluno().procurarMateriaNome(str);
					AlunoMateria mat = controle.getListaMateriaAluno().listaGetAt(materia);
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
		requestTable = new JTable(controle.tabelaMateriaPedidas(), cabeca); 
		//BLOCO DE INSERIR NA TELA
		tablePanel1.add(classTable, BorderLayout.NORTH);
		tablePanel2.add(fTable, BorderLayout.NORTH);
		tablePanel3.add(requestTable, BorderLayout.NORTH);
		//BLOCO DE REMOVER CONTROLE DO USUARIO 
		classTable.setDefaultEditor(Object.class, null); 
		fTable.setDefaultEditor(Object.class, null); 
		requestTable.setDefaultEditor(Object.class, null);
		classTable.setRowSelectionAllowed(false);
		fTable.setRowSelectionAllowed(false);
		requestTable.setRowSelectionAllowed(false);
		classTable.setGridColor(Color.BLACK);
		classTable.setForeground(Color.BLACK
				
				
				 .darker().darker().darker()
				 .darker().darker().darker()
				 .darker().darker().darker()
		.darker().darker()         /////////
		.darker().darker()		   /////////
		.darker().darker()		   /////////
		.darker().darker().darker().darker()
		.darker().darker().darker().darker()
		.darker().darker().darker().darker()
				 .darker()		   .darker()
				 .darker()		   .darker()
				 .darker()		   .darker());
				 
		classTable.setBackground(Color.getHSBColor((float) 0.0, (float) 0, (float) 0.8));
		requestTable.setGridColor(Color.BLACK);
		requestTable.setBackground(Color.getHSBColor((float) 0.0, (float) 0, (float) 0.8));
		requestTable.setForeground(Color.BLACK);
		fTable.setGridColor(Color.BLACK);
		fTable.setBackground(Color.getHSBColor((float) 0.0, (float) 0, (float) 0.8));
		fTable.setForeground(Color.BLACK);
		this.repaint();
		this.revalidate();
	}
		
    //Abre e le o arquivo CSV selecionado pelo usuario
    private void OpenAndReadCSVFile() {
    	controle = new Controle();
    	String [][] tokens = Csv.tokeniza("exemplo_trabalho_TAP_Disciplinas_2019.csv");
        controle.getListaMateria().tokensToLista(tokens);
    	JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			//FileSaveReader fsr = new FileSaveReader();
			arquivoAluno  = file.getName();
			tokens = Csv.tokeniza(file.getName());
			nomeAluno = tokens[2][1];
			grrAluno = tokens[2][0];
			nomeCurso = tokens[2][3];
			lblSus.setText(nomeAluno);
			controle.getListaMateriaAluno().tokensToLista(tokens);
			this.ira = controle.ira();
			lblIRA.setText("IRA: " + this.ira);
			lblDes.setText("Desempenho no ultimo semestre:" + controle.getDesempenho());
			controle.possiveisPedidos();
			controle.preencheFaltantes();
			reavaliaPedidos();
			lblFaltantes.setText("materias pré barreira faltantes " +controle.getListaFaltantes().tamanhoLista());
			geraJtable();
			if (controle.ira() > 0.8)
				lblmaxsel.setText("máximo de matérias pós barreira selecionaveis: 999");
			else {
				if (controle.getDesempenho() < 0.33)
					lblmaxsel.setText("máximo de matérias pós barreira selecionaveis: 3");
				else if (controle.getDesempenho() < 0.66)
					lblmaxsel.setText("máximo de matérias pós barreira selecionaveis: 4");
				else 
					lblmaxsel.setText("máximo de matérias pós barreira selecionaveis: 5");
			}
		}
    }
    
    private void OpenAndReadSaveFile() {
    	controle = new Controle();
    	String [][] tokens = Csv.tokeniza("exemplo_trabalho_TAP_Disciplinas_2019.csv");
        controle.getListaMateria().tokensToLista(tokens);
    	JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Save", "save");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			tokens = FileSaveReader.leArquivo(file.getName());
			controle.getListaPedidos().tokensToLista(tokens);
			arquivoAluno = FileSaveReader.getFonte();
			tokens = Csv.tokeniza(arquivoAluno);
			nomeAluno = tokens[2][1];
			grrAluno = tokens[2][0];
			nomeCurso = tokens[2][3];
			lblSus.setText(nomeAluno);
			controle.getListaMateriaAluno().tokensToLista(tokens);
			this.ira = controle.ira();
			lblIRA.setText("IRA: " + this.ira);
			lblDes.setText("Desempenho no ultimo semestre:" + controle.getDesempenho());
			controle.preencheFaltantes();
			lblFaltantes.setText("materias pré barreira faltantes " + controle.getListaFaltantes().tamanhoLista());
			geraJtable();
			if (controle.ira() > 0.8)
				lblmaxsel.setText("máximo de matérias pós barreira selecionaveis: 999");
			else {
				if (controle.getDesempenho() < 0.33)
					lblmaxsel.setText("máximo de matérias pós barreira selecionaveis: 3");
				else if (controle.getDesempenho() < 0.66)
					lblmaxsel.setText("máximo de matérias pós barreira selecionaveis: 4");
				else 
					lblmaxsel.setText("máximo de matérias pós barreira selecionaveis: 5");
			}
		}
    }

    private void save() {
        String[][] tokens = controle.getListaPedidos().listaToTokens();
        FileSaveReader.setFonte(arquivoAluno);
        FileSaveReader.escreveArquivo(tokens);
        JOptionPane.showMessageDialog(this, "Pedido salvo com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void send() {
    	FileSend.setFonte(arquivoAluno);
    	String comentario = JOptionPane.showInputDialog("comentario (opcional)");
		FileSend.montaPedido(nomeAluno,grrAluno,nomeCurso,comentario,controle);
		JOptionPane.showMessageDialog(this, "Pedido enviado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

    private void initialize() {
        setInterfaceParameters();
        addSwingComponents();
        addButtonListeners();
        this.montaCabeca();
        
        this.revalidate();
        this.repaint();
    }
 
    @SuppressWarnings("unused")
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    	}
    	catch(Exception e) {System.out.println("deu ruim");}
        Interface frame = getInstance();
    }

}