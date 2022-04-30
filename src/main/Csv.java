package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Realiza a tokenização e serialização CSV.
 */
public class Csv {
	/** Buffer a ser utilizado no parsing do CSV */
	protected String[][] data = new String[2000][1];
	
	/**
	 * Divide os elementos da linha a partir de seu separador.
	 * 
	 * @param linhaCsv linha contendo elementos CSV
	 * @param separador caractere separador do CSV
	 * @return elementos da linha separados
	 */
	public String[] leLinhaCsv(String linhaCsv, String separador) {
		String[] linha = null;
		if (linhaCsv != null)
			linha = linhaCsv.split(separador);
		return linha;
	}

	/**
	 * Divide cada célula do CSV em variáveis independentes (tokenização).
	 * @todo atualmente só pega um arquivo e imprime na tela, 
	 * 
	 * @param csvReader arquivo CSV a ter seus dados extraídos
	 * @return dados extraídos
	 * @throws IOException
	 */
	public String[][] leCsvBufferedReader(BufferedReader csvReader) throws IOException {
		int i = 0;
        String row;

        while ((row = csvReader.readLine()) != null) {
            data[i] = leLinhaCsv(row, ";");
            i++;
        }
		return Arrays.copyOf(data, i);
	}

	/**
	 * Divide cada célula do CSV em variáveis independentes (tokenização).
	 * @todo atualmente só pega um arquivo e imprime na tela, 
	 * @note Wrapper de leCsv()
	 * 
	 * @param arquivo arquivo CSV a ter seus dados extraídos
	 * @return dados do arquivo CSV separados em tokens
	 * @throws IOException
	 */
	public String[][] leCsv(String arquivo) {
		String[][] copiaData = null;

		try {
			int i = 0;
			String row;
			BufferedReader csvReader = new BufferedReader(new FileReader(arquivo));

			while ((row = csvReader.readLine()) != null) {
				data[i] = leLinhaCsv(row, ";");
				i++;
			}
			copiaData = Arrays.copyOf(data, i);
		} catch (IOException e) {
			System.out.println("Não foi possível leitura em '" + arquivo + "'");
			e.printStackTrace();
		}
		return copiaData;
	}
	
	/**
	 * Realiza serialização de de dados String para a sua representação em formato CSV.
	 * 
	 * @param entrada o conjunto de dados a serem serializados
	 * @param csvWriter o arquivo a receber o output CSV
	 * @throws IOException
	 */
	public void escreveCsvFileWriter(String[][] entrada, FileWriter csvWriter) throws IOException {
        for (int i = 0; i < entrada.length; i++) {
            for(int j = 0; j < entrada[i].length; j++)
                csvWriter.append(entrada[i][j] + ";");
            csvWriter.append("\n");
        }
	}

	/**
	 * Realiza serialização de de dados String para a sua representação em formato CSV.
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
			System.out.println("Não foi possível escrever em '" + arquivo + "'");
			e.printStackTrace();
		}
	}
}