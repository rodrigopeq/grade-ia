package br.projeto.csp.horario;
import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;

public class WorkloadConstraint<VAR extends Variable, VAL> implements Constraint<VAR, VAL> {

	private VAR var1;
	private List<VAR> scope;

	public WorkloadConstraint(VAR var1) {
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
		Disciplina value = null;
		if (value1==null){
			return true;
		}
		else {
			int count = 0;
			for(VAR di : assignment.getVariables()) {
				value = (Disciplina) assignment.getValue(di);
				if(value.getCodigo().equals(value1.getCodigo())) {
					count++;
				}
			}
			if(count <= value.getCargaHoraria()/15)
				return true;
		}
		return false;
		
		
//		return value1 == null || value1.equals(assignment.getValue(var2));
	}
}
