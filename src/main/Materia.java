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
	 * Retorna código do curso.
	 *
	 * @return código do curso
	 */
	public String getCodigoCurso() {
		return codigoCurso;
	}

	/** 
	 * Seta código do curso.
	 *
	 * @param codigoCurso
	 */
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	/**
	 * Retorna versão da matéria.
	 *
	 * @return versão da matéria
	 */
	public int getVersao() {
		return versao;
	}

	/** 
	 * Seta versão da matéria.
	 *
	 * @param versao
	 */
	public void setVersao(int versao) {
		this.versao = versao;
	}

	/**
	 * Retorna código da matéria.
	 *
	 * @return código da matéria
	 */
	public String getCodigoMateria() {
		return codigoMateria;
	}

	/** 
	 * Seta código da matéria.
	 *
	 * @param codigoMateria
	 */
	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	/**
	 * Retorna nome da matéria.
	 *
	 * @return nome da matéria
	 */
	public String getNome() {
		return nome;
	}

	/** 
	 * Seta nome da matéria.
	 *
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna periodo da matéria.
	 *
	 * @return periodo da matéria
	 */
	public int getPeriodo() {
		return periodo;
	}

	/** 
	 * Seta periodo da matéria.
	 *
	 * @param periodo
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	/**
	 * Retorna tipo da matéria.
	 *
	 * @return tipo da matéria
	 */
	public String getTipo() {
		return tipo;
	}

	/** 
	 * Seta tipo da matéria.
	 *
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Retorna horas totais na matéria.
	 *
	 * @return horas totais na matéria
	 */
	public int getHoras() {
		return horas;
	}

	/** 
	 * Seta horas totais na matéria
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
