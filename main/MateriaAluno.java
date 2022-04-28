package main;

import java.util.Vector;

/** @todo gerar métodos com eclipse 
 *  @todo operacoes de lista (procurar, inserir, remover)
*/

public class MateriaAluno {

    private Vector<AlunoMateria> lista = new Vector<AlunoMateria>();
    private Vector<AlunoMateria> pedido = new Vector<AlunoMateria>();
    
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

	public Vector<AlunoMateria> getPedido() {
		return pedido;
	}

	public void setPedido(Vector<AlunoMateria> pedido) {
		this.pedido = pedido;
	}
	
	public void inserirProduto (AlunoMateria mat) {
		this.pedido.add(mat);
	}
	
	public void inserirProdutoEm(AlunoMateria mat, int pos) {
		this.pedido.add(pos, mat);
	}
	
	public void removerProduto(AlunoMateria mat) {
		this.pedido.remove(mat);
	}
	
	public void removerProdutoEm (int pos) {
		this.pedido.remove(pos);
	}
	
	public int procutarProdutoMateria (String codigoMateria) {
		for (int i = 0; i < this.lista.size(); i++) {
			String cod_curso_lista = this.lista.get(i).getCodigoMateria();
			if (cod_curso_lista.equals(codigoMateria))
				return i;
		}
		return -1;
	}
	
}