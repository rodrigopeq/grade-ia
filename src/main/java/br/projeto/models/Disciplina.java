package br.projeto.models;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Variable;

public class Disciplina extends Variable {

	public Disciplina(String codigo, String name, int carga, List<Horario> horario) {
		super(name);
		this.codigo = codigo;
		this.cargaHoraria = carga;
		this.horario = horario;
	}

	private String codigo;
	private Docente docente;
	private int cargaHoraria;
	private List<Horario> horario = new ArrayList<>();

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
		StringBuilder result = new StringBuilder();
//		result.append("(");
		result.append(this.getName());
//		if(docente!= null) {
//			result.append("==Docente:");
//			result.append(docente.toString());
//		}
//		result.append("==Horario:");
//		result.append(this.horario);
//		result.append("==Carga:");
//		result.append(this.cargaHoraria);
//		result.append(")");	
		return result.toString();
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
