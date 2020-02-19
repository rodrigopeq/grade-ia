package br.projeto.csp.horario;

import java.util.List;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;
import br.projeto.models.Horario;

public class HorarioCSP extends CSP<Horario, Disciplina> {

	public HorarioCSP(List<Horario> list,Domain<Disciplina> horarios) {

		super(list);

		for (Variable var : getVariables())
			setDomain((Horario)var, horarios);
		
		for (int i =0;i<list.size();i=i+2) {
			addConstraint(new EqualConstraint<>(list.get(i), list.get(i+1)));
		}
		
		// 246T12
		addConstraint(new EqualConstraint<>(list.get(0), list.get(12)));
		addConstraint(new EqualConstraint<>(list.get(24), list.get(12)));

		addConstraint(new AnotherDepartConstraint<>(list.get(0), horarios.get(6)));
		
		addConstraint(new WorkloadConstraint<>(list.get(2)));
		addConstraint(new WorkloadConstraint<>(list.get(4)));
		addConstraint(new WorkloadConstraint<>(list.get(6)));
		addConstraint(new WorkloadConstraint<>(list.get(8)));
		addConstraint(new WorkloadConstraint<>(list.get(10)));
		addConstraint(new WorkloadConstraint<>(list.get(14)));
		addConstraint(new WorkloadConstraint<>(list.get(16)));
		addConstraint(new WorkloadConstraint<>(list.get(18)));
		addConstraint(new WorkloadConstraint<>(list.get(20)));
		addConstraint(new WorkloadConstraint<>(list.get(22)));
		addConstraint(new WorkloadConstraint<>(list.get(26)));
		addConstraint(new WorkloadConstraint<>(list.get(28)));
	}

}
