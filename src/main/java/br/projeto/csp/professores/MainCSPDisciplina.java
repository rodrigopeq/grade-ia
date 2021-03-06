package br.projeto.csp.professores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.Domain;
import aima.core.search.csp.MinConflictsSolver;
import br.projeto.models.Disciplina;
import br.projeto.models.Docente;

public class MainCSPDisciplina {

	public static final Disciplina COMP0397 = new Disciplina("COMP0397", "PROGRAMAÇÃO PARALELA E CONCORRENTE", 60,
			new ArrayList<>());
	public static final Disciplina COMP0427 = new Disciplina("COMP0427", "INTELIGÊNCIA ARTIFICIAL", 60,
			new ArrayList<>());
	public static final Disciplina COMP0439 = new Disciplina("COMP0439", "ENGENHARIA DE SOFTWARE II", 60,
			new ArrayList<>());
	public static final Disciplina COMP0455 = new Disciplina("COMP0455", "BANCO DE DADOS I", 60, new ArrayList<>());
	public static final Disciplina COMP0463 = new Disciplina("COMP0463", "LABORATÓRIO DE REDES DE COMPUTADORES", 30,
			new ArrayList<>());
	public static final Disciplina COMP0470 = new Disciplina("COMP0470", "SISTEMAS DISTRIBUÍDOS", 60,
			new ArrayList<>());
	public static final Disciplina ELET0111 = new Disciplina("ELET0111", "ELETRÔNICA I", 90, new ArrayList<>());
	public static final Disciplina AAAA0000 = new Disciplina("", "XXXXXXXXXXXXXXXXXXXXXXXXX", 30, new ArrayList<>());

	public static final Docente PROF1 = new Docente("ADICINEIA");
	public static final Docente PROF2 = new Docente("ADIMILSON");
	public static final Docente PROF3 = new Docente("ALBERTO");
	public static final Docente PROF4 = new Docente("ANDRE");
	public static final Docente PROF5 = new Docente("ANTONIO");
	public static final Docente PROF6 = new Docente("BEATRIZ");
	public static final Docente PROF7 = new Docente("BRENO");
	public static final Docente PROF8 = new Docente("BRUNO");
	public static final Docente PROF9 = new Docente("CARLOS");
	public static final Docente PROF10 = new Docente("DANIEL");

	public static void main(String[] args) {
		List<Disciplina> list = Arrays.asList(COMP0397, COMP0427, COMP0439, COMP0455, COMP0463, COMP0470, ELET0111);
		PROF1.addPreferencias(COMP0397);
		PROF1.addPreferencias(COMP0427);
		PROF1.addPreferencias(COMP0439);

		PROF2.addPreferencias(COMP0455);

		PROF3.addPreferencias(COMP0463);
		PROF3.addPreferencias(COMP0470);

		PROF4.addPreferencias(COMP0397);
		PROF4.addPreferencias(COMP0427);

		PROF5.addPreferencias(COMP0439);

		PROF6.addPreferencias(COMP0455);

		PROF7.addPreferencias(COMP0463);

		PROF8.addPreferencias(COMP0470);

		PROF9.addPreferencias(COMP0427);

		PROF10.addPreferencias(ELET0111);

		Domain<Docente> docentes = new Domain<>(PROF1, PROF2, PROF3, PROF4, PROF5, PROF6, PROF7, PROF8, PROF9, PROF10);
		CSP<Disciplina, Docente> csp = new DisciplinaCSP(list, docentes);
		CspListener.StepCounter<Disciplina, Docente> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Disciplina, Docente> solver;
		Optional<Assignment<Disciplina, Docente>> solution;

		solver = new MinConflictsSolver<>(1000);
		int i = 0;
		do {
			solver.addCspListener(stepCounter);
			stepCounter.reset();
			solution = solver.solve(csp);
			i++;
		} while (Integer.parseInt(stepCounter.getResults().get("assignmentCount")) > 1000 && i < 100);
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
