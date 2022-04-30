package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Realiza a tokeniza√ß√£o e serializa√ß√£o CSV.
 */
public class Csv {
	/** Buffer a ser utilizado no parsing do CSV */
	protected String[][] tokens = new String[2000][1];

	/**
	 * Divide os elementos da linha a partir de seu separador.
	 * 
	 * @param linhaCsv  linha contendo elementos CSV
	 * @param separador caractere separador do CSV
	 * @return elementos da linha separados
	 */
	public String[] tokenizaLinhaCsv(String linhaCsv, String separador) {
		String[] linha = null;
		if (linhaCsv != null)
			linha = linhaCsv.split(separador);
		return linha;
	}

	/**
	 * Separa cÈlulas CSV em tokens individuais.
	 * @todo atualmente s√≥ pega um arquivo e imprime na tela,
	 * 
	 * @param csvReader arquivo CSV a ter seus dados extraÌdos
	 * @return dados extraÌdos
	 * @throws IOException
	 */
	public String[][] tokenizaCsvBufferedReader(BufferedReader csvReader) throws IOException {
		int i = 0;
		String row;

		while ((row = csvReader.readLine()) != null) {
			tokens[i] = tokenizaLinhaCsv(row, ";");
			i++;
		}
		return Arrays.copyOf(tokens, i);
	}

	/**
	 * Separa cÈlulas CSV em tokens individuais.
	 * @note Wrapper de tokenizaCsvBufferedReader()
	 * 
	 * @param arquivo arquivo CSV a ter seus dados extra√≠dos
	 * @return dados do arquivo CSV separados em tokens
	 * @throws IOException
	 */
	public String[][] tokenizaCsv(String arquivo) {
		String[][] copiaData = null;

		try {
			int i = 0;
			String row;
			BufferedReader csvReader = new BufferedReader(new FileReader(arquivo));

			while ((row = csvReader.readLine()) != null) {
				tokens[i] = tokenizaLinhaCsv(row, ";");
				i++;
			}
			copiaData = Arrays.copyOf(tokens, i);
			csvReader.close();
		} catch (IOException e) {
			System.out.println("N√£o foi poss√≠vel leitura em '" + arquivo + "'");
			e.printStackTrace();
		}
		return copiaData;
	}

	/**
	 * Realiza serializa√ß√£o de de dados String para a sua representa√ß√£o em formato
	 * CSV.
	 * 
	 * @param entrada   o conjunto de dados a serem serializados
	 * @param csvWriter o arquivo a receber o output CSV
	 * @throws IOException
	 */
	public void escreveCsvFileWriter(String[][] entrada, FileWriter csvWriter) throws IOException {
		for (int i = 0; i < entrada.length; i++) {
			for (int j = 0; j < entrada[i].length; j++)
				csvWriter.append(entrada[i][j] + ";");
			csvWriter.append("\n");
		}
	}

	/**
	 * Realiza serializaÁ„o de de dados String para a sua representaÁ„o em formato
	 * CSV.
	 * 
	 * @note Wrapper de escreveCsvFileWriter()
	 * 
	 * @param entrada o conjunto de dados a serem serializados
	 * @param arquivo o arquivo a receber o output CSV
	 */
	public void escreveCsv(String[][] entrada, String arquivo) {
		try {
			FileWriter csvWriter = new FileWriter(arquivo);
			this.escreveCsvFileWriter(entrada, csvWriter);
			csvWriter.close();
		} catch (IOException e) {
			System.out.println("N√£o foi poss√≠vel escrever em '" + arquivo + "'");
			e.printStackTrace();
		}
	}
}