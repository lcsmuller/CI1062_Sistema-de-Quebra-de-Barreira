package main;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaveReader extends Csv {
	/** armazena nome do arquivo fonte */
	private String arquivofonte = null;

	/**
	 * Devolve o nome do arquivo fonte
	 * 
	 * @return o nome do arquivo fonte
	 */
	public String getFonte() {
		return this.arquivofonte;
	}

	/**
	 * Wrapper de {@link main.Csv#leCsv(String)}. Realiza leitura e salva nome do
	 * arquivo lido.
	 * 
	 * @param arquivo arquivo CSV a ser lido
	 * @return dados do arquivos CSV separados em tokens
	 */
	public String[][] leArquivo(String arquivo) {
		String[][] copiaCsv = null;

		try {
			// TODO: colocar nome do arquivo a ser passado
			BufferedReader fileReader = new BufferedReader(new FileReader(arquivo));

			this.arquivofonte = fileReader.readLine();
			copiaCsv = this.leCsvBufferedReader(fileReader);
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo de entrada:" + arquivo);
			e.printStackTrace();
		}

		return copiaCsv;
	}

	/**
	 * Wrapper de {@link main.Csv#escreveCsv(String[][], String)}. Realiza
	 * serialização e escrita no arquivo destino.
	 * 
	 * @param fonte   arquivo original do CSV
	 * @param o       conjunto de dados a serem serializados
	 * @param arquivo o arquivo a receber o output CSV
	 */
	public void escreveArquivo(String fonte, String[][] entrada, String arquivo) {
		try {
			FileWriter fileWriter = new FileWriter(arquivo);
			fileWriter.append(fonte + "\n");

			this.escreveCsvFileWriter(entrada, fileWriter);

			fileWriter.close();
		} catch (IOException e) {
			System.out.println("erro na escrita do arquivo do arquivo:" + arquivo);
			e.printStackTrace();
		}
	}
}
