package br.projeto.csp.professores;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import br.projeto.models.Docente;

public class PreferencesConstraint<VAR extends Variable, VAL> implements Constraint<VAR, VAL> {

	private VAR var1;
	private List<VAR> scope;

	public PreferencesConstraint(VAR var1) {
		this.var1 = var1;
		scope = new ArrayList<>(2);
		scope.add(var1);
	}

	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		VAL value1 = assignment.getValue(var1);
		if (value1 == null) {
			return true;
		}
		try {
			Docente d1 = (Docente) value1;
			return d1.getPreferencias().contains(var1);
		} catch (Exception ex) {
			return false;
		}

	}
}
