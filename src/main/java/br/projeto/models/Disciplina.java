package br.projeto.models;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Variable;

public class Disciplina extends Variable {

	public Disciplina(String codigo, String name, int carga) {
		super(name);
		this.codigo = codigo;
		this.cargaHoraria = carga;
		this.horario = new ArrayList<>();
	}

	private String codigo;
	private Docente docente;
	private int cargaHoraria;
	private List<Horario> horario;

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


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "("+this.getName()+"="+"Docente:"+docente+"=="+"Horario"+this.horario+")";
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}
	
	public void addHorario(Horario horario) {
		if(this.horario.size() < cargaHoraria/15)
			this.horario.add(horario);
	}
	
	

}
