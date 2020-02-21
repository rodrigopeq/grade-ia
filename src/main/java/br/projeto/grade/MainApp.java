package br.projeto.grade;

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
import br.projeto.csp.horario.HorarioCSP;
import br.projeto.csp.professores.DisciplinaCSP;
import br.projeto.models.Disciplina;
import br.projeto.models.Docente;
import br.projeto.models.Horario;
import br.projeto.repositories.APIConnect;
import br.projeto.repositories.APIRequest;

public class MainApp

{

	// SEGUNDA
	public static final Horario SEG1 = new Horario("2T1");
	public static final Horario SEG2 = new Horario("2T2");
	public static final Horario SEG3 = new Horario("2T3");
	public static final Horario SEG4 = new Horario("2T4");
	public static final Horario SEG5 = new Horario("2T5");
	public static final Horario SEG6 = new Horario("2T6");
	// TERÇA
	public static final Horario TER1 = new Horario("3T1");
	public static final Horario TER2 = new Horario("3T2");
	public static final Horario TER3 = new Horario("3T3");
	public static final Horario TER4 = new Horario("3T4");
	public static final Horario TER5 = new Horario("3T5");
	public static final Horario TER6 = new Horario("3T6");
	// QUARTA
	public static final Horario QUA1 = new Horario("4T1");
	public static final Horario QUA2 = new Horario("4T2");
	public static final Horario QUA3 = new Horario("4T3");
	public static final Horario QUA4 = new Horario("4T4");
	public static final Horario QUA5 = new Horario("4T5");
	public static final Horario QUA6 = new Horario("4T6");
	// QUINTA
	public static final Horario QUI1 = new Horario("5T1");
	public static final Horario QUI2 = new Horario("5T2");
	public static final Horario QUI3 = new Horario("5T3");
	public static final Horario QUI4 = new Horario("5T4");
	public static final Horario QUI5 = new Horario("5T5");
	public static final Horario QUI6 = new Horario("5T6");
	// SEXTA
	public static final Horario SEX1 = new Horario("6T1");
	public static final Horario SEX2 = new Horario("6T2");
	public static final Horario SEX3 = new Horario("6T3");
	public static final Horario SEX4 = new Horario("6T4");
	public static final Horario SEX5 = new Horario("6T5");
	public static final Horario SEX6 = new Horario("6T6");

	public static void main(String[] args) {

		APIConnect connect = new APIConnect();
		APIRequest api = new APIRequest(connect);

		List<Disciplina> disciplinas = api.requestDisciplina();
		System.err.println(disciplinas);
		List<Docente> xDocentes = api.requestDocente();

		List<Disciplina> alt = new ArrayList<>();
		for (Docente k : xDocentes) {
			alt = new ArrayList<>();
			for (Disciplina p : k.getPreferencias()) {
				alt.add(disciplinas.get(disciplinas.indexOf(p)));
			}
			k.setPreferencias(alt);
		}
		Domain<Docente> docentes = new Domain<>(xDocentes);
		CSP<Disciplina, Docente> cspDisciplina = new DisciplinaCSP(disciplinas, docentes);
		CspListener.StepCounter<Disciplina, Docente> stepCounterDisciplina = new CspListener.StepCounter<>();
		CspSolver<Disciplina, Docente> solverDisciplina;
		Optional<Assignment<Disciplina, Docente>> solutionDisciplina;

		solverDisciplina = new MinConflictsSolver<>(1000);
		solverDisciplina.addCspListener(stepCounterDisciplina);
		stepCounterDisciplina.reset();
		solutionDisciplina = solverDisciplina.solve(cspDisciplina);
//		solutionDisciplina.ifPresent(System.out::println);
//		System.out.println(stepCounterDisciplina.getResults() + "\n");

		for (Disciplina di : disciplinas) {
			di.setDocente(solutionDisciplina.get().getValue(di));
		}

		// ===============================================================================

		Domain<Disciplina> horarios = new Domain<>(disciplinas);
		List<Horario> variaveisHorario = Arrays.asList(SEG1, SEG2, SEG3, SEG4, SEG5, SEG6, TER1, TER2, TER3, TER4, TER5,
				TER6, QUA1, QUA2, QUA3, QUA4, QUA5, QUA6, QUI1, QUI2, QUI3, QUI4, QUI5, QUI6, SEX1, SEX2, SEX3, SEX4,
				SEX5, SEX6);
		CSP<Horario, Disciplina> cspHorario = new HorarioCSP(variaveisHorario, horarios);
		CspListener.StepCounter<Horario, Disciplina> stepCounterHorario = new CspListener.StepCounter<>();
		CspSolver<Horario, Disciplina> solverHorario;
		Optional<Assignment<Horario, Disciplina>> solutionHorario;

		solverHorario = new MinConflictsSolver<>(1000);
		int i = 0;
		do {
			solverHorario.addCspListener(stepCounterHorario);
			stepCounterHorario.reset();
			solutionHorario = solverHorario.solve(cspHorario);
			i++;
		} while (Integer.parseInt(stepCounterHorario.getResults().get("assignmentCount")) > 1000 && i <= 1000);
//		solutionHorario.ifPresent(System.out::println);
		System.out.println(stepCounterHorario.getResults() + "\n");

		var solution = solutionHorario.get();
//		System.err.println("========");
//		System.out.println(solution);
//		System.err.println("========");

		for (Horario ho : solution.getVariables()) {
			var di = solution.getValue(ho);
			di.addHorario(ho);

			System.err.println(ho);
			System.err.println(di);
		}

		for (Disciplina di : disciplinas) {
			System.out.println(di);
		}

	}

}
