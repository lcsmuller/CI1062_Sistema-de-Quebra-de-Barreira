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
	public Materia fromLinhaTokens(String[] tokensLinha){
		Materia nova = new Materia();
		
		nova.setCodigoCurso(tokensLinha[0]);
		nova.setVersao(Integer.parseInt(tokensLinha[6]));
		nova.setCodigoMateria(tokensLinha[1]);
		nova.setNome(tokensLinha[3]);
		try {
			nova.setPeriodo(Integer.parseInt(tokensLinha[4]));
		} catch (Exception erro) {
			nova.setPeriodo(0);
		}
		nova.setTipo(tokensLinha[5]);
		nova.setHoras(Integer.parseInt(tokensLinha[2]));
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
