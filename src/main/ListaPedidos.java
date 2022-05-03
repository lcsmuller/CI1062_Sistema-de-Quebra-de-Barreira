package main;

/** Lista de matérias que podem ser pedidas pelo aluno (não cursadas). */
public class ListaPedidos extends Tokenizador<Materia> {

	/**
	 * Transforma tokens de linha CSV obtidos por
	 *		{@link main.Csv#tokeniza(String)}.
	 *
	 * @param tokensLinha os tokens a serem serializados
	 * @return resultado da transformação em AlunoMateria
	 */
	public AlunoMateria fromLinhaTokens(String[] tokensLinha){
		AlunoMateria nova = new AlunoMateria();

  		nova.setCodigoCurso(tokensLinha[0]);
  		nova.setVersao(Integer.parseInt(tokensLinha[1]));
  		nova.setCodigoMateria(tokensLinha[2]);
  		nova.setNome(tokensLinha[3]);
		nova.setPeriodo(0);
  		nova.setTipo(tokensLinha[4]);
  		nova.setHoras(Integer.parseInt(tokensLinha[5]));
  		nova.setNota(Integer.parseInt(tokensLinha[6]));
  		try {
  			nova.setFrequencia(Integer.parseInt(tokensLinha[7]));
  		} catch(Exception e) {
  			nova.setFrequencia(0);
  		}
  		nova.setSituacao(tokensLinha[15]);

  		return nova;
	}

	@Override
	public void inserir (Materia mat){
		boolean achou = false;
		for (int i = 0; i < this.tamanhoLista(); i++){
			if (mat.getNome().equals(this.listaGetAt(i).getNome())) {
				achou = true;
			}
		
		}
		if (! achou)
			this.lista.add(mat);
	}

}
