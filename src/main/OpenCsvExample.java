package src.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class OpenCsvExample {
	
	//atualmente so pega um arquivoe imprime na tela, mas ja divide cada celula em uma variavel independente
	public String[][] leCsv(String arquivo) throws Exception {
		//try{
		BufferedReader csvReader = new BufferedReader(new FileReader(arquivo)); //colocar nome do arquivo que sere passado
		String[][] data = new String[2000][1];
		int i = 0;
		String row;
		while ((row = csvReader.readLine()) != null) {
			String[] linha = row.split(";"); // mudar ; � o separador de celular do csv
			data[i] = linha;
			i++;
		}
		csvReader.close();
		data = Arrays.copyOf(data,i);
		//}catch(){}                fazer bloco catch com excessoes de IO
		return data;
	}
	
	public void escreveCsv(String[][] entrada, String arquivo) throws Exception{ //fazer tratamento de excessoes
		FileWriter csvWriter = new FileWriter(arquivo);
		for (int i = 0; i < entrada.length; i++) {
			for(int j = 0; j < entrada[i].length; j++)
				csvWriter.append(entrada[i][j] + ";");
			csvWriter.append("\n");
		}
		csvWriter.close();
	}
}