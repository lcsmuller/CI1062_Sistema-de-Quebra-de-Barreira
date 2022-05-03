package main;

import java.util.Vector;

public class Controle {

	private Vector<Integer> pos_reprovadas = new Vector<>();			//LISTA DE MATERIAS REPROVADAS
	private ListaMateria faltantes = new ListaMateria();				//LISTA DE MATERIAS PRE-BARREIRA FALTANTES
	private ListaPedidos possiveis_escolhas = new ListaPedidos();		//LISTA DE MATERIAS QUE PODEM SER PEDIDAS
	private ListaPedidos pedidos = new ListaPedidos();					//PEDIDOS SELECIONADOS
	private ListaMateria lista_materia = new ListaMateria();			//LISTA COM TODAS AS MATERIAS
	private ListaMateriaAluno mat_aluno = new ListaMateriaAluno();		//LISTA COM AS MATERIAS FEITAS PELO ALUNO
	
	// -----------------------------------
	//
	//	FUNCOES COM VETOR FALTANTES 
	//
	//-------------------------------------
	public ListaMateria getFaltantes() {
		return faltantes;
	}

	public void setFaltantes(ListaMateria faltantes) {
		this.faltantes = faltantes;
	}

	// ------------------------------------ 
	//
	//	FUNCOES COM O POSSIVEIS PEDIDOS 
	//
	// ------------------------------------
	public ListaPedidos getPedidos() {
		return pedidos;
	}

	public void setpedidos(ListaPedidos pedidos) {
		this.pedidos = pedidos;
	}
	
	public Materia getPossiveisPedidosAt (int i) {
		return this.pedidos.listaGetAt(i);
	}
	
	public void setPossiveisPedidosAt(Materia nova_materia, int i) {
		this.pedidos.inserirEm(nova_materia, i);
	}
	
	public void setPossiveisPedidos(Materia nova_materia) {
		this.pedidos.inserir(nova_materia);
	}
	
	public void removePossiveisPedidosAt (int i) {
		this.pedidos.removerEm(i);
	}
	
	// ---------------------------------
	//
	//	FUNCOES POSSIVEIS ESCOLHAS
	//
	// ---------------------------------
	public ListaPedidos getPossiveis_escolhas() {
		return possiveis_escolhas;
	}

	public void setPossiveis_escolhas(ListaPedidos pedidos) {
		this.possiveis_escolhas = pedidos;
	}
	
	public Materia getPossiveisEscolhasAt (int i) {
		return this.possiveis_escolhas.listaGetAt(i);
	}
	
	public void setPossiveisEscolhasAt(Materia nova_materia, int i) {
		this.possiveis_escolhas.inserirEm(nova_materia, i);
	}
	
	public void setPossiveisEscolhas(Materia nova_materia) {
		this.possiveis_escolhas.inserir(nova_materia);
	}
	
	public void removePossiveisEscolhasAt (int i) {
		this.possiveis_escolhas.removerEm(i);
	}	
	
	// --------------------------------------
	//
	//	FUNCOES LISTA MATERIAS
	//
	// --------------------------------------
	public ListaMateria getLista_materia() {
		return lista_materia;
	}

	public void setLista_materia(ListaMateria lista_materia) {
		this.lista_materia = lista_materia;
	}
	
	// ---------------------------------
	//
	//	FUNCOES DE MAT ALUNO
	//
	// ----------------------------------
	public ListaMateriaAluno getMat_aluno() {
		return mat_aluno;
	}
	
	public void setMat_aluno(ListaMateriaAluno mat_aluno) {
		this.mat_aluno = mat_aluno;
	}

	// -------------------------------------
	//
	// FUNCOES POS REPROVADAS
	//
	// --------------------------------------
	public int getPos_reprovadasAt(int pos){
		return this.pos_reprovadas.get(pos);
	}

	public Vector<Integer> getPos_reprovadas() {
		return pos_reprovadas;
	}

