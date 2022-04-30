package main;

import java.util.Vector;

/** Matérias que já foram ou estão sendo cursadas pelo aluno */
public class MateriaAlunoLista extends Tokenizador<AlunoMateria> {

	/**
	 * Transforma tokens de linha CSV obtidos por {@link main.Csv#tokenizaCsv(String)}.
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
		nova.setPeriodo(0);
  		nova.setTipo(tokensLinha[13]);
  		nova.setHoras(Integer.parseInt(tokensLinha[12]));
  		nova.setNota(Integer.parseInt(tokensLinha[6]));
  		try {
  			nova.setFrequencia(Integer.parseInt(tokensLinha[14]));
  		} catch(Exception e) {
  			nova.setFrequencia(0);
  		}
  		nova.setSituacao(tokensLinha[15]);

  		return nova;
  	}

	public Vector<Integer> procurarMateria(String codigoMateria) {
		Vector<Integer> listaIndice = new Vector<>();
        
		for (int i = 0; i < this.lista.size(); i++) {
			String codCursoLista = this.lista.get(i).getCodigoMateria();
			if (codCursoLista.equals(codigoMateria))
				listaIndice.add(i);
		}
		return listaIndice;
	}
	
	public boolean procurarMateriaBool (String codigoMateria) {
		for (int i = 0; i < this.lista.size(); i++) {
			String codCursoLista = this.lista.get(i).getCodigoMateria();
			if (codCursoLista.equals(codigoMateria))
				return true;
		}
		return false;
	}
}
