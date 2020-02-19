package br.projeto.csp.horario;

import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;

public class Horario extends Variable{
	
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

}