	public void setPos_reprovadas(Vector<Integer> pos_reprovadas) {
		this.pos_reprovadas = pos_reprovadas;
	}

	public void inserirAt (int pos){
		this.pos_reprovadas.add(pos);
	} 
	
	// --------------------------------
	//
	// FUNCOES MAIORES 
	//
	// --------------------------------
	/**
	 * Procura quais matérias o aluno já fez. Caso não encontre, coloca matéria
	 * 		em uma lista de matérias que serão ofertadas ao aluno.
	 */
	public void procuraMateriaAluno () {
		for (int i = 0; i < this.lista_materia.getLista().size(); i++) {
			Materia mat = this.lista_materia.getLista().elementAt(i);
			if (! this.mat_aluno.procurarMateriaBool(mat.getCodigoMateria()));
				this.setPossiveisPedidos(mat);
		}
	}

	/** Imprime matérias que podem ser cursadas pelo aluno. */		
	public void imprimirPossiveisMateria() {
		for (int i = 0; i < this.pedidos.tamanhoLista(); i++) {
			System.out.println(this.getPossiveisPedidosAt(i).getNome());
			System.out.println(this.getPossiveisPedidosAt(i).getCodigoMateria());
			System.out.println(this.getPossiveisPedidosAt(i).getCodigoCurso());
			System.out.println(this.getPossiveisPedidosAt(i).getHoras());
			System.out.println(this.getPossiveisPedidosAt(i).getPeriodo());
			System.out.println(this.getPossiveisPedidosAt(i).getTipo());
			System.out.println(this.getPossiveisPedidosAt(i).getVersao());
		}
	}

