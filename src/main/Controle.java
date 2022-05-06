package main;

import java.util.Vector;

public class Controle {
	/** lista de matérias reprovadas */
	private Vector<Integer> posReprovadas = new Vector<>();
	/** lista de matérias pré-barreiras faltantes */
	private ListaMateria listaFaltantes = new ListaMateria();
	/** lista de matérias que podem ser pedidas */
	private ListaPedidos listaPossiveisPedidos = new ListaPedidos();
	/** pedidos selecionados pelo aluno */
	private ListaPedidos listaPedidos = new ListaPedidos();
	/** lista com todas as matérias */
	private ListaMateria listaMateria = new ListaMateria();
	/** lista com as matérias do aluno */
	private ListaMateriaAluno listaMateriaAluno = new ListaMateriaAluno();
	/** índice inicial das matérias faltantes */
	private int offsetBonus;

	/**
	 * Retorna índice em que começam as matérias faltantes.
	 *
	 * @return índice em que começam as matérias faltantes
	 */
	public int getOffsetBonus() {
		return this.offsetBonus;
	}

	/** 
	 * Retorna lista de matérias faltantes.
	 *
	 * @return lista de matérias faltantes
	 */
	public ListaMateria getListaFaltantes() {
		return listaFaltantes;
	}

	/**
	 * Retorna lista de possíveis pedidos.
	 *
	 * @return lista de possíveis pedidos
	 */
	public ListaPedidos getListaPedidos() {
		return listaPedidos;
	}
	
	/**
	 * Define listaPedidos como a lista inserida.
	 *
	 * 
	 */
	public void setListaPedidos(ListaPedidos novo) {
		this.listaPedidos = novo;
	}
	
	/**
	 * Retorna lista de matérias.
	 *
	 * @return lista de matérias
	 */
	public ListaMateria getListaMateria() {
		return listaMateria;
	}
	
	/**
	 * Retorna lista de matérias do aluno.
	 *
	 * @return lista de matérias do aluno
	 */
	public ListaMateriaAluno getListaMateriaAluno() {
		return listaMateriaAluno;
	}

	/**
	 * Procura quais matérias o aluno já fez. Caso não encontre, coloca matéria
	 * 		em uma lista de matérias que serão ofertadas ao aluno.
	 */
	public void procuraMateriaAluno () {
		for (int i = 0; i < this.listaMateria.getLista().size(); i++) {
			Materia materia = this.listaMateria.getLista().elementAt(i);
			if (!this.listaMateriaAluno.procurarMateriaBool(materia.getCodigoMateria()));
				this.listaPedidos.inserir(materia);
		}
	}

	/** Imprime matérias que podem ser cursadas pelo aluno. */		
	public void imprimirPossiveisMateria() {
		for (int i = 0; i < this.listaPedidos.tamanhoLista(); i++) {
			System.out.println(this.listaPedidos.listaGetAt(i).getNome());
			System.out.println(this.listaPedidos.listaGetAt(i).getCodigoMateria());
			System.out.println(this.listaPedidos.listaGetAt(i).getCodigoCurso());
			System.out.println(this.listaPedidos.listaGetAt(i).getHoras());
			System.out.println(this.listaPedidos.listaGetAt(i).getPeriodo());
			System.out.println(this.listaPedidos.listaGetAt(i).getTipo());
			System.out.println(this.listaPedidos.listaGetAt(i).getVersao());
		}
	}

	/**
	 * Retorna IRA do aluno.
	 *
	 * @return IRA do aluno
	 */
	public float ira() {
		float indice = 0, total = 0, nota = 0, horas = 0;

		for (int i = 0; i < listaMateriaAluno.tamanhoLista(); i++) {
			if (!listaMateriaAluno.listaGetAt(i).getSituacao().equals("Matricula")) {
				if (listaMateriaAluno.listaGetAt(i).getFrequencia() < 75) {
					horas = listaMateriaAluno.listaGetAt(i).getHoras();
					total += 100 * horas;
				}
				else {
					horas = listaMateriaAluno.listaGetAt(i).getHoras();
					nota = listaMateriaAluno.listaGetAt(i).getNota();
					indice += horas * nota;
					total += 100 * horas;
				}
			}
		}

		return indice /= total;
	}

