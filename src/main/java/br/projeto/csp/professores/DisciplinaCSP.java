package br.projeto.csp.professores;

import java.util.Arrays;
import java.util.List;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;
import br.projeto.models.Docente;

public class DisciplinaCSP extends CSP<Disciplina, Docente> {

	

	public DisciplinaCSP(List<Disciplina> list,Domain<Docente> docentes) {

		super(list);

		for (Variable var : getVariables())
			setDomain((Disciplina) var, docentes);
		
		for(Disciplina di : list) {
			addConstraint(new PreferencesConstraint<Disciplina, Docente>(di));
		}
//		addConstraint(new PreferencesConstraint<Disciplina, Docente>(COMP0397));
//		addConstraint(new PreferencesConstraint<Disciplina, Docente>(COMP0427));
//		addConstraint(new PreferencesConstraint<Disciplina, Docente>(COMP0439));
//		addConstraint(new PreferencesConstraint<Disciplina, Docente>(COMP0455));
//		addConstraint(new PreferencesConstraint<Disciplina, Docente>(COMP0463));
//		addConstraint(new PreferencesConstraint<Disciplina, Docente>(COMP0470));
//		addConstraint(new PreferencesConstraint<Disciplina, Docente>(ELET0111));
		
		

		

	}

}
