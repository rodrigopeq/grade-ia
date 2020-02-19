package br.projeto.csp.horario;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;

public class TesteC<VAR extends Variable, VAL> implements Constraint<VAR, VAL> {

	private VAR var1;
	private List<VAR> scope;

	public TesteC(VAR var1) {
		this.var1 = var1;
		scope = new ArrayList<>(1);
		scope.add(var1);
	}

	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		Disciplina value1 = (Disciplina) assignment.getValue(var1);
		if(value1!=null) {
			int count = 0;
			for(VAR di : assignment.getVariables()) {
				Disciplina value = (Disciplina) assignment.getValue(di);
				if(value.getCodigo().equals(value.getCodigo())) {
					count++;
				}
			}
			if(count <= value1.getCargaHoraria()/30)
				return true;
		}
		return false;
		
//		return value1 == null || value1.equals(assignment.getValue(var2));
	}
}
