package main;
import java.util.Vector;


/** @todo gerar métodos com eclipse 
 *  @todo operacoes de lista (procurar, inserir, remover)
*/

public class ListaMateria {

    private Vector<Materia> lista = new Vector<Materia>();
    
    public Materia stringToMateria2019(String[] entrada){
  		Materia nova = new Materia();
  		nova.setCodigoCurso(entrada[0]);
  		nova.setVersao(Integer.parseInt(entrada[1]));
  		nova.setCodigoMateria(entrada[3]);
  		nova.setNome(entrada[5]);
  		nova.setPeriodo(Integer.parseInt(entrada[6]));
  		nova.setTipo(entrada[8]);
  		nova.setHoras(Integer.parseInt(entrada[9]));
  		return nova;
  	}
    
    public Materia stringToMateria2011(String[] entrada){
  		Materia nova = new Materia();
  		nova.setCodigoCurso(entrada[0]);
  		nova.setVersao(Integer.parseInt(entrada[1]));
  		nova.setCodigoMateria(entrada[3]);
  		nova.setNome(entrada[5]);
  		nova.setPeriodo(Integer.parseInt(entrada[6]));
  		nova.setTipo(entrada[8]);
  		nova.setHoras(Integer.parseInt(entrada[10]));
  		return nova;
  	}
    
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