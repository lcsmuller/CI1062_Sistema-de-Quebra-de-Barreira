package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ArquivoTexto {
	
	public String[][] leArquivo(String arquivo){
		String [][] data = null;
		try{
			BufferedReader fileReader = new BufferedReader(new FileReader(arquivo)); //colocar nome do arquivo que sere passado
			data = new String[2000][1]; //chuncho, gambiarra, artifico tecnico, engenharia de emergencia, decisao de projeto (mas funciona)
			int i = 1;
			String row;
			data[0][0] = fileReader.readLine();
			while ((row = fileReader.readLine()) != null) {
				data[i] = row.split(";"); // mudar ; o separador de celulas do csv 
				i++;
			}
			fileReader.close();
			data = Arrays.copyOf(data,i);	
		}catch(IOException erro){
			System.out.println("erro na leitura do arquivo de entrada:" + arquivo);
		}                
		return data;
	}
	
	public void escreveArquivo(String historico, String[][] entrada, String arquivo){ //fazer tratamento de excessoes
		try {
			FileWriter fileWriter = new FileWriter(arquivo);
			fileWriter.append(historico + "\n");
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
