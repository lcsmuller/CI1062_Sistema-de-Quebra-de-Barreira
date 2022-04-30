package main;

public class AlunoMateria extends Materia {

	private int nota;
	private int frequencia;
	private String situacao;

	public AlunoMateria() {
	}

	public AlunoMateria(String codigoCurso, int versao, String codigoMateria, String nome, int periodo, String tipo,
			int horas, int nota, int frequencia, String situacao) {
		super(codigoCurso, versao, codigoMateria, nome, periodo, tipo, horas);
		this.nota = nota;
		this.frequencia = frequencia;
		this.situacao = situacao;
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
				+ this.getFrequencia() + "," + this.getSituacao());
	}
}
