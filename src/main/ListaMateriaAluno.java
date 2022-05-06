package main;

import java.util.Vector;

/** Matérias vinculadas ao aluno. */
public class ListaMateriaAluno extends Tokenizador<AlunoMateria> {

	/**
	 * Transforma tokens de linha CSV obtidos por
	 *		{@link main.Csv#tokeniza(String)}.
	 *
	 * @param tokensLinha os tokens a serem serializados
	 * @return resultado da transformação em AlunoMateria
	 */
	public AlunoMateria fromLinhaTokens(String[] tokensLinha) {
  		AlunoMateria novoAlunoMateria = new AlunoMateria();

  		novoAlunoMateria.setCodigoCurso(tokensLinha[2]);
  		novoAlunoMateria.setVersao(Integer.parseInt(tokensLinha[4]));
  		novoAlunoMateria.setCodigoMateria(tokensLinha[10]);
  		novoAlunoMateria.setNome(tokensLinha[11]);
		novoAlunoMateria.setPeriodo(Integer.parseInt(tokensLinha[16]));
  		novoAlunoMateria.setTipo(tokensLinha[13]);
  		novoAlunoMateria.setHoras(Integer.parseInt(tokensLinha[12]));
  		novoAlunoMateria.setNota(Integer.parseInt(tokensLinha[6]));
  		try {
  			novoAlunoMateria.setFrequencia(Integer.parseInt(tokensLinha[14]));
  		} catch (Exception e) {
  			novoAlunoMateria.setFrequencia(0);
  		}
  		novoAlunoMateria.setSituacao(tokensLinha[15]);
  		novoAlunoMateria.setCodSituacao(Integer.parseInt(tokensLinha[7]));

  		return novoAlunoMateria;
  	}

	/**
	 * Obtêm lista de índices contendo posições da matéria cursada na lista. 
	 *
	 * @param codigoMateria codígo único da matéria para seleção
	 * @return retorna uma lista contendo os índices onde a matéria foi
	 * 		encontrada na lista
	 */
	public Vector<Integer> procurarMateria(String codigoMateria) {
		Vector<Integer> listaIndice = new Vector<>();
        
		for (int i = 0; i < this.lista.size(); i++) {
			String codCursoLista = this.lista.get(i).getCodigoMateria();
			if (codCursoLista.equals(codigoMateria))
				listaIndice.add(i);
		}
		return listaIndice;
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
			if (nome.equals(nomeMateria) && this.listaGetAt(i).getCodSituacao() != 10)
				return i;
		}
		return -1;
	}
	
	/**
	 * Verifica se matéria está sendo cursada pelo aluno.
	 *
	 * @return `true` se a matéria estiver sendo cursada
	 */
	public boolean procurarMateriaBool(String codigoMateria) {
		for (int i = 0; i < this.lista.size(); i++) {
			String codCursoLista = this.lista.get(i).getCodigoMateria();
			if (codCursoLista.equals(codigoMateria))
				return true;
		}
		return false;
	}
}
