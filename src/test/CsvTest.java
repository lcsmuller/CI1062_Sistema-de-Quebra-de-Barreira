package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import main.*;

class CsvTest {
	@Test
	void testLeLinhaCsv() throws Exception {
		final String CSVTeste = "GRR1234;Sergio;BCC;2011;2017;70";
		String[] linha = new Csv().tokenizaLinha(CSVTeste, ";");

		assertNotNull(linha);
		assertEquals("GRR1234", linha[0]);
		assertEquals("Sergio", linha[1]);
		assertEquals("BCC", linha[2]);
		assertEquals("2011", linha[3]);
		assertEquals("2017", linha[4]);
		assertEquals("70", linha[5]);
	}

	// @Test
	// void testEscreveArquivoCsv() throws Exception {
	// fail("não implementado");
	// }

	@Test
	void testLeArquivoCsv() throws Exception {
		final String[] arquivos = { "exemplo_trabalho_TAP_historico.csv",
				/*
				 * XXX: os arquivos a seguir possuem campos em ordem diferente, então
				 * matrizLista não é capaz de converter os valores
				 */
				"exemplo_trabalho_TAP_Disciplinas_2019.csv" };
		Csv csv = new Csv();
		String[][] info = csv.tokeniza(arquivos[0]);
		ListaMateriaAluno matAluno = new ListaMateriaAluno();
		matAluno.tokensToLista(info);
		//matAluno.imprimeLista();

		/* TODO: checar se novo.csv é idêntico ao arquivo original */
		csv.escreve(info, "novo.csv"); // escreve no arquivo

		for (int i = 1; i < arquivos.length; ++i) {
			info = csv.tokeniza(arquivos[i]);

			ListaMateria lista = new ListaMateria(); // cria o objeto
			lista.tokensToLista(info); // preenche
			//lista.imprimeLista(); // imprime
			/* TODO: checar se novo.csv é idêntico ao arquivo original */
			csv.escreve(info, "novo.csv"); // escreve no arquivo
		}
	}

	@Test
	public void testsalvamento() {// testsalvamento() throws Exception {
		final String arquivos = "exemplo_trabalho_TAP_Disciplinas_2019.csv";

		Csv csv = new Csv();
		String[][] tokens = csv.tokeniza(arquivos);

		ListaMateria lista = new ListaMateria(); // cria o objeto
		lista.tokensToLista(tokens); // preenche
		ListaPedidos pedidos = new ListaPedidos();
		
		for (int i = 0; i < 14; i++) {
			Materia materia = lista.listaGetAt(i);
			pedidos.inserir(materia);
		}
		FileSaveReader saida = new FileSaveReader();
		tokens = pedidos.listaToTokens(); // imprime
		/* TODO: checar se novo.csv é idêntico ao arquivo original */
		saida.escreveArquivo(arquivos, tokens, "saida.save"); // escreve no arquivo

	}

	@Test
	public void gera_ira() {// testsalvamento() throws Exception {
		final String arquivos = "exemplo_trabalho_TAP_historico.csv";

		String[][] tokens = new Csv().tokeniza(arquivos);

		Controle controle = new Controle();
		controle.getMat_aluno().tokensToLista(tokens); // preenche

		//System.out.println("O ira eh :" + controle.ira());
	}
	
	@Test
	public void testtabela() {
		final String arquivos = "exemplo_trabalho_TAP_Disciplinas_2019.csv";
		final String aluno = "exemplo_trabalho_TAP_historico.csv";

		Csv csv = new Csv();
		String[][] tokens = csv.tokeniza(arquivos);

		Controle c = new Controle();
		c.getLista_materia().tokensToLista(tokens);
	
		tokens = csv.tokeniza(aluno);
		c.getMat_aluno().tokensToLista(tokens);
		
		c.possiveisPedidos();
		//c.getPossiveis_escolhas();
		Vector<Vector<Materia>> tabela = c.tabelaMateria();
		for(int i = 0; i < tabela.size(); i++) {
			for(int j = 0; j < tabela.elementAt(i).size(); j++) {
				//System.out.println(tabela.elementAt(i).elementAt(j).toString());
			}
		}
	}
	
	@Test
	public void testcomparador() {
		final String arquivos = "exemplo_trabalho_TAP_Disciplinas_2019.csv";
		final String aluno = "exemplo_trabalho_TAP_historico.csv";
		
		Csv csv = new Csv();
		String[][] tokens = csv.tokeniza(arquivos);

		Controle c = new Controle();
		c.getLista_materia().tokensToLista(tokens);
	
		tokens = csv.tokeniza(aluno);
		c.getMat_aluno().tokensToLista(tokens);
		c.possiveisPedidos();
		//System.out.println("\n\n\n\n\n ALGO COMECA AQUI");
		//System.out.println("tamanho: "+ c.getPossiveis_escolhas().tamanhoLista());
		//c.getPossiveis_escolhas().imprimeLista();
		//System.out.println("\n\n\n\n\n ALGO TERMINA AQUI");
	}
	
	
	@Test
	public void testfaltantes() {
		final String arquivos = "exemplo_trabalho_TAP_Disciplinas_2019.csv";
		final String aluno = "exemplo_trabalho_TAP_historico.csv";
		
		Csv csv = new Csv();
		String[][] tokens = csv.tokeniza(arquivos);

		Controle c = new Controle();
		c.getLista_materia().tokensToLista(tokens);
	
		tokens = csv.tokeniza(aluno);
		c.getMat_aluno().tokensToLista(tokens);
		c.preencheFaltantes();
		System.out.println("\n\n\n\n\n ALGO COMECA AQUI");
		System.out.println("tamanho: "+ c.getFaltantes().tamanhoLista());
		c.getFaltantes().imprimeLista();
		System.out.println("\n\n\n\n\n ALGO TERMINA AQUI");
	}
	/*public static void main(String[] args) {
		final String arquivos = "exemplo_trabalho_TAP_Disciplinas_2019.csv";

		Csv csv = new Csv();
		String[][] tokens = csv.tokeniza(arquivos);

		ListaMateria lista = new ListaMateria();	 // cria o objeto
		lista.tokensToLista(tokens); 				 // preenche
		ListaPedidos pedidos = new ListaPedidos();
		
		for (int i = 0; i < 14; i++) {
			Materia materia = lista.listaGetAt(i);
			pedidos.inserir(materia);
		}
		FileSaveReader saida = new FileSaveReader();
		tokens = pedidos.listaToTokens(); // imprime
		/* TODO: checar se novo.csv é idêntico ao arquivo original 
		saida.escreveArquivo(arquivos, tokens, "saida.save"); // escreve no arquivo
	}*/
}
