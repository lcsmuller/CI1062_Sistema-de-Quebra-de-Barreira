package main;

/** Vincula matéria a aluno. */
public class AlunoMateria extends Materia {
	/** nota do aluno na matéria */
	private int nota;
	/** frequência do aluno na matéria */
	private int frequencia;
	/** situação do aluno na matéria (Aprovado, Reprovado por Nota,
	 *		Reprovado por Frequência) */
	private String situacao;
	/** semestre em que a matéria foi ou está sendo cursada pelo aluno */
	private int semestre = -1;
	/** código da situação do aluno na matéria */
	private int codSituacao;
	
	/** Construtor para { @link AlunoMateria } */
	public AlunoMateria() {
	}

	/**
	 * Retorna semestre da matéria.
	 *
	 * @return semestre do aluno 
	 */
	public int getSemestre(){
		return semestre;
	}

	/** 
	 * Seta semestre da matéria.
	 *
	 * @param semestre
	 */
	public void setSemestre(int semestre){
		this.semestre = semestre;
	}

	/**
	 * Retorna nota do aluno na matéria.
	 *
	 * @return nota do aluno na matéria
	 */
	public int getNota() {
		return nota;
	}

	/** 
	 * Seta nota da matéria.
	 *
	 * @param nota
	 */
	public void setNota(int nota) {
		this.nota = nota;
	}

	/**
	 * Retorna frequência do aluno na matéria.
	 *
	 * @return frequência do aluno na matéria
	 */
	public int getFrequencia() {
		return frequencia;
	}

	/**
	 * Seta frequência na matéria.
	 *
	 * @param frequencia
	 */
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	/**
	 * Retorna situação do aluno na matéria.
	 *
	 * @return situação do aluno na matéria
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * Seta situação do aluno na matéria.
	 *
	 * @param situacao
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	/**
	 * Retorna código de situação do aluno na matéria.
	 *
	 * @return código de situação do aluno na matéria
	 */
	public int getCodSituacao() {
		return codSituacao;
	}

	/**
	 * Seta código da situação do aluno na matéria.
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
