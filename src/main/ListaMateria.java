package main;
import java.util.Vector;


public class ListaMateria {

    private Vector<Materia> lista = new Vector<Materia>();

	public Vector<Materia> getLista() {
		return lista;
	}

	public void setLista(Vector<Materia> lista) {
		this.lista = lista;
	}
	
	public void inserir (Materia mat) {
		this.lista.add(mat);
	}
	
	public void inserirEm(Materia mat, int pos) {
		this.lista.add(pos, mat);
	}
	
	public void remover(Materia mat) {
		this.lista.remove(mat);
	}
	
	public void removerEm (int pos) {
		this.lista.remove(pos);
	}

	public Vector<Integer> procurarMateria (String codigoMateria) {
		Vector<Integer> lista_indice = new Vector<>();

		for (int i = 0; i < this.lista.size(); i++) {
			String cod_curso_lista = this.lista.get(i).getCodigoMateria();
			if (cod_curso_lista.equals(codigoMateria))
				lista_indice.add(i);
		}
		return lista_indice;
	}
}