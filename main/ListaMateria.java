package main;

/** Lista de matérias */
public class ListaMateria extends Tokenizador<Materia> {

	/** 
	 * Converte linha CSV para { @link main.Materia }.
	 *
	 * @param tokensLinha linha contendo os tokens a serem convertidos em 
	 *		{ @link main.Materia }
	 * @return retorna { @link main.Materia }
	 */
	public Materia fromLinhaTokens(String[] tokensLinha) {
		Materia novaMateria = new Materia();

		novaMateria.setCodigoCurso(tokensLinha[0]);
		novaMateria.setVersao(Integer.parseInt(tokensLinha[1]));
		novaMateria.setCodigoMateria(tokensLinha[3]);
		novaMateria.setNome(tokensLinha[5]);
		try {
			novaMateria.setPeriodo(Integer.parseInt(tokensLinha[6]));
		} catch (Exception erro) {
			novaMateria.setPeriodo(0);
		}
		novaMateria.setTipo(tokensLinha[8]);
		novaMateria.setHoras(Integer.parseInt(tokensLinha[9]));
		
		return novaMateria;
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

	/**
	 * Decodifica tokens em lista.
	 *
	 * @param tokens tokens a serem decodificados
	 */
	@Override
	public void tokensToLista(String[][] tokens) {
		Materia materiaAnterior = this.fromLinhaTokens(tokens[2]);

   		for (int i = 3; i < tokens.length; i++) {
   			Materia materia = this.fromLinhaTokens(tokens[i]);
   			if (!materia.getNome().equals(materiaAnterior.getNome()))
   				this.inserir(materia);
   			materiaAnterior = materia;
    	}
	}

}
