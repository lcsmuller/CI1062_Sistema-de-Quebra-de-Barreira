package main;

import java.util.Vector;

public class Controle {

	private Vector<Materia> possiveis_pedidos = new Vector<>();
	private ListaMateria lista_materia = new ListaMateria();
	private MateriaAlunoLista mat_aluno = new MateriaAlunoLista();

	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	public Vector<Materia> getPossiveis_pedidos() {
		return possiveis_pedidos;
	}

	public void setPossiveis_pedidos(Vector<Materia> possiveis_pedidos) {
		this.possiveis_pedidos = possiveis_pedidos;
	}
	
	public Materia getPossiveisPedidosAt (int i) {
		return this.possiveis_pedidos.get(i);
	}
	
	public void setPossiveisPedidosAt(Materia nova_materia, int i) {
		this.possiveis_pedidos.add(i, nova_materia);
	}
	
	public void setPossiveisPedidos(Materia nova_materia) {
		this.possiveis_pedidos.add(nova_materia);
	}
	
	public void removePossiveisPedidosAt (int i) {
		this.possiveis_pedidos.remove(i);
	}

	public ListaMateria getLista_materia() {
		return lista_materia;
	}

	public void setLista_materia(ListaMateria lista_materia) {
		this.lista_materia = lista_materia;
	}
	
	public MateriaAlunoLista getMat_aluno() {
		return mat_aluno;
	}
	
	public void setMat_aluno(MateriaAlunoLista mat_aluno) {

		
		this.mat_aluno = mat_aluno;
	}

	//Essa função procura quais matéria o aluno já fez
	//Caso não encontre uma matéria, coloca essa matéria numa outra lista para
	//ofertar ao aluno
	public void procuraMateriaAluno () {
		for (int i = 0; i < this.lista_materia.getLista().size(); i++) {
			Materia mat = this.lista_materia.getLista().elementAt(i);
			if (! this.mat_aluno.procurarMateriaBool(mat.getCodigoMateria()));
				this.setPossiveisPedidos(mat);
		}
	}
	
	public void imprimirPossiveisMateria() {
		for (int i = 0; i < this.possiveis_pedidos.size(); i++) {
			System.out.println(this.getPossiveisPedidosAt(i).getNome());
			System.out.println(this.getPossiveisPedidosAt(i).getCodigoMateria());
			System.out.println(this.getPossiveisPedidosAt(i).getCodigoCurso());
			System.out.println(this.getPossiveisPedidosAt(i).getHoras());
			System.out.println(this.getPossiveisPedidosAt(i).getPeriodo());
			System.out.println(this.getPossiveisPedidosAt(i).getTipo());
			System.out.println(this.getPossiveisPedidosAt(i).getVersao());
		}
	}

	public float ira(){
		float indice = 0, total = 0, nota = 0, horas = 0;

		for(int i = 0; i < mat_aluno.tamanhoLista(); i++) {
			if(!mat_aluno.listaGetAt(i).getSituacao().equals("Matricula")){
				if (mat_aluno.listaGetAt(i).getFrequencia() < 75){
					
					horas = mat_aluno.listaGetAt(i).getHoras();
					total += 100 * horas;
				}
				else{
					horas = mat_aluno.listaGetAt(i).getHoras();
					nota = mat_aluno.listaGetAt(i).getNota();
					indice += horas * nota;
					total += 100 * horas;
				}
			}
		}
		indice /= total;
		return indice;
	}

	public void analizarPedido () {
		for (int i = 0; i < this.mat_aluno.getLista().size(); i++){
			if (this.ira() < 0.8) {
				
			}
		}
	}


	
	
}
