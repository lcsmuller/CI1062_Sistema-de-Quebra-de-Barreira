package main;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaveReader {
	/** armazena nome do arquivo fonte */
	static private String nomeArquivoFonte = null;

	/**
	 * Devolve o nome do arquivo fonte
	 * 
	 * @return o nome do arquivo fonte
	 */
	static public String getFonte() {
		return nomeArquivoFonte;
	}
	
	static public void setFonte(String fonte){
		nomeArquivoFonte = fonte;
	}
	
	/**
	 * Wrapper de {@link main.Csv#leCsv(String)}. Realiza leitura e salva nome do
	 * arquivo lido.
	 * 
	 * @param arquivo arquivo CSV a ser lido
	 * @return dados do arquivos CSV separados em tokens
	 */
	static public String[][] leArquivo(String arquivo) {
		String[][] copiaCsv = null;

		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(arquivo));

			nomeArquivoFonte = fileReader.readLine();
			copiaCsv = Csv.tokenizaBufferedReader(fileReader);
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo de entrada:" + arquivo);
			e.printStackTrace();
		}

		return copiaCsv;
	}

	/**

	 * Wrapper de {@link main.Csv#escreveFileWriter(String[][], String)}.
	 * 		Realiza serialização e escrita no arquivo destino.
	 * 
	 * @param tokens conjunto de dados a serem serializados
	 */
	static public void escreveArquivo(String[][] tokens) {
		int i = nomeArquivoFonte.lastIndexOf(".");
		String arquivoDestino = nomeArquivoFonte.substring(0, i) + ".save";

		try {
			FileWriter fileWriter = new FileWriter(arquivoDestino);
			fileWriter.append(nomeArquivoFonte + "\n");

			Csv.escreveFileWriter(tokens, fileWriter);

			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Erro na escrita do arquivo do arquivo:" + arquivoDestino);
			e.printStackTrace();
		}
	}
}
