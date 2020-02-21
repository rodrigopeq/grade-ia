package br.projeto.csp.horario;

import java.util.List;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;
import br.projeto.models.Horario;

public class HorarioCSP extends CSP<Horario, Disciplina> {

	public HorarioCSP(List<Horario> horarios,Domain<Disciplina> disciplinas) {

		super(horarios);

		for (Variable var : getVariables())
			setDomain((Horario)var, disciplinas);
		
		for (int i =0;i<horarios.size();i=i+2) {
			addConstraint(new EqualConstraint<>(horarios.get(i), horarios.get(i+1)));
		}
		
		// 246T12
		addConstraint(new EqualConstraint<>(horarios.get(0), horarios.get(12)));
		addConstraint(new EqualConstraint<>(horarios.get(24), horarios.get(12)));

		addConstraint(new AnotherDepartConstraint<>(horarios.get(0), disciplinas.get(6)));
		
		addConstraint(new WorkloadConstraint<>(horarios.get(2)));
		addConstraint(new WorkloadConstraint<>(horarios.get(4)));
		addConstraint(new WorkloadConstraint<>(horarios.get(6)));
		addConstraint(new WorkloadConstraint<>(horarios.get(8)));
		addConstraint(new WorkloadConstraint<>(horarios.get(10)));
		addConstraint(new WorkloadConstraint<>(horarios.get(14)));
		addConstraint(new WorkloadConstraint<>(horarios.get(16)));
		addConstraint(new WorkloadConstraint<>(horarios.get(18)));
		addConstraint(new WorkloadConstraint<>(horarios.get(20)));
		addConstraint(new WorkloadConstraint<>(horarios.get(22)));
		addConstraint(new WorkloadConstraint<>(horarios.get(26)));
		addConstraint(new WorkloadConstraint<>(horarios.get(28)));
	}

}
