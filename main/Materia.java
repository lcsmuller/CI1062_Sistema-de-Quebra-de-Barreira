package main;

/** Mat�ria disponibilizada no curso */
public class Materia {
	/** c�digo �nico do curso em que a mat�ria � ofertada */
	private String codigoCurso;
	/** @todo */
	private int versao;
	/** c�digo �nico da mat�ria */
	private String codigoMateria;
	/** nome da mat�ria */
	private String nome;
	/** periodo em que a mat�ria � ofertada */
	private int periodo;
	/** @todo */
	private String tipo;
	/** @todo */
	private int horas;

	/** Construtor para { @link Materia }. */
	public Materia() {
	}

	/**
	 * Construtor para { @link Materia }.
	 *
	 * @param codigoCurso
	 * @param versao
	 * @param codigoMateria
	 * @param nome
	 * @param periodo
	 * @param tipo
	 * @param horas
	 */
	public Materia(String codigoCurso, int versao, String codigoMateria,
				   String nome, int periodo, String tipo, int horas)
	{
		this.codigoCurso = codigoCurso;
		this.versao = versao;
		this.codigoMateria = codigoMateria;
		this.nome = nome;
		this.periodo = periodo;
		this.tipo = tipo;
		this.horas = horas;
	}

	/**
	 * Retorna c�digo do curso.
	 *
	 * @return c�digo do curso
	 */
	public String getCodigoCurso() {
		return codigoCurso;
	}

	/** 
	 * Seta c�digo do curso.
	 *
	 * @param codigoCurso
	 */
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	/**
	 * Retorna vers�o da mat�ria.
	 *
	 * @return vers�o da mat�ria
	 */
	public int getVersao() {
		return versao;
	}

	/** 
	 * Seta vers�o da mat�ria.
	 *
	 * @param versao
	 */
	public void setVersao(int versao) {
		this.versao = versao;
	}

	/**
	 * Retorna c�digo da mat�ria.
	 *
	 * @return c�digo da mat�ria
	 */
	public String getCodigoMateria() {
		return codigoMateria;
	}

	/** 
	 * Seta c�digo da mat�ria.
	 *
	 * @param codigoMateria
	 */
	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	/**
	 * Retorna nome da mat�ria.
	 *
	 * @return nome da mat�ria
	 */
	public String getNome() {
		return nome;
	}

	/** 
	 * Seta nome da mat�ria.
	 *
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna periodo da mat�ria.
	 *
	 * @return periodo da mat�ria
	 */
	public int getPeriodo() {
		return periodo;
	}

	/** 
	 * Seta periodo da mat�ria.
	 *
	 * @param periodo
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	/**
	 * Retorna tipo da mat�ria.
	 *
	 * @return tipo da mat�ria
	 */
	public String getTipo() {
		return tipo;
	}

	/** 
	 * Seta tipo da mat�ria.
	 *
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Retorna horas totais na mat�ria.
	 *
	 * @return horas totais na mat�ria
	 */
	public int getHoras() {
		return horas;
	}

	/** 
	 * Seta horas totais na mat�ria
	 *
	 * @param horas
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * Converte Materia para String.
	 *
	 * @return Materia representado em String.
	 */
	public String toString() {
		return (this.codigoCurso + "," + this.codigoMateria + "," + this.horas + ","
				+ this.nome + "," + this.periodo + "," + this.tipo + "," + this.versao);
	}
}
