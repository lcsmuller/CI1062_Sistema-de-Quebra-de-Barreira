package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/** Realiza a tokenização de, e decodificação em CSV. */
public class Csv {
	/** Buffer a ser utilizado no parsing do CSV */
	protected static String[][] tokens = new String[2000][16];

	/**
	 * Divide os elementos da linha a partir de seu separador.
	 * 
	 * @param linhaCsv  linha contendo elementos CSV
	 * @param separador caractere separador do CSV
	 * @return elementos da linha separados
	 */
	public static String[] tokenizaLinha(String linhaCsv, String separador) {
		String[] linha = null;
		if (linhaCsv != null)
			linha = linhaCsv.split(separador);
		return linha;
	}

	/**
	 * Separa células CSV em tokens individuais.
	 * 
	 * @param csvReader arquivo CSV a ter seus dados extraídos
	 * @return dados extraídos
	 * @throws IOException
	 */
	public static String[][] tokenizaBufferedReader(BufferedReader csvReader) throws IOException {
		int i = 0;
		String row;

		while ((row = csvReader.readLine()) != null) {
			tokens[i] = tokenizaLinha(row, ";");
			i++;
		}
		return Arrays.copyOf(tokens, i);
	}

	/**
	 * Separa células CSV em tokens individuais.
	 * @note Wrapper de tokenizaCsvBufferedReader()
	 * 
	 * @param arquivo arquivo CSV a ter seus dados extraÃ­dos
	 * @return dados do arquivo CSV separados em tokens
	 * @throws IOException
	 */
	public static String[][] tokeniza(String arquivo) {
		String[][] copiaData = null;

		try {
			int i = 0;
			String row;
			BufferedReader csvReader = new BufferedReader(new FileReader(arquivo));

			while ((row = csvReader.readLine()) != null) {
				tokens[i] = tokenizaLinha(row, ";");
				i++;
			}
			copiaData = Arrays.copyOf(tokens, i);
			csvReader.close();
		} catch (IOException e) {
			System.out.println("Não foi possível leitura em '" + arquivo + "'");
			e.printStackTrace();
		}
		return copiaData;
	}

	/**
	 * Realiza serialização de de dados String para a sua representação em formato
	 * CSV.
	 * 
	 * @param entrada   o conjunto de dados a serem serializados
	 * @param csvWriter o arquivo a receber o output CSV
	 * @throws IOException
	 */
	public static void escreveFileWriter(String[][] entrada, FileWriter csvWriter) throws IOException {
		for (int i = 0; i < entrada.length; i++) {
			for (int j = 0; j < entrada[i].length; j++)
				csvWriter.append(entrada[i][j] + ";");
			csvWriter.append("\n");
		}
	}

	/**
	 * Realiza serialização de de dados String para a sua representação em formato
	 * CSV.
	 * 
	 * @note Wrapper de escreveCsvFileWriter()
	 * 
	 * @param entrada o conjunto de dados a serem serializados
	 * @param arquivo o arquivo a receber o output CSV
	 */
	public static void escreve(String[][] entrada, String arquivo) {
		try {
			FileWriter csvWriter = new FileWriter(arquivo);
			escreveFileWriter(entrada, csvWriter);
			csvWriter.close();
		} catch (IOException e) {
			System.out.println("Não foi possÃ­vel escrever em '" + arquivo + "'");
			e.printStackTrace();
		}
	}
}