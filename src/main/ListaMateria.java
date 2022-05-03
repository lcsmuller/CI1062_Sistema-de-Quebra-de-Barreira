package main;
import java.util.Vector;

/** Lista de matérias sendo cursadas pelo aluno */
public class ListaMateria extends Tokenizador<Materia> {

	/** 
	 * Converte linha CSV para { @link main.Materia }.
	 *
	 * @param tokensLinha linha contendo os tokens a serem convertidos em 
	 *		{ @link main.Materia }
	 * @return retorna { @link main.Materia }
	 */
	public Materia fromLinhaTokens(String[] tokensLinha) {
		Materia nova = new Materia();

		nova.setCodigoCurso(tokensLinha[0]);
		nova.setVersao(Integer.parseInt(tokensLinha[1]));
		nova.setCodigoMateria(tokensLinha[3]);
		nova.setNome(tokensLinha[5]);
		try {
			nova.setPeriodo(Integer.parseInt(tokensLinha[6]));
		} catch (Exception erro) {
			nova.setPeriodo(0);
		}
		nova.setTipo(tokensLinha[8]);
		nova.setHoras(Integer.parseInt(tokensLinha[9]));
		return nova;
	}

	/** 
	 * Procura Materia a partir de seu código fornecido.
	 *
	 * @param codigoMateria código único da matéria
	 * @return retorna lista de índices contendo a matéria
	 */
	 
	public int procurarMateria(String nomeMateria) {

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
