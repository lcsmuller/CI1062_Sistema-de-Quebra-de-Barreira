package main;

import java.io.FileWriter;
import java.io.IOException;

public class FileSend {
	
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
	
	public static void montaPedido(String nomeAluno,String grrAluno, String nomeCurso,String comentario,  Controle controle) {
		int i = nomeArquivoFonte.lastIndexOf(".");
		String arquivoDestino = nomeArquivoFonte.substring(0, i) + ".txt";

		try {
			try (FileWriter fileWriter = new FileWriter(arquivoDestino)) {
				fileWriter.append("PEDIDO DE QUEBRA DE REQUISITOS / BARREIRA \r\n");
				fileWriter.append("Aluno: [" + nomeAluno + "] || GRR: [" + grrAluno+ "]\n");
				fileWriter.append("Pertencente ao curso de: ["+ nomeCurso +"]\n\n");
				
				fileWriter.append("MATÉRIAS RESTANTES PRÉ BARREIRA: " + controle.getListaFaltantes().tamanhoLista() + "\n");
				controle.preencheFaltantes();
				for (i = 0 ; i < controle.getListaFaltantes().tamanhoLista() ; i++){
					fileWriter.append("Materia ("+ i +"): " + controle.getListaFaltantes().listaGetAt(i).getNome() + "\n");
				}
				fileWriter.append("DE ACORDO COM O DESEMPENHO DO ULTIMO SEMESTRE: "+ controle.getDesempenho() + "\n");
				if (controle.ira() > 0.8)
					fileWriter.append("recomenda-se a aprovação de todas as materias " + "\n");
				else {
					if (controle.getDesempenho() < 0.33)
						fileWriter.append("recomenda-se a aprovação de 3 materias " + "\n");
					else if (controle.getDesempenho() < 0.66)
						fileWriter.append("recomenda-se a aprovação de 4 materias " + "\n");
					else 
						fileWriter.append("recomenda-se a aprovação de 5 materias " + "\n");
				}
				
				fileWriter.append("ATUALMENTE SOLICITANDO: " + controle.getListaPedidos().tamanhoLista()+ "\n");
				fileWriter.append("SENDO DESSAS: " + (controle.getListaPedidos().tamanhoLista() - controle.getOffsetBonus()) + " MATERIA(S) QUE NECESSITA(M) DE QUEBRA DE BARREIRA / REQUISITO \n");
				fileWriter.append("MATERIAS QUE NECESSITAM DE QUEBRA DE BARREIRA /REQUISITO:\n");
				int j = 1;
				for (i = 0 ; i < controle.getListaPedidos().tamanhoLista() ; i++){
					if (controle.getListaPedidos().listaGetAt(i).getPeriodo() >= 4) {
						fileWriter.append("Materia ("+ j +"): " + controle.getListaPedidos().listaGetAt(i).getNome() +"\n");
						j++;
					}
				}
				fileWriter.append("\n");
				fileWriter.append("COMENTARIO: " + comentario + "\n");
				long millis=System.currentTimeMillis();  
				java.sql.Date date = new java.sql.Date(millis);         
				fileWriter.append("DATA DO PEDIDO: " + date + "\n");
				
				
				
				fileWriter.close();
			}
		} catch (IOException e) {
			System.out.println("Erro na escrita do arquivo do arquivo:" + arquivoDestino);
			e.printStackTrace();
			
		}
	}
	
}
