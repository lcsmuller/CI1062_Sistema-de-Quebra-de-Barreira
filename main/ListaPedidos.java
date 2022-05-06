package main;

/** Lista de matérias que podem ser pedidas pelo aluno. */
public class ListaPedidos extends Tokenizador<Materia> {

	/**
	 * Transforma tokens de linha CSV obtidos por
	 *		{@link main.Csv#tokeniza(String)}.
	 *
	 * @param tokensLinha os tokens a serem serializados
	 * @return resultado da transformação em AlunoMateria
	 */
	public Materia fromLinhaTokens(String[] tokensLinha){
		Materia novaMateria = new Materia();
		
		novaMateria.setCodigoCurso(tokensLinha[0]);
		novaMateria.setVersao(Integer.parseInt(tokensLinha[6]));
		novaMateria.setCodigoMateria(tokensLinha[1]);
		novaMateria.setNome(tokensLinha[3]);
		try {
			novaMateria.setPeriodo(Integer.parseInt(tokensLinha[4]));
		} catch (Exception erro) {
			novaMateria.setPeriodo(0);
		}
		novaMateria.setTipo(tokensLinha[5]);
		novaMateria.setHoras(Integer.parseInt(tokensLinha[2]));

		return novaMateria;
		
	}

	/**
	 * Insere novo elemento na lista.
	 *
	 * @param materia elemento a ser inserido
	 */
	@Override
	public void inserir(Materia materia) {
		boolean existeMateria = false;
		
		for (int i = 0; i < this.tamanhoLista(); i++){
			if (materia.getNome().equals(this.listaGetAt(i).getNome())) {
				existeMateria = true;
			}
		
		}

		if (!existeMateria)
			this.lista.add(materia);
	}

	/**
	 * Transforma tokens de linha CSV obtidos por {@link main.Csv#tokeniza(String)}.
	 *
	 * @param tokens os tokens a serem decodificados
	 */
	@Override
	public void tokensToLista(String[][] tokens) {
   		for(int i = 0; i < tokens.length; i++) {
   			Materia materia = this.fromLinhaTokens(tokens[i]);
    		this.inserir(materia);
    	}
	}
	
	/** 
	 * Procura matéria a partir de seu nome fornecido.
	 *
	 * @param nomeMateria nome da matéria
	 * @return retorna índice em que a matéria se encontra na lista, -1 em caso de falha
	 */
	public int procurarMateriaNome(String nomeMateria) {
		for (int i = 0; i < this.lista.size(); i++) {
			String nome = this.listaGetAt(i).getNome();
			if (nome.equals(nomeMateria))
				return i;
		}
		return -1;
	}
	
}
