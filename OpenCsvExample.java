package PARADINHAS;

import java.io.BufferedReader;
import java.io.FileReader;

public class OpenCsvExample {

	private String row = null; //talves possa ser declarado na propria função
	
	//atualmente so pega um arquivoe imprime na tela, mas ja divide cada celula em uma variavel independente
	public void leCsv() throws Exception {
		//try{
		BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\guipa\\Downloads\\JF_Secao_25_Ago_2020.csv")); //colocar nome do arquivo que sere passado
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(";"); // mudar ; é o separador de celular do csv
			for (int i = 0; i < data.length; i++) {
				System.out.println(data[i] + " ");
			}
		}
		csvReader.close();
		//}catch(){}                fazer bloco catch com excessoes de IO
	}
	//desoceomente para testar so esse arquivo
	/*public static void main(String args[]) throws Exception{
		OpenCsvExample novo = new OpenCsvExample();
		novo.leCsv();
	}*/
    

}