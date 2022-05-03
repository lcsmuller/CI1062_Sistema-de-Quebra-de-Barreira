package main;

import java.util.Vector;

/** Mat�rias que j� foram ou est�o sendo cursadas pelo aluno */
public class ListaMateriaAluno extends Tokenizador<AlunoMateria> {

	/**
	 * Transforma tokens de linha CSV obtidos por
	 *		{@link main.Csv#tokeniza(String)}.
	 *
	 * @param tokensLinha os tokens a serem serializados
	 * @return resultado da transforma��o em AlunoMateria
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
	 * Obt�m lista de �ndices contendo posi��es da mat�ria cursada na lista. 
	 *
	 * @param codigoMateria cod�go �nico da mat�ria para sele��o
	 * @return retorna uma lista contendo os �ndices onde a mat�ria foi
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
	 * Verifica se mat�ria est� sendo cursada pelo aluno.
	 *
	 * @return `true` se a mat�ria estiver sendo cursada
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
