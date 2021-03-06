package br.projeto.base;

import aima.core.search.csp.*;
import aima.core.search.csp.examples.MapCSP;

import java.util.Optional;

public class Example {
	public static void main(String[] args) {
		CSP<Variable, String> csp = new MapCSP();
		CspListener.StepCounter<Variable, String> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, String> solver;
		Optional<Assignment<Variable, String>> solution;
		
		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Minimum Conflicts)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, String>().setAll();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Backtracking + MRV & DEG + LCV + AC3)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");

		solver = new FlexibleBacktrackingSolver<Variable, String>().set(CspHeuristics.mrvDeg());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Backtracking + MRV & DEG)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Backtracking)");
		solution = solver.solve(csp);
		solution.ifPresent(System.out::println);
		System.out.println(stepCounter.getResults() + "\n");
	}
}