	/**
	 * Retorna IRA do aluno.
	 *
	 * @return IRA do aluno
	 */
	public float ira() {
		float indice = 0, total = 0, nota = 0, horas = 0;

		for (int i = 0; i < mat_aluno.tamanhoLista(); i++) {
			if (!mat_aluno.listaGetAt(i).getSituacao().equals("Matricula")){
				if (mat_aluno.listaGetAt(i).getFrequencia() < 75){
					
					horas = mat_aluno.listaGetAt(i).getHoras();
					total += 100 * horas;
				}
				else {
					horas = mat_aluno.listaGetAt(i).getHoras();
					nota = mat_aluno.listaGetAt(i).getNota();
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
	public int materiaReprovadas() {
		int contador = 0;
		
		for (int i = 0; i < this.mat_aluno.tamanhoLista(); i++){
			if (this.mat_aluno.listaGetAt(i).getSituacao().equals("Reprovado por nota"))
				if (this.mat_aluno.listaGetAt(i).getSemestre() == 3)
					contador++;
			else if (this.mat_aluno.listaGetAt(i).getSituacao().equals("Reprovado por Frequência"))
				if (this.mat_aluno.listaGetAt(i).getSemestre() == 3)
					contador++;
		}
		return contador;
	} 

	/** Remove os pedidos que o aluno fez */
	public void removePedidos (){
		while (this.pedidos.tamanhoLista() > 3){
			this.mat_aluno.removeUltimo();
		}
	}


	/**
	 * Insere no vetor de posições as matérias que o aluno reprovou
	*/
	public void posicoesMateriasReprovadas (){
		for (int i = 0; i < this.mat_aluno.tamanhoLista(); i++){
			
			//Caso o aluno tenha reprovado ou por falta ou por nota
			if (this.mat_aluno.listaGetAt(i).getCodSituacao() == 2 || this.mat_aluno.listaGetAt(i).getCodSituacao() == 3) {
				this.inserirAt(i);
			}
		}
	}

	/**
	 * Analiza pedido de matérias do aluno, remove pedidos se cair em um dos
	 * 		seguintes casos (em relação ao período anterior):
	 * - Caso A: reprovado em mais de 2/3 e efetua mais de 5 pedidos 
	 * - Caso B: reprovado entre 1/3 a 2/3 e efetua mais de 4 pedidos
	 * - Caso C: reprovado em menos que 1/3 e efetua mais de 3 pedidos
	 */
	public void analizarPedido () {

		int reprovadas = this.materiaReprovadas();
		float desempenho = reprovadas / 5;

		
		// faltantes eh uma lista com as materias faltantes do aluno ,quando ela estiver vazia
		// significa que o aluno ja escolheu todas as materias prebarreia e assim, pode pedir a quebra
		//faltantes é gerado com o metodo this.preencheFaltantes
		if (faltantes.tamanhoLista() == 0) {
			if (this.ira() < 0.8) {	
				for (int i = 0; i < this.pedidos.tamanhoLista(); i++){
	
					// Caso C
					if ( desempenho < 0.33 ) {
						if (this.pedidos.tamanhoLista() > 3) {
							this.removePedidos();
						}
					}
	
					// Caso B
					if ( desempenho >= 0.33 && desempenho < 0.66){
						if (this.pedidos.tamanhoLista() > 4) {
							this.removePedidos();
						}
					}
					else // Caso A
						if (this.pedidos.tamanhoLista() > 5)
							this.removePedidos();
				}
			}
		}
	}

	/**
	 * Transforma a lista de matéria num Vector<Vector<Materia>>.
	 *
	 * @return um Vector<Vector<Materia>>. Basicamente uma tabela com todas as matérias.
	 */
	/*public Vector<Vector<String>> tabelaMateria() {
		/*Vector<Vector<String>> tabela_materia = new Vector<Vector<String>>(8);
		Vector<String> semestre1 = new Vector<String>();
		Vector<String> semestre2 = new Vector<String>();
		Vector<String> semestre3 = new Vector<String>();
		Vector<String> semestre4 = new Vector<String>();
		Vector<String> semestre5 = new Vector<String>();
		Vector<String> semestre6 = new Vector<String>();
		Vector<String> semestre7 = new Vector<String>();
		Vector<String> semestre8 = new Vector<String>();
		for (int i = 0; i < this.possiveis_escolhas.tamanhoLista(); i++) {
			switch (this.possiveis_escolhas.listaGetAt(i).getPeriodo()) {
			case 1:
				semestre1.add(this.possiveis_escolhas.listaGetAt(i).getNome());
				break;
			case 2:
				semestre2.add(this.possiveis_escolhas.listaGetAt(i).getNome());
				break;
			case 3:
				semestre3.add(this.possiveis_escolhas.listaGetAt(i).getNome());
				break;
			case 4:
				semestre4.add(this.possiveis_escolhas.listaGetAt(i).getNome());
				break;
			case 5:
				semestre5.add(this.possiveis_escolhas.listaGetAt(i).getNome());
				break;
			case 6:
				semestre6.add(this.possiveis_escolhas.listaGetAt(i).getNome());
				break;
			case 7:
				semestre7.add(this.possiveis_escolhas.listaGetAt(i).getNome());
				break;
			case 8:
				semestre8.add(this.possiveis_escolhas.listaGetAt(i).getNome());
				break;
			default:
				break;
			}	
		}
		tabela_materia.add(semestre1);	
		tabela_materia.add(semestre2);	
		tabela_materia.add(semestre3);	
		tabela_materia.add(semestre4);	
		tabela_materia.add(semestre5);	
		tabela_materia.add(semestre6);	
		tabela_materia.add(semestre7);	
		tabela_materia.add(semestre8);
		return tabela_materia;
	}*/
	
	public String[][] tabelaMateria() {
		String tabela_materia[][] = new String[7][9];
		int colunas[] = {1, 1, 1, 1, 1, 1, 1, 1, 1}; 
		for(int i = 0; i < 8; i++)
			tabela_materia[0][i] = (i+1) + "º PERIODO";
		// AQUI ESTÁ GUILHERME
		for (int i = 0; i < this.possiveis_escolhas.tamanhoLista(); i++) {
			int j = this.possiveis_escolhas.listaGetAt(i).getPeriodo();
			tabela_materia[colunas[j]][j - 1] = this.possiveis_escolhas.listaGetAt(i).getNome() ;
			colunas[j]++;
		}	
		return tabela_materia;
	}
	
	public String[][] tabelaMateriaFeitas() {
		String tabela_materia[][] = new String[7][9];
		int colunas[] = {1, 1, 1, 1, 1, 1, 1, 1, 1}; 
		for(int i = 0; i < 8; i++)
			tabela_materia[0][i] = (i+1) + "º PERIODO";
		// AQUI ESTÁ GUILHERME
		for (int i = 0; i < this.mat_aluno.tamanhoLista(); i++) {
			int j = this.mat_aluno.listaGetAt(i).getPeriodo();
			if(this.mat_aluno.listaGetAt(i).getCodSituacao() == 1) {
				tabela_materia[colunas[j]][j-1] = this.mat_aluno.listaGetAt(i).getNome() ;
				colunas[j]++;
			}	
		}	
		return tabela_materia;
	}
	
	public String[][] tabelaMateriapedidas() {
		String tabela_materia[][] = new String[7][9];
		int colunas[] = {1, 1, 1, 1, 1, 1, 1, 1, 1}; 
		for(int i = 0; i < 8; i++)
			tabela_materia[0][i] = (i+1) + "º PERIODO";
		// AQUI ESTÁ GUILHERME
		for (int i = 0; i < this.pedidos.tamanhoLista(); i++) {
			int j = this.pedidos.listaGetAt(i).getPeriodo();
			tabela_materia[colunas[j]][j-1] = this.pedidos.listaGetAt(i).getNome() ;
			colunas[j]++;
		}	
		return tabela_materia;
	}
	

	/**
	 * Preenche lista de possíveis escolhas de matérias com base em matérias
	 * 		ainda não cursadas.
	 */
	public void possiveisPedidos() {
		for (int i = 0; i < this.lista_materia.tamanhoLista(); i++) {
			String code_materia = this.lista_materia.listaGetAt(i).getCodigoMateria();
			boolean fez = false;
			int pos_materia = 0;

			for (int j = 0; j < this.mat_aluno.tamanhoLista(); j++){
				String materias_cursadas = this.mat_aluno.listaGetAt(j).getCodigoMateria();
				if (code_materia.equals(materias_cursadas)) {
					fez = true;
					pos_materia = j;
				}
			}

			if (!fez) {
				if (this.lista_materia.listaGetAt(i).getPeriodo() != 0 && this.lista_materia.listaGetAt(i).getHoras() != 150)
					this.possiveis_escolhas.inserir(this.lista_materia.listaGetAt(i));
			}	
			else {
				if (this.mat_aluno.listaGetAt(pos_materia).getCodSituacao() == 2 || this.mat_aluno.listaGetAt(pos_materia).getCodSituacao() == 3)
					this.possiveis_escolhas.inserir(this.lista_materia.listaGetAt(i));				
			}
		}
	}
	
	public void preencheFaltantes() {
		for (int i = 0; i < this.lista_materia.tamanhoLista(); i++) {
			if((this.lista_materia.listaGetAt(i).getPeriodo() < 4) && (this.lista_materia.listaGetAt(i).getPeriodo() != 0 )) {
				this.faltantes.inserir(lista_materia.listaGetAt(i));
			}	
		}
		for (int i = 0; i < this.faltantes.tamanhoLista(); i++) {
			String code_materia = this.faltantes.listaGetAt(i).getCodigoMateria();
			for (int j = 0; j < this.mat_aluno.tamanhoLista(); j++){
				String materias_cursadas = this.mat_aluno.listaGetAt(j).getCodigoMateria();
				if (code_materia.equals(materias_cursadas)) {
					if (this.mat_aluno.listaGetAt(j).getCodSituacao() == 1 ) {
						this.faltantes.removerEm(i);
						i--;
					}
				}
			}
		}
	}
	
}
