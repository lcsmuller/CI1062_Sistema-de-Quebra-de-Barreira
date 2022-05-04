package main;

/** Matéria disponibilizada no curso */
public class Materia {
	/** código único do curso em que a matéria é ofertada */
	private String codigoCurso;
	/** @todo */
	private int versao;
	/** código único da matéria */
	private String codigoMateria;
	/** nome da matéria */
	private String nome;
	/** periodo em que a matéria é ofertada */
	private int periodo;
	/** @todo */
	private String tipo;
	/** @todo */
	private int horas;

	public Materia() {
	}

	public Materia(String codigoCurso, int versao, String codigoMateria, String nome, int periodo, String tipo,
			int horas) {
		this.codigoCurso = codigoCurso;
		this.versao = versao;
		this.codigoMateria = codigoMateria;
		this.nome = nome;
		this.periodo = periodo;
		this.tipo = tipo;
		this.horas = horas;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String toString() {
		return (this.getCodigoCurso() + "," + this.getCodigoMateria() + "," + this.getHoras() + ","
				+ this.getNome() + "," + this.getPeriodo() + "," + this.getTipo() + "," + this.getVersao());
	}
}
