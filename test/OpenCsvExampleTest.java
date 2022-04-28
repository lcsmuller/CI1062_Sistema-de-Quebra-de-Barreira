package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.OpenCsvExample;
import main.ListaMateria;
import main.Materia;

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

	public static void main(String args[]) throws Exception {
		OpenCsvExample novo = new OpenCsvExample();
		String[][] info = null;
		try {
			info = novo.leCsv("exemplo_trabalho_TAP_Disciplinas_2019.csv");
		} catch (Exception e) {
			System.out.println("deu ruim");
		}	
		ListaMateria lista = new ListaMateria();
		Materia materia;
		for(int i = 3; i < 60; i++) {
			materia = lista.stringToMateria2019(info[i]);
			System.out.println("{" + materia.getCodigoCurso() 
			+" "+ materia.getCodigoMateria() 
			+" "+ materia.getHoras() 
			+" "+ materia.getNome() 
			+" "+ materia.getPeriodo() 
			+" "+ materia.getTipo() 
			+" "+ materia.getVersao() 
			+ "}");
		}
		novo.escreveCsv(info, "novo.csv");
	}
}	