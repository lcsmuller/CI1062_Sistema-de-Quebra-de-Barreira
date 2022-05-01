package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.*;

class OpenCsvExampleTest {
	@Test
	void testLeLinhaCsv() throws Exception {
		final String CSVTeste = "GRR1234;Sergio;BCC;2011;2017;70";
		String[] linha = new OpenCsvExample().leLinhaCsv(CSVTeste, ";");

		assertNotNull(linha);
		assertEquals("GRR1234", linha[0]);
		assertEquals("Sergio", linha[1]);
		assertEquals("BCC", linha[2]);
		assertEquals("2011", linha[3]);
		assertEquals("2017", linha[4]);
		assertEquals("70", linha[5]);
	}

	@Test
	void testEscreveArquivoCsv() throws Exception {
		fail("não implementado");
	}
	
	@Test
	void testLeArquivoCsv() throws Exception {
		final String[] arquivos = {
				"exemplo_trabalho_TAP_historico.csv", 
				/* XXX: os arquivos a seguir possuem campos em ordem diferente,
				 * então matrizLista não é capaz de converter os valores */
				"exemplo_trabalho_TAP_Disciplinas_2011.csv",
				"exemplo_trabalho_TAP_Disciplinas_2019.csv"
		};
		OpenCsvExample csv = new OpenCsvExample();
		
		for (int i = 0; i < arquivos.length; ++i) {
			String[][] info = csv.leCsv(arquivos[i]);

			//ListaMateria lista = new ListaMateria();	// cria o objeto 
			//lista.matrizToLista(info);				// preenche 
			//lista.imprime();							// imprime
			//novo.escreveCsv(info, "novo.csv");		// escreve no arquivo

			MateriaAluno matAluno = new MateriaAluno();
			matAluno.matrizToLista(info);
			matAluno.imprimeLista();
			
			/* TODO: checar se novo.csv é idêntico ao arquivo original */
			csv.escreve(info, "novo.csv"); // escreve no arquivo
		}
	}
	
	@Test
	void testesalvamento() {
		
	}
}
