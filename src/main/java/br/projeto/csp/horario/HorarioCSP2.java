package br.projeto.csp.horario;

import java.util.List;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;

public class HorarioCSP2 extends CSP<Variable, Disciplina> {

	public HorarioCSP2(List<Variable> list,Domain<Disciplina> horarios) {

		super(list);

		for (Variable var : getVariables())
			setDomain(var, horarios);
		
		for (int i =0;i<list.size();i=i+2) {
			addConstraint(new EqualConstraint<>(list.get(i), list.get(i+1)));
		}
		
		// 246T12
		addConstraint(new EqualConstraint<>(list.get(0), list.get(12)));
		addConstraint(new EqualConstraint<>(list.get(24), list.get(12)));

		addConstraint(new AnotherDepartConstraint<>(list.get(0), horarios.get(6)));
		
//		for( int i = 0;i < list.size();i++) {
//			addConstraint(new WorkloadConstraint<>(list.get(i)));	
//		}
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
		
		
//		// SEGUNDA
//		addConstraint(new EqualConstraint<>(SEG1, SEG2));
//		addConstraint(new EqualConstraint<>(SEG3, SEG4));
//		addConstraint(new EqualConstraint<>(SEG5, SEG6));
//		// TERÇA
//		addConstraint(new EqualConstraint<>(TER1, TER2));
//		addConstraint(new EqualConstraint<>(TER3, TER4));
//		addConstraint(new EqualConstraint<>(TER5, TER6));
//		// QUARTA
//		addConstraint(new EqualConstraint<>(QUA1, QUA2));
//		addConstraint(new EqualConstraint<>(QUA3, QUA4));
//		addConstraint(new EqualConstraint<>(QUA5, QUA6));
//		// QUINTA
//		addConstraint(new EqualConstraint<>(QUI1, QUI2));
//		addConstraint(new EqualConstraint<>(QUI3, QUI4));
//		addConstraint(new EqualConstraint<>(QUI5, QUI6));
//		// SEXTA
//		addConstraint(new EqualConstraint<>(SEX1, SEX2));
//		addConstraint(new EqualConstraint<>(SEX3, SEX4));
//		addConstraint(new EqualConstraint<>(SEX5, SEX6));

	}

}
