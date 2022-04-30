package main;

import java.util.Arrays;

public class ListaPedidos extends Tokenizador<Materia> {
	
	public AlunoMateria fromLinhaTokens(String[] entrada){
		AlunoMateria nova = new AlunoMateria();

  		nova.setCodigoCurso(entrada[0]);
  		nova.setVersao(Integer.parseInt(entrada[1]));
  		nova.setCodigoMateria(entrada[2]);
  		nova.setNome(entrada[3]);
		nova.setPeriodo(0);
  		nova.setTipo(entrada[4]);
  		nova.setHoras(Integer.parseInt(entrada[5]));
  		nova.setNota(Integer.parseInt(entrada[6]));
  		try {
  			nova.setFrequencia(Integer.parseInt(entrada[7]));
  		}catch(Exception erro){
  			nova.setFrequencia(0);
  		}
  		nova.setSituacao(entrada[15]);

  		return nova;
	}
	
	public String[][] toTokens(){
		String[][] data = new String[2000][1];
		int i;
		for(i = 0; i < this.tamanhoLista(); ++i) {									
			data[i] = this.listaGetAt(i).imprimivel().split(",");	//get at retorno o elemento na posicao i , imprimivel torna o objeto Materia imprimivel com o println 
		}
		return Arrays.copyOf(data, i);
	}

}
