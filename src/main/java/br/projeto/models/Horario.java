package br.projeto.models;

import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;

public class Horario extends Variable {

	private Disciplina disciplina;

	public Horario(String name) {
		super(name);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.getName());
		return result.toString();
	}

}
