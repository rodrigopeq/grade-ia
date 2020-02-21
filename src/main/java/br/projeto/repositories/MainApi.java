package br.projeto.repositories;

import java.util.List;

import br.projeto.models.Disciplina;
import br.projeto.models.Docente;

public class MainApi {

	public static void main(String[] args) {
		APIConnect api = new APIConnect();
		APIRequest request = new APIRequest(api);
		List<Disciplina> disciplinas = request.requestDisciplina();
		List<Docente> docentes = request.requestDocente();

		System.out.println(disciplinas);
		System.out.println(docentes);
	}

}
