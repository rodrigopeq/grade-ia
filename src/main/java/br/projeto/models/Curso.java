package br.projeto.models;

import java.util.ArrayList;

public class Curso {

	private String nome;
	private ArrayList<Periodo> periodos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(ArrayList<Periodo> periodos) {
		this.periodos = periodos;
	}

}
