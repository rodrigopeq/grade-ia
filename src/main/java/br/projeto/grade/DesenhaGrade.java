package br.projeto.grade;

import java.util.Arrays;
import java.util.List;

import br.projeto.models.Disciplina;
import br.projeto.models.Horario;

//SEGUNDA

public class DesenhaGrade {

	public String SEG1;
	public String SEG2;
	public String SEG3;
	public String SEG4;
	public String SEG5;
	public String SEG6;
	// TERÇA=
	public String TER1;
	public String TER2;
	public String TER3;
	public String TER4;
	public String TER5;
	public String TER6;
	// QUARTA
	public String QUA1;
	public String QUA2;
	public String QUA3;
	public String QUA4;
	public String QUA5;
	public String QUA6;
	// QUINTA
	public String QUI1;
	public String QUI2;
	public String QUI3;
	public String QUI4;
	public String QUI5;
	public String QUI6;
	// SEXTA
	public String SEX1;
	public String SEX2;
	public String SEX3;
	public String SEX4;
	public String SEX5;
	public String SEX6;

	StringBuilder result = new StringBuilder();
	public List<Disciplina> disciplinas;

	public DesenhaGrade(List<Disciplina> disciplinas) {
		for (Disciplina di : disciplinas) {
			for (Horario ho : di.getHorario()) {
				switch (ho.getName()) {
				case "2T1":
					SEG1 = di.getName();
					break;
				case "2T2":
					SEG2 = di.getName();
					break;
				case "2T3":
					SEG3 = di.getName();
					break;
				case "2T4":
					SEG4 = di.getName();
					break;
				case "2T5":
					SEG5 = di.getName();
					break;
				case "2T6":
					SEG6 = di.getName();
					break;
				case "3T1":
					TER1 = di.getName();
					break;
				case "3T2":
					TER2 = di.getName();
					break;
				case "3T3":
					TER3 = di.getName();
					break;
				case "3T4":
					TER4 = di.getName();
					break;
				case "3T5":
					TER5 = di.getName();
					break;
				case "3T6":
					TER6 = di.getName();
					break;
				case "4T1":
					QUA1 = di.getName();
					break;
				case "4T2":
					QUA2 = di.getName();
					break;
				case "4T3":
					QUA3 = di.getName();
					break;
				case "4T4":
					QUA4 = di.getName();
					break;
				case "4T5":
					QUA5 = di.getName();
					break;
				case "4T6":
					QUA6 = di.getName();
					break;
				case "5T1":
					QUI1 = di.getName();
					break;
				case "5T2":
					QUI2 = di.getName();
					break;
				case "5T3":
					QUI3 = di.getName();
					break;
				case "5T4":
					QUI4 = di.getName();
					break;
				case "5T5":
					QUI5 = di.getName();
					break;
				case "5T6":
					QUI6 = di.getName();
					break;
				case "6T1":
					SEX1 = di.getName();
					break;
				case "6T2":
					SEX2 = di.getName();
					break;
				case "6T3":
					SEX3 = di.getName();
					break;
				case "6T4":
					SEX4 = di.getName();
					break;
				case "6T5":
					SEX5 = di.getName();
					break;
				case "6T6":
					SEX6 = di.getName();
					break;
				default:
					System.err.println("Default");
				}
			}
		}
		List<String> ordem = Arrays.asList(SEG1, SEG2, SEG3, SEG4, SEG5, SEG6, TER1, TER2, TER3, TER4, TER5, TER6, QUA1,
				QUA2, QUA3, QUA4, QUA5, QUA6, QUI1, QUI2, QUI3, QUI4, QUI5, QUI6, SEX1, SEX2, SEX3, SEX4, SEX5, SEX6);
		
		result.append(SEG1);result.append(" | ");
		result.append(TER1);result.append(" | ");
		result.append(QUA1);result.append(" | ");
		result.append(QUI1);result.append(" | ");
		result.append(SEX1);result.append("\n");
		result.append(SEG2);result.append(" | ");
		result.append(TER2);result.append(" | ");
		result.append(QUA2);result.append(" | ");
		result.append(QUI2);result.append(" | ");
		result.append(SEX2);result.append("\n");
		result.append(SEG3);result.append(" | ");
		result.append(TER3);result.append(" | ");
		result.append(QUA3);result.append(" | ");
		result.append(QUI3);result.append(" | ");
		result.append(SEX3);result.append("\n");
		result.append(SEG4);result.append(" | ");
		result.append(TER4);result.append(" | ");
		result.append(QUA4);result.append(" | ");
		result.append(QUI4);result.append(" | ");
		result.append(SEX4);result.append("\n");
		result.append(SEG5);result.append(" | ");
		result.append(TER5);result.append(" | ");
		result.append(QUA5);result.append(" | ");
		result.append(QUI5);result.append(" | ");
		result.append(SEX5);result.append("\n");
		result.append(SEG6);result.append(" | ");
		result.append(TER6);result.append(" | ");
		result.append(QUA6);result.append(" | ");
		result.append(QUI6);result.append(" | ");
		result.append(SEX6);result.append("\n");
		
		System.out.println(result);

	}
}
