package br.projeto.csp.horario;

import java.util.Optional;

import aima.core.search.csp.CspListener;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;
import aima.core.search.csp.*;
//import csp.solver.*;

public class MainCSPHorario {
	
	public static void main(String[] args) {
	CSP<Variable, Disciplina> csp = new HorarioCSP5();
	CspListener.StepCounter<Variable, Disciplina> stepCounter = new CspListener.StepCounter<>();
	CspSolver<Variable, Disciplina> solver;
	Optional<Assignment<Variable, Disciplina>> solution;
	
	solver = new MinConflictsSolver<>(1000);
	solver.addCspListener(stepCounter);
	stepCounter.reset();
	System.out.println("Map Coloring (Minimum Conflicts)");
	solution = solver.solve(csp);
	solution.ifPresent(System.out::println);
	System.out.println(stepCounter.getResults() + "\n");
		
//		CSPHorario<Variable, Disciplina> csp = new HorarioCSP5();
//		CspListenerHorario.StepCounter<Variable, Disciplina> stepCounter = new CspListenerHorario.StepCounter<>();
//		CspSolverHorario<Variable, Disciplina> solver;
//		Optional<AssignmentHorario<Variable, Disciplina>> solution;
//		
//		solver = new MinConflictsSolverHorario<>(1000);
//		solver.addCspListener(stepCounter);
//		stepCounter.reset();
//		System.out.println("Map Coloring (Minimum Conflicts)");
//		solution = solver.solve(csp);
//		solution.ifPresent(System.out::println);
//		System.out.println(stepCounter.getResults() + "\n");
	}
}
