package main;

import java.io.BufferedReader;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class OpenCsvExample {
    // XXX: chuncho, gambiarra, artifício técnico, engenharia de emergência, decisão de projeto (mas funciona)
	private String[][] data = new String[2000][1];
	
	//atualmente so pega um arquivo e imprime na tela, mas ja divide cada celula em uma variavel independente
	public String[] leLinhaCsv(String linhaCsv, String separador) {
		String[] linha = null;
		if (linhaCsv != null)
			linha = linhaCsv.split(separador);
		return linha;
	}

	public String[][] leCsv(String arquivo){
		int i = 0;
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(arquivo)); //colocar nome do arquivo que sere passado
			String row;

			while ((row = csvReader.readLine()) != null) {
				data[i] = leLinhaCsv(row, ";");
				i++;
			}
			csvReader.close();
		} catch(IOException erro){
			System.out.println("Erro na leitura do arquivo de entrada:" + arquivo);
		}
		return Arrays.copyOf(data, i);
	}
	
	public void escreveCsv(String[][] entrada, String arquivo){ //fazer tratamento de excessoes
		try {
			FileWriter csvWriter = new FileWriter(arquivo);
			for (int i = 0; i < entrada.length; i++) {
				for(int j = 0; j < entrada[i].length; j++)
					csvWriter.append(entrada[i][j] + ";");
				csvWriter.append("\n");
			}
			csvWriter.close();
		}catch(IOException erro) {
			System.out.println("erro na escrita do arquivo do arquivo:" + arquivo);
		}
	}
}
