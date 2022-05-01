package main;

import java.util.Arrays;
import java.util.Vector;

/** Manipula e converte tokens obtidos em { @link main.Csv#tokenizaCsv } para listas */
abstract class Tokenizador <T> {
	/** lista genérica */
    protected Vector<T> lista = new Vector<T>();

	/** 
	 * Converte conteúdo de linha para classe genérica.
	 *
	 * @param tokensLinha linha contendo os tokens a serem convertidos em classe
	 * @return retorna objeto convertido
	 */
    public abstract T fromLinhaTokens(String[] tokensLinha);

    /**
	 * Retorna a lista genérica.
	 *
	 * @return lista genérica
	 */
	public Vector<T> getLista() {
		return lista;
	}

	/**
	 * Transforma tokens de linha CSV obtidos por {@link main.Csv#tokeniza(String)}.
	 *
	 * @param tokens os tokens a serem decodificados
	 */
	public void tokensToLista(String[][] tokens) {
   		for(int i = 2; i < tokens.length; i++) {
   			T materia = this.fromLinhaTokens(tokens[i]);
    		this.inserir(materia);
    	}
	}

	/**
	 * Transforma lista em tokens de string.
	 *
	 * @return tokens serializados
	 */			
	public String[][] listaToTokens() {
		String[][] data = new String[2000][1];
		int i;

		for(i = 0; i < this.tamanhoLista(); ++i) {									
			data[i] = this.listaGetAt(i).toString().split(",");
		}
		
		return Arrays.copyOf(data, i);
	}

	/**
	 * Retorna o tamanho da lista.
	 *
	 * @return tamanho da lista
	 */
    public int tamanhoLista() {
		return this.lista.size();
	}

	/**
	 * Obtêm objeto da lista em índice específico.
	 *
	 * @param i índice ocupado pelo objeto
	 * @return retorna classe genérica
	 */
    public T listaGetAt(int i) {
		return this.lista.get(i);
	}
    
	/** Imprime conteúdo da lista. */
    public void imprimeLista() {
		for(int i = 0; i < this.tamanhoLista(); i++) {									
			System.out.println("Elemento " + i + " : {"
								+ this.listaGetAt(i).toString() + "}");
		}
	} 

	/**
	 * Insere novo elemento na lista.
	 *
	 * @param mat elemento a ser inserido
	 */
	public void inserir(T mat) {
		this.lista.add(mat);
	}
	
	/**
	 * Insere novo elemento na lista em um índice específico.
	 *
	 * @param mat elemento a ser inserido
	 * @param pos posição a ser inserido
	 */
	public void inserirEm(T mat, int pos) {
		this.lista.add(pos, mat);
	}
	
	/**
	 * Remove um elemento da lista.
	 *
	 * @param mat elemento a ser removido
	 */
	public void remover(T mat) {
		this.lista.remove(mat);
	}
	
	/**
	 * Remove um elemento da lista em um índice específico.
	 *
	 * @param pos posição do elemento a ser removido
	 */
	public void removerEm(int pos) {
		this.lista.remove(pos);
	}

	/** Remove o último elemento da lista. */
	public void removeUltimo(){
		this.lista.remove(this.tamanhoLista() - 1);
	}
	
}
