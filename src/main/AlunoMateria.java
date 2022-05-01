package main;

/** Vincula matéria a aluno. */
public class AlunoMateria extends Materia {
	/** nota do aluno na matéria */
	private int nota;
	/** frequência do aluno na matéria */
	private int frequencia;
	/** situação do aluno na matéria (Aprovado, Reprovado por Nota,
	 *		Reprovado por Frequência) 
	 */
	private String situacao;
	/** semestre em que a matéria foi ou está sendo cursada pelo aluno */
	private int semestre = -1;

	private int codSituacao;
	
	public AlunoMateria() {
	}

	public AlunoMateria(String codigoCurso, int versao, String codigoMateria, String nome, int periodo, String tipo,
			int horas, int nota, int frequencia, String situacao, int semestre, int codSituacao) {
		super(codigoCurso, versao, codigoMateria, nome, periodo, tipo, horas);
		this.nota = nota;
		this.frequencia = frequencia;
		this.situacao = situacao;
		this.semestre = semestre;
		this.codSituacao = codSituacao;
	}

	public int getSemestre(){
		return semestre;
	}

	public void setSemestre(int semestre){
		this.semestre = semestre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return (this.getCodigoCurso() + "," + this.getCodigoMateria() + "," + this.getHoras() + "," + this.getNome()
				+ "," + this.getPeriodo() + "," + this.getTipo() + "," + this.getVersao() + "," + this.getNota() + ","
				+ this.getFrequencia() + "," + this.getSituacao() +","+ this.getSemestre() +"," + this.getCodSituacao());
	}

	public int getCodSituacao() {
		return codSituacao;
	}

	public void setCodSituacao(int codSituacao) {
		this.codSituacao = codSituacao;
	}
}