	/**
	 * Conta quantas matérias o aluno reprovou no semestre anterior.
	 * 
	 * @return quantidade de matérias reprovadas no semestre anterior
	 */
	public float materiaReprovadas() {
		float contador = 0;
		
		for (int i = 0; i < this.listaMateriaAluno.tamanhoLista(); i++){
			if (this.listaMateriaAluno.listaGetAt(i).getPeriodo() == 3
				&& this.listaMateriaAluno.listaGetAt(i).getCodSituacao() > 1
				&& this.listaMateriaAluno.listaGetAt(i).getCodSituacao() != 10)
			{
					contador++;
			}
		}
		return contador;
	} 

	/** Remove os pedidos efetuados pelo aluno. */
	public void removePedidos() {
		while (this.listaPedidos.tamanhoLista() > 3){
			this.listaMateriaAluno.removeUltimo();
		}
	}

	/** Insere no vetor de posições as matérias que o aluno reprovou. */
	public void posicoesMateriasReprovadas() {
		for (int i = 0; i < this.listaMateriaAluno.tamanhoLista(); i++){
			// Caso o aluno tenha reprovado ou por falta ou por nota
			if (this.listaMateriaAluno.listaGetAt(i).getCodSituacao() == 2
				|| this.listaMateriaAluno.listaGetAt(i).getCodSituacao() == 3)
			{
				this.posReprovadas.add(i);
			}
		}
	}

	/**
	 * Retorna desempenho do aluno.
	 *
	 * @return desempenho do aluno
	 */
	public float getDesempenho() {
		return this.materiaReprovadas() / 5;
	}

	/**
	 * Analiza pedido de matérias do aluno, remove pedidos se cair em um dos
	 * 		seguintes casos (em relação ao período anterior):
	 * - Caso A: reprovado em mais de 2/3 e efetua mais de 5 pedidos 
	 * - Caso B: reprovado entre 1/3 a 2/3 e efetua mais de 4 pedidos
	 * - Caso C: reprovado em menos que 1/3 e efetua mais de 3 pedidos
	 */
	public int analizarPedido() {		
		float desempenho = getDesempenho();

		if (listaPedidos.listaGetAt(listaPedidos.tamanhoLista()-1).getPeriodo() > 3 && listaFaltantes.tamanhoLista() > 0) {
			int i = 0;
			while(i < this.listaPedidos.tamanhoLista()){
				if(listaPedidos.listaGetAt(i).getPeriodo() >= 4 ) {
					 listaPedidos.removerEm(i);

				}	 
				else {
					i++;
				}
			}
			return 4;
		}	
		else if (listaFaltantes.tamanhoLista() == 0) {
			if (this.ira() < 0.8) {
				if (desempenho < 0.33) { // Caso C
					if (this.listaPedidos.tamanhoLista() > (3 + offsetBonus)) {
						this.listaPedidos.removeUltimo();
						return 3;
					}
					return 0;
				}
				else if (desempenho >= 0.33 && desempenho < 0.66) { // Caso B
					if (this.listaPedidos.tamanhoLista() > (4 + offsetBonus)) {
						this.listaPedidos.removeUltimo();
						return 2;
					}
					return 0;
				}
				else { // Caso A
					if (this.listaPedidos.tamanhoLista() > (5 + offsetBonus)) {
						this.listaPedidos.removeUltimo();
						return 1;
					}
					return 0;
				}
			}
		}
		return 0;
	}
	
	/**
	 * Transforma a lista de matéria num String[][].
	 *
	 * @return um String[][]. Basicamente uma tabela com todas as matérias.
	 */
	public String[][] tabelaMateria() {
		String tabelaMateria[][] = new String[7][9];
		int colunas[] = {1, 1, 1, 1, 1, 1, 1, 1, 1};

		for(int i = 0; i < 8; i++)
			tabelaMateria[0][i] = (i+1) + "º PERIODO";

		for (int i = 0; i < this.listaPossiveisPedidos.tamanhoLista(); i++) {
			int j = this.listaPossiveisPedidos.listaGetAt(i).getPeriodo();
			tabelaMateria[colunas[j]][j - 1] = this.listaPossiveisPedidos.listaGetAt(i).getNome() ;
			colunas[j]++;
		}

		return tabelaMateria;
	}
	
