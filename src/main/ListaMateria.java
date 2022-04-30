package main;
import java.util.Vector;


public class ListaMateria {

        private Vector<Materia> lista = new Vector<Materia>();
    
        public Materia stringToMateria2019(String[] entrada){
  		Materia nova = new Materia();
  		nova.setCodigoCurso(entrada[0]);
  		nova.setVersao(Integer.parseInt(entrada[1]));
  		nova.setCodigoMateria(entrada[3]);
  		nova.setNome(entrada[5]);
  		try {
  			nova.setPeriodo(Integer.parseInt(entrada[6]));
  		}
  		catch(Exception erro) {
  			nova.setPeriodo(4);
  		}
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
  		try {
  			nova.setPeriodo(Integer.parseInt(entrada[6]));
  		}
  		catch(Exception erro) {
  			nova.setPeriodo(4);
  		}
  		nova.setTipo(entrada[8]);
  		nova.setHoras(Integer.parseInt(entrada[10]));
  		return nova;
  	}
        
    public void matrizToLista(String[][] entrada){
    	int versao = Integer.parseInt(entrada[2][1]);
    	if (versao == 2019){
    		for(int i = 2; i < entrada.length; i++) {
    			Materia materia = this.stringToMateria2019(entrada[i]);
    			this.inserir(materia);
    		}
    	}	
    	else{ 
    		for(int i = 2; i < entrada.length; i++) {
    			Materia materia = this.stringToMateria2011(entrada[i]);
    			this.inserir(materia);
    		}
    	}
    }
    
    
	public Vector<Materia> getLista() {
		return lista;
	}
	
	public int tamanhoLista() {
		return lista.size();
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
	
	public void imprime() {
		for(int i = 1; i < this.tamanhoLista(); i++) {									
			System.out.println("Elemento "+ i + " :" + this.getAt(i).imprimivel());	//get at retorno o elemento na posicao i , imprimivel torna o objeto Materia imprimivel com o println 
		}
	}
	public Materia getAt(int i) {
		return this.lista.get(i);
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
