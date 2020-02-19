package br.projeto.csp.horario;

import java.util.Arrays;
import java.util.List;

public class Grade {

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
	
	List<Horario> getArray(){
		return Arrays.asList(SEG1, SEG2, SEG3, SEG4, SEG5, SEG6, TER1, TER2, TER3, TER4, TER5, TER6, QUA1, QUA2, QUA3,
				QUA4, QUA5, QUA6, QUI1, QUI2, QUI3, QUI4, QUI5, QUI6, SEX1, SEX2, SEX3, SEX4, SEX5, SEX6);
	}

}
