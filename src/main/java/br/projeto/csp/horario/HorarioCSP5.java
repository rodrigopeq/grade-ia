package br.projeto.csp.horario;

import java.util.Arrays;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import br.projeto.models.Disciplina;

public class HorarioCSP5 extends CSP<Variable,Disciplina>{
	
	public static final Disciplina COMP0397 = new Disciplina("COMP0397","PROGRAMAÇÃO PARALELA E CONCORRENTE", 60);
	public static final Disciplina COMP0427 = new Disciplina("COMP0427","INTELIGÊNCIA ARTIFICIAL", 60);
	public static final Disciplina COMP0439 = new Disciplina("COMP0439","ENGENHARIA DE SOFTWARE II", 60);
	public static final Disciplina COMP0455 = new Disciplina("COMP0455","BANCO DE DADOS I", 60);
	public static final Disciplina COMP0463 = new Disciplina("COMP0463","LABORATÓRIO DE REDES DE COMPUTADORES", 30);
	public static final Disciplina COMP0470 = new Disciplina("COMP0470","SISTEMAS DISTRIBUÍDOS", 60);
	public static final Disciplina ELET0111 = new Disciplina("ELET0111","ELETRÔNICA I", 90);
	
	//SEGUNDA
	public static final Variable SEG1 = new Variable("2T12");
	public static final Variable SEG2 = new Variable("2T34");
	public static final Variable SEG3 = new Variable("2T56");

	//TERÇA
	public static final Variable TER1 = new Variable("3T12");
	public static final Variable TER2 = new Variable("3T34");
	public static final Variable TER3 = new Variable("3T56");
	
	//QUARTA
	public static final Variable QUA1 = new Variable("4T12");
	public static final Variable QUA2 = new Variable("4T34");
	public static final Variable QUA3 = new Variable("4T56");
	
	//QUINTA
	public static final Variable QUI1 = new Variable("5T12");
	public static final Variable QUI2 = new Variable("5T34");
	public static final Variable QUI3 = new Variable("5T56");

	//SEXTA
	public static final Variable SEX1 = new Variable("6T12");
	public static final Variable SEX2 = new Variable("6T34");
	public static final Variable SEX3 = new Variable("6T56");

	
	public HorarioCSP5() {
		
		super(Arrays.asList(SEG1,SEG2,SEG3,
				TER1,TER2,TER3,
				QUA1,QUA2,QUA3,
				QUI1,QUI2,QUI3,
				SEX1,SEX2,SEX3
));
		
		Domain<Disciplina> horarios = new Domain<>(COMP0397,COMP0427,COMP0439,COMP0455,COMP0463,COMP0470,ELET0111);
		
		for (Variable var : getVariables())
			setDomain(var, horarios);
		
		//246T12
		addConstraint(new EqualConstraint<>(SEG1,QUA1));
		addConstraint(new EqualConstraint<>(SEX1,QUA1));

		//24T34
		addConstraint(new EqualConstraint<>(SEG2,QUA2));
		
		//24T56
		addConstraint(new EqualConstraint<>(SEG3,QUA3));
		
		//35T12
		addConstraint(new EqualConstraint<>(TER1,QUI1));
		
		//35T34
		addConstraint(new EqualConstraint<>(TER2,QUI2));
		
		//35T56
		addConstraint(new EqualConstraint<>(TER3,QUI3));
		
		//ELETRÔNICA - 246T12
		addConstraint(new AnotherDepartConstraint<>(SEG1,ELET0111));
		
		addConstraint(new WorkloadConstraint<>(SEG1));
		addConstraint(new WorkloadConstraint<>(SEG2));
		addConstraint(new WorkloadConstraint<>(SEG3));
		addConstraint(new WorkloadConstraint<>(TER1));
		addConstraint(new WorkloadConstraint<>(TER2));
		addConstraint(new WorkloadConstraint<>(TER3));
		addConstraint(new WorkloadConstraint<>(QUA1));
		addConstraint(new WorkloadConstraint<>(QUA2));
		addConstraint(new WorkloadConstraint<>(QUA3));
		addConstraint(new WorkloadConstraint<>(QUI1));
		addConstraint(new WorkloadConstraint<>(QUI2));
		addConstraint(new WorkloadConstraint<>(QUI3));
		addConstraint(new WorkloadConstraint<>(SEX1));
		addConstraint(new WorkloadConstraint<>(SEX2));
		addConstraint(new WorkloadConstraint<>(SEX3));
		
		
		
		
		
		
		
	}
		
	
	
}
