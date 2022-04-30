package main;

import java.util.Arrays;
import java.util.Vector;
import java.lang.Integer;

/** @todo gerar métodos com eclipse 
 *  @todo operacoes de lista (procurar, inserir, remover)
*/

public class MateriaAluno {

    private Vector<AlunoMateria> lista = new Vector<AlunoMateria>();
    private Vector<AlunoMateria> pedido = new Vector<AlunoMateria>();
    
	public Vector<AlunoMateria> getLista() {
		return lista;
	}
	 public AlunoMateria stringToMateria(String[] entrada){
  		AlunoMateria nova = new AlunoMateria();
  		nova.setCodigoCurso(entrada[2]);
  		nova.setVersao(Integer.parseInt(entrada[4]));
  		nova.setCodigoMateria(entrada[10]);
  		nova.setNome(entrada[11]);
		nova.setPeriodo(0);
  		nova.setTipo(entrada[13]);
  		nova.setHoras(Integer.parseInt(entrada[12]));
  		nova.setNota(Integer.parseInt(entrada[6]));
  		try {
  			nova.setFrequencia(Integer.parseInt(entrada[14]));
  		}catch(Exception erro){
  			nova.setFrequencia(0);
  		}
  		nova.setSituacao(entrada[15]);
  		return nova;
  	}
	 
	 public void matrizToLista(String[][] entrada){
   		for(int i = 2; i < entrada.length; i++) {
   			AlunoMateria materia = this.stringToMateria(entrada[i]);
    		this.inserir(materia);
    	}
	}
	
	public void imprimeLista() {
		for(int i = 0; i < this.tamanhoLista(); i++) {									
			System.out.println("Elemento "+ i + " : {" + this.listaGetAt(i).imprimivel()+ "}");	//get at retorno o elemento na posicao i , imprimivel torna o objeto Materia imprimivel com o println 
		}
	}
	
	public AlunoMateria listaGetAt(int i) {
		return this.lista.get(i);
	}
	
	public int tamanhoLista() {
		return this.lista.size();
	}
	 
	public float ira(){
		float indice = 0;
		float total = 0;
		float nota = 0;
		float horas = 0;
		for(int i = 0; i < this.tamanhoLista(); i++) {
			if(!this.listaGetAt(i).getSituacao().equals("Matricula")){
				horas = this.listaGetAt(i).getHoras();
				nota = this.listaGetAt(i).getNota();
				indice += horas * nota;
				total += 100 * horas;
			}
		}
		indice /= total;
		return indice;
		
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
	
	public void inserirPedido (AlunoMateria mat) {
		this.pedido.add(mat);
	}
	
	public void inserirPedidoEm(AlunoMateria mat, int pos) {
		this.pedido.add(pos, mat);
	}
	
	public void removerPedido(AlunoMateria mat) {
		this.pedido.remove(mat);
	}
	
	public void removerPedidoEm (int pos) {
		this.pedido.remove(pos);
	}
	
	public int tamanhoPedido() {
		return this.pedido.size();
	}
	
	public void imprimePedido(){
		for(int i = 0; i < this.tamanhoPedido(); i++) {									
			System.out.println("Elemento "+ i + " : {" + this.pedidoGetAt(i).imprimivel() + "}");	//get at retorno o elemento na posicao i , imprimivel torna o objeto Materia imprimivel com o println 
		}
	}
	
	public AlunoMateria pedidoGetAt(int i) {
		return this.pedido.get(i);
	}
	
	public String[][] pedidoToMatriz(){
		String[][] data = new String[2000][1];
		int i;
		for(i = 0; i < this.tamanhoPedido(); ++i) {									
			data[i] = this.pedidoGetAt(i).imprimivel().split(",");	//get at retorno o elemento na posicao i , imprimivel torna o objeto Materia imprimivel com o println 
		}
		return Arrays.copyOf(data, i);
	}

	public int procutarPedidoMateria (String codigoMateria) {
		for (int i = 0; i < this.lista.size(); i++) {
			String cod_curso_lista = this.lista.get(i).getCodigoMateria();
			if (cod_curso_lista.equals(codigoMateria))
				return i;
		}
		return -1;
	}
	
}