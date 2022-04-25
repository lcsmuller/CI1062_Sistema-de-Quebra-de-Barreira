package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OpenCsvExampleTest {
	OpenCsvExample novo = new OpenCsvExample();
	String[][] dados = null;

	@Test
	void testLeCsv() throws Exception {
		dados = novo.leCsv("exemplo_trabalho_TAP_historico.csv");
		assertNotNull(dados);
		for (int i = 0; i < dados.length; i++) {
			for (int j = 0; j < dados[i].length; j++){
				System.out.print(dados[i][j] + " ");
			}
			System.out.println();
		}
	}

	@Test
	void testEscreveCsv() throws Exception {
		novo.escreveCsv(dados, "novo.csv");
	}
}