	public String[][] tabelaMateriaFeitas() {
		String tabelaMateria[][] = new String[7][9];
		int colunas[] = {1, 1, 1, 1, 1, 1, 1, 1, 1};

		for(int i = 0; i < 8; i++)
			tabelaMateria[0][i] = (i+1) + "º PERIODO";

		for (int i = 0; i < this.listaMateriaAluno.tamanhoLista(); i++) {
			int j = this.listaMateriaAluno.listaGetAt(i).getPeriodo();
			if(this.listaMateriaAluno.listaGetAt(i).getCodSituacao() != 10) {
				tabelaMateria[colunas[j]][j-1] = this.listaMateriaAluno.listaGetAt(i).getNome() ;
				colunas[j]++;
			}	
		}

		return tabelaMateria;
	}
	
	/** 
	 * Gera tabela das matérias pedidas.
	 *
	 * @return tokens de tabelas pedidas
	 */
	public String[][] tabelaMateriaPedidas() {
		String tabelaMateria[][] = new String[7][9];
		int colunas[] = {1, 1, 1, 1, 1, 1, 1, 1, 1};

		for(int i = 0; i < 8; i++)
			tabelaMateria[0][i] = (i+1) + "º PERIODO";

		for (int i = 0; i < this.listaPedidos.tamanhoLista(); i++) {
			int j = this.listaPedidos.listaGetAt(i).getPeriodo();
			tabelaMateria[colunas[j]][j-1] = this.listaPedidos.listaGetAt(i).getNome() ;
			colunas[j]++;
		}

		return tabelaMateria;
	}
	
	/**
	 * Preenche lista de possíveis escolhas de matérias com base em matérias
	 * 		ainda não cursadas.
	 */
	public void possiveisPedidos() {
		for (int i = 0; i < this.listaMateria.tamanhoLista(); i++) {
			String codMateria = this.listaMateria.listaGetAt(i).getCodigoMateria();
			boolean fezMateria = false;
			int posMateria = 0;

			for (int j = 0; j < this.listaMateriaAluno.tamanhoLista(); j++){
				String materias_cursadas = this.listaMateriaAluno.listaGetAt(j).getCodigoMateria();
				if (codMateria.equals(materias_cursadas)) {
					fezMateria = true;
					posMateria = j;
				}
			}

			if (fezMateria == false) {
				if (this.listaMateria.listaGetAt(i).getPeriodo() != 0 && this.listaMateria.listaGetAt(i).getHoras() != 150)
					this.listaPossiveisPedidos.inserir(this.listaMateria.listaGetAt(i));
			}	
			else if (this.listaMateriaAluno.listaGetAt(posMateria).getCodSituacao() == 2 || this.listaMateriaAluno.listaGetAt(posMateria).getCodSituacao() == 3) {
				this.listaPossiveisPedidos.inserir(this.listaMateria.listaGetAt(i));				
			}
		}
	}
	
	public void preencheFaltantes() {
		for (int i = 0; i < this.listaMateria.tamanhoLista(); i++) {
			if((this.listaMateria.listaGetAt(i).getPeriodo() < 4) && (this.listaMateria.listaGetAt(i).getPeriodo() != 0 )) {
				this.listaFaltantes.inserir(listaMateria.listaGetAt(i));
			}	
		}

		for (int i = 0; i < this.listaFaltantes.tamanhoLista(); i++) {
			String codMateria = this.listaFaltantes.listaGetAt(i).getCodigoMateria();
			
			for (int j = 0; j < this.listaMateriaAluno.tamanhoLista(); j++){
				String materias_cursadas = this.listaMateriaAluno.listaGetAt(j).getCodigoMateria();
				if (codMateria.equals(materias_cursadas)) {
					if (this.listaMateriaAluno.listaGetAt(j).getCodSituacao() == 1 ) {
						this.listaFaltantes.removerEm(i);
						i--;
					}
				}
			}
		}
		offsetBonus = listaFaltantes.tamanhoLista();
	}
	
}
