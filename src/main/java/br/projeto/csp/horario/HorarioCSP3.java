package br.projeto.csp.horario;

import java.util.Arrays;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;

public class HorarioCSP3 extends CSP<Variable,String>{
	
//	public static final Variable M12 = new Variable("M12");
//	public static final Variable M24 = new Variable("M24");
//	public static final Variable M56 = new Variable("M56");
//	public static final Variable T12 = new Variable("T12");
//	public static final Variable T24 = new Variable("T24");
//	public static final Variable T56 = new Variable("T56");
//	public static final Variable N12 = new Variable("N12");
//	public static final Variable N34 = new Variable("N34");
	
	public static final Disciplina COMP0397 = new Disciplina("COMP0397","PROGRAMAÇÃO PARALELA E CONCORRENTE", 60);
	public static final Disciplina COMP0427 = new Disciplina("COMP0427","INTELIGÊNCIA ARTIFICIAL", 60);
	public static final Disciplina COMP0439 = new Disciplina("COMP0439","ENGENHARIA DE SOFTWARE II", 60);
	public static final Disciplina COMP0455 = new Disciplina("COMP0455","BANCO DE DADOS I", 60);
	public static final Disciplina COMP0463 = new Disciplina("COMP0463","LABORATÓRIO DE REDES DE COMPUTADORES", 30);
	public static final Disciplina COMP0470 = new Disciplina("COMP0470","SISTEMAS DISTRIBUÍDOS", 60);
	public static final Disciplina ELET0111 = new Disciplina("ELET0111","ELETRÔNICA I", 90);
	
	//SEGUNDA
	public static final String SEG1 = "2T1";
	public static final String SEG2 = "2T2";
	public static final String SEG3 = "2T3";
	public static final String SEG4 = "2T4";
	public static final String SEG5 = "2T5";
	public static final String SEG6 = "2T6";
	//TERÇA
	public static final String TER1 = "3T1";
	public static final String TER2 = "3T2";
	public static final String TER3 = "3T3";
	public static final String TER4 = "3T4";
	public static final String TER5 = "3T5";
	public static final String TER6 = "3T6";
	//QUARTA
	public static final String QUA1 = "4T1";
	public static final String QUA2 = "4T2";
	public static final String QUA3 = "4T3";
	public static final String QUA4 = "4T4";
	public static final String QUA5 = "4T5";
	public static final String QUA6 = "4T6";
	//QUINTA
	public static final String QUI1 = "5T1";
	public static final String QUI2 = "5T2";
	public static final String QUI3 = "5T3";
	public static final String QUI4 = "5T4";
	public static final String QUI5 = "5T5";
	public static final String QUI6 = "5T6";
	//SEXTA
	public static final String SEX1 = "6T1";
	public static final String SEX2 = "6T2";
	public static final String SEX3 = "6T3";
	public static final String SEX4 = "6T4";
	public static final String SEX5 = "6T5";
	public static final String SEX6 = "6T6";
	
	public HorarioCSP3() {
		
		super(Arrays.asList(COMP0397,COMP0427,COMP0439,COMP0455,COMP0463,COMP0470,ELET0111
));
		
//		super(Arrays.asList(SEG1,SEG2,SEG3,SEG4,SEG5,SEG6,
//				TER1,TER2,TER3,TER4,TER5,TER6,
//				QUA1,QUA2,QUA3,QUA4,QUA5,QUA6,
//				QUI1,QUI2,QUI3,QUI4,QUI5,QUI6,
//				SEX1,SEX2,SEX3,SEX4,SEX5,SEX6
//));
//		
//		Domain<String> horarios = new Domain<>(COMP0397,COMP0427,COMP0439,COMP0455,COMP0463,COMP0470,ELET0111);
		Domain<String> horarios = new Domain<>(SEG1,SEG2,SEG3,SEG4,SEG5,SEG6,
				TER1,TER2,TER3,TER4,TER5,TER6,
				QUA1,QUA2,QUA3,QUA4,QUA5,QUA6,
				QUI1,QUI2,QUI3,QUI4,QUI5,QUI6,
				SEX1,SEX2,SEX3,SEX4,SEX5,SEX6);
		
		for (Variable var : getVariables())
			setDomain(var, horarios);
		
		
		
//		//SEGUNDA
//		addConstraint(new EqualConstraint<>(SEG1,SEG2));
//		addConstraint(new EqualConstraint<>(SEG3,SEG4));
//		addConstraint(new EqualConstraint<>(SEG5,SEG6));
//		//TERÇA
//		addConstraint(new EqualConstraint<>(TER1,TER2));
//		addConstraint(new EqualConstraint<>(TER3,TER4));
//		addConstraint(new EqualConstraint<>(TER5,TER6)); 
//		//QUARTA
//		addConstraint(new EqualConstraint<>(QUA1,QUA2));
//		addConstraint(new EqualConstraint<>(QUA3,QUA4));
//		addConstraint(new EqualConstraint<>(QUA5,QUA6));
//		//QUINTA
//		addConstraint(new EqualConstraint<>(QUI1,QUI2));
//		addConstraint(new EqualConstraint<>(QUI3,QUI4));
//		addConstraint(new EqualConstraint<>(QUI5,QUI6));
//		//SEXTA
//		addConstraint(new EqualConstraint<>(SEX1,SEX2));
//		addConstraint(new EqualConstraint<>(SEX3,SEX4));
//		addConstraint(new EqualConstraint<>(SEX5,SEX6));
	}
		
	
	
}