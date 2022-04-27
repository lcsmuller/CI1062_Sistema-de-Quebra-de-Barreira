package main;

import java.util.Vector;

/** @todo gerar métodos com eclipse 
 *  @todo operacoes de lista (procurar, inserir, remover)
*/

public class MateriaAluno {

    private Vector<AlunoMateria> lista = new Vector<AlunoMateria>();
    
	public Vector<AlunoMateria> getLista() {
		return lista;
	}

	public void setLista(Vector<AlunoMateria> lista) {
		this.lista = lista;
	} 

	public void inserir (AlunoMateria mat) {
		this.lista.add(mat);
	}
	
	public void inserirEm(AlunoMateria mat, int pos) {
		this.lista.add(pos, mat);
	}
	
	public void remover(AlunoMateria mat) {
		this.lista.remove(mat);
	}
	
	public void removerEm (int pos) {
		this.lista.remove(pos);
	}

	public Vector<Integer> procutarMateria (String codigoMateria) {
		Vector<Integer>lista_indice = new Vector<>();
		for (int i = 0; i < this.lista.size(); i++) {
			String cod_curso_lista = this.lista.get(i).getCodigoMateria();
			if (cod_curso_lista.equals(codigoMateria))
				lista_indice.add(i);
		}
		return lista_indice;
	}
	
}