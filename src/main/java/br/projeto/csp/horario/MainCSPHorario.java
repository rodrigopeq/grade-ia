package br.projeto.csp.horario;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.projeto.models.Disciplina;
import aima.core.search.csp.*;

public class MainCSPHorario {
	
	public static final Disciplina COMP0397 = new Disciplina("COMP0397", "PROGRAMAÇÃO PARALELA E CONCORRENTE", 60);
	public static final Disciplina COMP0427 = new Disciplina("COMP0427", "INTELIGÊNCIA ARTIFICIAL", 60);
	public static final Disciplina COMP0439 = new Disciplina("COMP0439", "ENGENHARIA DE SOFTWARE II", 60);
	public static final Disciplina COMP0455 = new Disciplina("COMP0455", "BANCO DE DADOS I", 60);
	public static final Disciplina COMP0463 = new Disciplina("COMP0463", "LABORATÓRIO DE REDES DE COMPUTADORES", 30);
	public static final Disciplina COMP0470 = new Disciplina("COMP0470", "SISTEMAS DISTRIBUÍDOS", 60);
	public static final Disciplina ELET0111 = new Disciplina("ELET0111", "ELETRÔNICA I", 90);
	public static final Disciplina AAAA0000 = new Disciplina("","XXXXXXXXXXXXXXXXXXXXXXXXX",30);

	// SEGUNDA
	public static final Variable SEG1 = new Variable("2T1");
	public static final Variable SEG2 = new Variable("2T2");
	public static final Variable SEG3 = new Variable("2T3");
	public static final Variable SEG4 = new Variable("2T4");
	public static final Variable SEG5 = new Variable("2T5");
	public static final Variable SEG6 = new Variable("2T6");
	// TERÇA
	public static final Variable TER1 = new Variable("3T1");
	public static final Variable TER2 = new Variable("3T2");
	public static final Variable TER3 = new Variable("3T3");
	public static final Variable TER4 = new Variable("3T4");
	public static final Variable TER5 = new Variable("3T5");
	public static final Variable TER6 = new Variable("3T6");
	// QUARTA
	public static final Variable QUA1 = new Variable("4T1");
	public static final Variable QUA2 = new Variable("4T2");
	public static final Variable QUA3 = new Variable("4T3");
	public static final Variable QUA4 = new Variable("4T4");
	public static final Variable QUA5 = new Variable("4T5");
	public static final Variable QUA6 = new Variable("4T6");
	// QUINTA
	public static final Variable QUI1 = new Variable("5T1");
	public static final Variable QUI2 = new Variable("5T2");
	public static final Variable QUI3 = new Variable("5T3");
	public static final Variable QUI4 = new Variable("5T4");
	public static final Variable QUI5 = new Variable("5T5");
	public static final Variable QUI6 = new Variable("5T6");
	// SEXTA
	public static final Variable SEX1 = new Variable("6T1");
	public static final Variable SEX2 = new Variable("6T2");
	public static final Variable SEX3 = new Variable("6T3");
	public static final Variable SEX4 = new Variable("6T4");
	public static final Variable SEX5 = new Variable("6T5");
	public static final Variable SEX6 = new Variable("6T6");
	
	public static void main(String[] args) {
	Domain<Disciplina> horarios = new Domain<>(COMP0397, COMP0427, COMP0439, COMP0455, COMP0463, COMP0470,
				ELET0111,AAAA0000);
	List<Variable> variaveisHorario = Arrays.asList(SEG1, SEG2, SEG3, SEG4, SEG5, SEG6, TER1, TER2, TER3, TER4, TER5, TER6, QUA1, QUA2, QUA3,
			QUA4, QUA5, QUA6, QUI1, QUI2, QUI3, QUI4, QUI5, QUI6, SEX1, SEX2, SEX3, SEX4, SEX5, SEX6);
	CSP<Variable, Disciplina> csp = new HorarioCSP2(variaveisHorario,horarios);
	CspListener.StepCounter<Variable, Disciplina> stepCounter = new CspListener.StepCounter<>();
	CspSolver<Variable, Disciplina> solver;
	Optional<Assignment<Variable, Disciplina>> solution;
	
	solver = new MinConflictsSolver<>(1000);
	int i = 0;
	do {
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		solution = solver.solve(csp);
		i++;
	} while (Integer.parseInt(stepCounter.getResults().get("assignmentCount")) > 1000 && i<100);
	solution.ifPresent(System.out::println);
	System.out.println(stepCounter.getResults() + "\n");
	
	
	
//	solver = new FlexibleBacktrackingSolver<Variable, Disciplina>().setAll();
//	solver.addCspListener(stepCounter);
//	stepCounter.reset();
//	System.out.println("Map Coloring (Backtracking + MRV & DEG + LCV + AC3)");
//	solution = solver.solve(csp);
//	solution.ifPresent(System.out::println);
//	System.out.println(stepCounter.getResults() + "\n");
//
//	solver = new FlexibleBacktrackingSolver<Variable, Disciplina>().set(CspHeuristics.mrvDeg());
//	solver.addCspListener(stepCounter);
//	stepCounter.reset();
//	System.out.println("Map Coloring (Backtracking + MRV & DEG)");
//	solution = solver.solve(csp);
//	solution.ifPresent(System.out::println);
//	System.out.println(stepCounter.getResults() + "\n");
//	
//	solver = new FlexibleBacktrackingSolver<>();
//	solver.addCspListener(stepCounter);
//	stepCounter.reset();
//	System.out.println("Map Coloring (Backtracking)");
//	solution = solver.solve(csp);
//	solution.ifPresent(System.out::println);
//	System.out.println(stepCounter.getResults() + "\n");
	}
}
