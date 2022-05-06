package main;

/** Vincula mat�ria a aluno. */
public class AlunoMateria extends Materia {
	/** nota do aluno na mat�ria */
	private int nota;
	/** frequ�ncia do aluno na mat�ria */
	private int frequencia;
	/** situa��o do aluno na mat�ria (Aprovado, Reprovado por Nota,
	 *		Reprovado por Frequ�ncia) */
	private String situacao;
	/** semestre em que a mat�ria foi ou est� sendo cursada pelo aluno */
	private int semestre = -1;
	/** c�digo da situa��o do aluno na mat�ria */
	private int codSituacao;
	
	/** Construtor para { @link AlunoMateria } */
	public AlunoMateria() {
	}

	/**
	 * Retorna semestre da mat�ria.
	 *
	 * @return semestre do aluno 
	 */
	public int getSemestre(){
		return semestre;
	}

	/** 
	 * Seta semestre da mat�ria.
	 *
	 * @param semestre
	 */
	public void setSemestre(int semestre){
		this.semestre = semestre;
	}

	/**
	 * Retorna nota do aluno na mat�ria.
	 *
	 * @return nota do aluno na mat�ria
	 */
	public int getNota() {
		return nota;
	}

	/** 
	 * Seta nota da mat�ria.
	 *
	 * @param nota
	 */
	public void setNota(int nota) {
		this.nota = nota;
	}

	/**
	 * Retorna frequ�ncia do aluno na mat�ria.
	 *
	 * @return frequ�ncia do aluno na mat�ria
	 */
	public int getFrequencia() {
		return frequencia;
	}

	/**
	 * Seta frequ�ncia na mat�ria.
	 *
	 * @param frequencia
	 */
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	/**
	 * Retorna situa��o do aluno na mat�ria.
	 *
	 * @return situa��o do aluno na mat�ria
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * Seta situa��o do aluno na mat�ria.
	 *
	 * @param situacao
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	/**
	 * Retorna c�digo de situa��o do aluno na mat�ria.
	 *
	 * @return c�digo de situa��o do aluno na mat�ria
	 */
	public int getCodSituacao() {
		return codSituacao;
	}

	/**
	 * Seta c�digo da situa��o do aluno na mat�ria.
	 *
	 * @param codSituacao
	 */
	public void setCodSituacao(int codSituacao) {
		this.codSituacao = codSituacao;
	}
	
	/**
	 * Converte AlunoMateria para String.
	 *
	 * @return AlunoMateria representado em String.
	 */
	@Override
	public String toString() {
		return (super.toString() + "," + this.nota + ","
				+ this.frequencia + "," + this.situacao + ","+ this.semestre + "," + this.codSituacao);
	}

}
