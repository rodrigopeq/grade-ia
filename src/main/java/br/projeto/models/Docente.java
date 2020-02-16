package br.projeto.models;

import java.util.ArrayList;

public class Docente {

	private String nome;
	private ArrayList<Disciplina> preferencias = new ArrayList<>();
	private ArrayList<Disciplina> disciplinasAlocadas = new ArrayList<>();

	public Docente(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addPreferencias(Disciplina preferencia){
		if (preferencias.size() < 3) {
			preferencias.add(preferencia);
		} 
//		else {
//			throw new Exception("Max 5 disciplina");
//		}
	}

	public ArrayList<Disciplina> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(ArrayList<Disciplina> preferencias) {
		if (preferencias.size() < 3) {
			this.preferencias = preferencias;
		} 
//			else {
//			throw new Exception("Max 5 disciplina");
//		}
	}

	public int getCargaHorariaTotal() {
		int cargaHorariaTotal = 0;
		for (Disciplina disc : disciplinasAlocadas) {
			cargaHorariaTotal += disc.getCargaHoraria();
		}
		return cargaHorariaTotal;
	}

	@Override
	public String toString() {
		
		return nome;
	}
	
	

}
