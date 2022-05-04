package main;

import java.util.Vector;

/** Matérias que já foram ou estão sendo cursadas pelo aluno */
public class ListaMateriaAluno extends Tokenizador<AlunoMateria> {

	/**
	 * Transforma tokens de linha CSV obtidos por
	 *		{@link main.Csv#tokeniza(String)}.
	 *
	 * @param tokensLinha os tokens a serem serializados
	 * @return resultado da transformação em AlunoMateria
	 */
	public AlunoMateria fromLinhaTokens(String[] tokensLinha) {
  		AlunoMateria nova = new AlunoMateria();

  		nova.setCodigoCurso(tokensLinha[2]);
  		nova.setVersao(Integer.parseInt(tokensLinha[4]));
  		nova.setCodigoMateria(tokensLinha[10]);
  		nova.setNome(tokensLinha[11]);
		nova.setPeriodo(Integer.parseInt(tokensLinha[16]));
  		nova.setTipo(tokensLinha[13]);
  		nova.setHoras(Integer.parseInt(tokensLinha[12]));
  		nova.setNota(Integer.parseInt(tokensLinha[6]));
  		try {
  			nova.setFrequencia(Integer.parseInt(tokensLinha[14]));
  		} catch(Exception e) {
  			nova.setFrequencia(0);
  		}
  		nova.setSituacao(tokensLinha[15]);
  		nova.setCodSituacao(Integer.parseInt(tokensLinha[7]));

  		return nova;
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
