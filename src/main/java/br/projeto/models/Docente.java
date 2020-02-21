package br.projeto.models;

import java.util.ArrayList;
import java.util.List;

public class Docente {

	private String nome;
	public List<Disciplina> preferencias = new ArrayList<>();

	public void addPreferencias(Disciplina preferencia) {
		if (preferencias.size() < 3) {
			preferencias.add(preferencia);
		}
	}

	public List<Disciplina> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Disciplina> preferencias) {
		if (preferencias.size() < 3) {
			this.preferencias = preferencias;
		}
	}

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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(nome);
		if(!preferencias.isEmpty()) {
			result.append("===");
			result.append(preferencias);
		}
		return result.toString();

	}

}
