package main;

import java.io.BufferedReader;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileSaveReader {
    // XXX: chuncho, gambiarra, artifício técnico, engenharia de emergência, decisão de projeto (mas funciona)
	private String[][] data = new String[2000][1];
	private String arquivofonte = null;
	
	public String getFonte() {
		return this.arquivofonte;
	}
	
	public String[][] getData(){
		return this.data;
	}
	
	//atualmente so pega um arquivo e imprime na tela, mas ja divide cada celula em uma variavel independente
	public String[] leLinhaFile(String linhaCsv, String separador) {
		String[] linha = null;
		if (linhaCsv != null)
			linha = linhaCsv.split(separador);
		return linha;
	}
	
	public String[][] leArquivo(String arquivo){
		int i = 0;
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(arquivo)); //colocar nome do arquivo que ser passado
			String row;
			arquivofonte = fileReader.readLine();
			while ((row = fileReader.readLine()) != null) {
				data[i] = leLinhaFile(row, ";");
				i++;
			}
			fileReader.close();
		} catch(IOException erro){
			System.out.println("Erro na leitura do arquivo de entrada:" + arquivo);
		}
		return Arrays.copyOf(data, i);
	}
	
	public void escreveArquivo(String fonte, String[][] entrada, String arquivo){ //fazer tratamento de excessoes
		try {
			FileWriter fileWriter = new FileWriter(arquivo);
			fileWriter.append(fonte + "\n");
			for (int i = 0; i < entrada.length; i++) {
				for(int j = 0; j < entrada[i].length; j++)
					fileWriter.append(entrada[i][j] + ";");
				fileWriter.append("\n");
			}
			fileWriter.close();
		}catch(IOException erro) {
			System.out.println("erro na escrita do arquivo do arquivo:" + arquivo);
		}
	}

}
