package br.projeto.grade;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.Domain;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.Variable;
import br.projeto.csp.horario.HorarioCSP2;
import br.projeto.csp.professores.DisciplinaCSP;
import br.projeto.models.Disciplina;
import br.projeto.models.Docente;

public class App

{

	public static final Disciplina COMP0397 = new Disciplina("COMP0397", "PROGRAMAÇÃO PARALELA E CONCORRENTE", 60);
	public static final Disciplina COMP0427 = new Disciplina("COMP0427", "INTELIGÊNCIA ARTIFICIAL", 60);
	public static final Disciplina COMP0439 = new Disciplina("COMP0439", "ENGENHARIA DE SOFTWARE II", 60);
	public static final Disciplina COMP0455 = new Disciplina("COMP0455", "BANCO DE DADOS I", 60);
	public static final Disciplina COMP0463 = new Disciplina("COMP0463", "LABORATÓRIO DE REDES DE COMPUTADORES", 30);
	public static final Disciplina COMP0470 = new Disciplina("COMP0470", "SISTEMAS DISTRIBUÍDOS", 60);
	public static final Disciplina ELET0111 = new Disciplina("ELET0111", "ELETRÔNICA I", 90);

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

		CSP<Disciplina, Docente> cspDisciplina = new DisciplinaCSP(list, docentes);
		CspListener.StepCounter<Disciplina, Docente> stepCounterDisciplina = new CspListener.StepCounter<>();
		CspSolver<Disciplina, Docente> solverDisciplina;
		Optional<Assignment<Disciplina, Docente>> solutionDisciplina;

		solverDisciplina = new MinConflictsSolver<>(1000);
		solverDisciplina.addCspListener(stepCounterDisciplina);
		stepCounterDisciplina.reset();
		solutionDisciplina = solverDisciplina.solve(cspDisciplina);
//	solutionDisciplina.ifPresent(System.out::println);
//	System.out.println(stepCounterDisciplina.getResults() + "\n");

		for (Disciplina di : list) {
			di.setDocente(solutionDisciplina.get().getValue(di));
		}

		// ===============================================================================

		Domain<Disciplina> horarios = new Domain<>(COMP0397, COMP0427, COMP0439, COMP0455, COMP0463, COMP0470,
				ELET0111);
		List<Variable> variaveisHorario = Arrays.asList(SEG1, SEG2, SEG3, SEG4, SEG5, SEG6, TER1, TER2, TER3, TER4,
				TER5, TER6, QUA1, QUA2, QUA3, QUA4, QUA5, QUA6, QUI1, QUI2, QUI3, QUI4, QUI5, QUI6, SEX1, SEX2, SEX3,
				SEX4, SEX5, SEX6);
		CSP<Variable, Disciplina> cspHorario = new HorarioCSP2(variaveisHorario, horarios);
		CspListener.StepCounter<Variable, Disciplina> stepCounterHorario = new CspListener.StepCounter<>();
		CspSolver<Variable, Disciplina> solverHorario;
		Optional<Assignment<Variable, Disciplina>> solutionHorario;

		solverHorario = new MinConflictsSolver<>(1000);
		do {
			solverHorario.addCspListener(stepCounterHorario);
			stepCounterHorario.reset();
			solutionHorario = solverHorario.solve(cspHorario);
		} while (Integer.parseInt(stepCounterHorario.getResults().get("assignmentCount")) > 1000);
		solutionHorario.ifPresent(System.out::println);
		System.out.println(stepCounterHorario.getResults() + "\n");

	}

}
