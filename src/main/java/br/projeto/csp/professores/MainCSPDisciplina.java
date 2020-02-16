package br.projeto.csp.professores;

import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspHeuristics;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;
import br.projeto.models.Docente;

public class MainCSPDisciplina {

	public static void main(String[] args) {
		CSP<Disciplina, Docente> csp = new DisciplinaCSP();
		CspListener.StepCounter<Disciplina, Docente> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Disciplina, Docente> solver;
		Optional<Assignment<Disciplina, Docente>> solution;
		
		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Minimum Conflicts)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
//		System.out.println(solution.get().getVariables().toString());
		
//		solver = new FlexibleBacktrackingSolver<Disciplina, Docente>().setAll();
//		solver.addCspListener(stepCounter);
//		stepCounter.reset();
//		System.out.println("Map Coloring (Backtracking + MRV & DEG + LCV + AC3)");
//		solution = solver.solve(csp);
//		solution.ifPresent(System.out::println);
//		System.out.println(stepCounter.getResults() + "\n");
//
//		solver = new FlexibleBacktrackingSolver<Disciplina, Docente>().set(CspHeuristics.mrvDeg());
//		solver.addCspListener(stepCounter);
//		stepCounter.reset();
//		System.out.println("Map Coloring (Backtracking + MRV & DEG)");
//		solution = solver.solve(csp);
//		solution.ifPresent(System.out::println);
//		System.out.println(stepCounter.getResults() + "\n");
//		
//		solver = new FlexibleBacktrackingSolver<>();
//		solver.addCspListener(stepCounter);
//		stepCounter.reset();
//		System.out.println("Map Coloring (Backtracking)");
//		solution = solver.solve(csp);
//		solution.ifPresent(System.out::println);
//		System.out.println(stepCounter.getResults() + "\n");

	}

}
