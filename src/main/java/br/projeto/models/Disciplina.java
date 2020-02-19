package br.projeto.models;

import aima.core.search.csp.Variable;

public class Disciplina extends Variable {

	public Disciplina(String codigo, String name, int carga) {
		super(name);
		this.codigo = codigo;
		this.cargaHoraria = carga;
		number = carga / 30;
	}

//	private String nome;
	private String codigo;
	private Docente docente;
	private int cargaHoraria;
	private int number;
	private String horario;

//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Boolean numberAlt() {
		if (this.number > 0) {
			this.number--;
			return true;
		}
		return false;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "("+this.getName()+"="+"Docente:"+docente+")";
	}
	
	

}
