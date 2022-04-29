package test;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test;

import main.ListaMateria;
import main.Materia;
import main.OpenCsvExample;
import main.Materia;
import main.ListaMateria;
import main.MateriaAluno;

class OpenCsvExampleTest {
/* criar função no OpenCsvExample.java para ler CSV a partir de um string, e escrever em um buffer
	private final String CSVTeste = "GRR1234;Sergio;BCC;2011;2017;70\nGRR4321;Maria;MED;2012;2018;110";
	OpenCsvExample novo = new OpenCsvExample();
	String[][] dados = novo.leCsv(CSVTeste);

	@Test
	void testLeCsv() throws Exception {
		assertNotNull(dados);

		assertEquals("GRR1234", dados[0][0]);
		assertEquals("Sergio", dados[0][1]);
		assertEquals("BCC", dados[0][2]);
		assertEquals("2011", dados[0][3]);
		assertEquals("2017", dados[0][4]);
		assertEquals("70", dados[0][5]);
		assertEquals("GRR4321", dados[0][0]);
		assertEquals("Maria", dados[0][1]);
		assertEquals("MED", dados[0][2]);
		assertEquals("2012", dados[0][3]);
		assertEquals("2018", dados[0][4]);
		assertEquals("110", dados[0][5]);
	}

	@Test
	void testEscreveCsv() throws Exception {
		novo.escreveCsv(dados, "novo.csv");
	}
*/
	public static void main(String args[]) throws Exception {
		OpenCsvExample novo = new OpenCsvExample();
		String[][] info = null;
		try {
			info = novo.leCsv("exemplo_trabalho_TAP_historico.csv");
		} catch (Exception e) {
			System.out.println("deu ruim");
		}	
		//ListaMateria lista = new ListaMateria();	//cria o objeto 
		//lista.matrizToLista(info);					//preenche 
		//lista.imprime();							//imprime
		//novo.escreveCsv(info, "novo.csv");			//escreveno arquivo
		MateriaAluno coisa = new MateriaAluno();
		coisa.matrizToLista(info);
		coisa.imprimeLista();
		novo.escreveCsv(info, "novo.csv");
	}
}
