package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.*;

class CsvTest {
	//@Test
	void testLeLinhaCsv() throws Exception {
		final String CSVTeste = "GRR1234;Sergio;BCC;2011;2017;70";
		String[] linha = new Csv().tokenizaLinhaCsv(CSVTeste, ";");

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

	//@Test
	void testLeArquivoCsv() throws Exception {
		final String[] arquivos = { "exemplo_trabalho_TAP_historico.csv",
				/*
				 * XXX: os arquivos a seguir possuem campos em ordem diferente, então
				 * matrizLista não é capaz de converter os valores
				 */
				"exemplo_trabalho_TAP_Disciplinas_2011.csv", "exemplo_trabalho_TAP_Disciplinas_2019.csv" };
		Csv csv = new Csv();
		String[][] info = csv.tokenizaCsv(arquivos[0]);
		MateriaAlunoLista matAluno = new MateriaAlunoLista();
		matAluno.tokensToLista(info);
		matAluno.imprimeLista();

		/* TODO: checar se novo.csv é idêntico ao arquivo original */
		csv.escreveCsv(info, "novo.csv"); // escreve no arquivo

		for (int i = 1; i < arquivos.length; ++i) {
			info = csv.tokenizaCsv(arquivos[i]);

			ListaMateria lista = new ListaMateria(); // cria o objeto
			lista.tokensToLista(info); // preenche
			lista.imprimeLista(); // imprime
			/* TODO: checar se novo.csv é idêntico ao arquivo original */
			csv.escreveCsv(info, "novo.csv"); // escreve no arquivo
		}
	}

	//@Test
	public void testsalvamento() {// testsalvamento() throws Exception {
		final String arquivos = "exemplo_trabalho_TAP_Disciplinas_2019.csv";

		Csv csv = new Csv();
		String[][] tokens = csv.tokenizaCsv(arquivos);

		ListaMateria lista = new ListaMateria(); // cria o objeto
		lista.tokensToLista(tokens); // preenche
		ListaPedidos pedidos = new ListaPedidos();
		
		for (int i = 0; i < 14; i++) {
			Materia materia = lista.listaGetAt(i);
			pedidos.inserir(materia);
		}
		FileSaveReader saida = new FileSaveReader();
		tokens = pedidos.toTokens(); // imprime
		/* TODO: checar se novo.csv é idêntico ao arquivo original */
		saida.escreveArquivo(arquivos, tokens, "saida.save"); // escreve no arquivo

	}

	//@Test
	public void gera_ira() {// testsalvamento() throws Exception {
		final String arquivos = "exemplo_trabalho_TAP_historico.csv";

		String[][] tokens = new Csv().tokenizaCsv(arquivos);

		Controle controle = new Controle();
		controle.getMat_aluno().tokensToLista(tokens); // preenche

		System.out.println("O ira eh :" + controle.ira());
	}
	
	public static void main(String[] args) {
		final String arquivos = "exemplo_trabalho_TAP_Disciplinas_2019.csv";

		Csv csv = new Csv();
		String[][] tokens = csv.tokenizaCsv(arquivos);

		ListaMateria lista = new ListaMateria();	 // cria o objeto
		lista.tokensToLista(tokens); 				 // preenche
		ListaPedidos pedidos = new ListaPedidos();
		
		for (int i = 0; i < 14; i++) {
			Materia materia = lista.listaGetAt(i);
			pedidos.inserir(materia);
		}
		FileSaveReader saida = new FileSaveReader();
		tokens = pedidos.toTokens(); // imprime
		/* TODO: checar se novo.csv é idêntico ao arquivo original */
		saida.escreveArquivo(arquivos, tokens, "saida.save"); // escreve no arquivo
	}
}
