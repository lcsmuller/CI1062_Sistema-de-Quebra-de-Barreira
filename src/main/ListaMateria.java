package main;

import java.util.Vector;

public class ListaMateria extends Tokenizador<Materia> {

	public Materia fromLinhaTokens(String[] entrada) {
		Materia nova = new Materia();
		nova.setCodigoCurso(entrada[0]);
		nova.setVersao(Integer.parseInt(entrada[1]));
		nova.setCodigoMateria(entrada[3]);
		nova.setNome(entrada[5]);
		try {
			nova.setPeriodo(Integer.parseInt(entrada[6]));
		} catch (Exception erro) {
			nova.setPeriodo(4);
		}
		nova.setTipo(entrada[8]);
		nova.setHoras(Integer.parseInt(entrada[9]));
		return nova;
	}

	public Vector<Integer> procurarMateria(String codigoMateria) {
		Vector<Integer> lista_indice = new Vector<>();

		for (int i = 0; i < this.lista.size(); i++) {
			String cod_curso_lista = this.lista.get(i).getCodigoMateria();
			if (cod_curso_lista.equals(codigoMateria))
				lista_indice.add(i);
		}
		return lista_indice;
	}
}
