package br.projeto.repositories;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import br.projeto.models.Disciplina;
import br.projeto.models.Docente;

public class APIRequest {
	
	private APIConnect api;
	
	APIRequest(APIConnect api){
		this.api = api;
	}

	public String responseFormated(String response) {
		int inicial = response.indexOf("[");
		int finale = response.indexOf("]") + 1;
		String sub = response.substring(inicial, finale);
		return sub;
	}

	public List<Disciplina> requestDisciplina() {
		String urlParameters = "{\"query\":\"{ disciplinas { codigo horario name carga_horaria } }\"}";
		api.request(urlParameters);

		String response = responseFormated(api.getLastContent().toString());
		System.out.println(response);
		Type listType = new TypeToken<ArrayList<Disciplina>>() {
		}.getType();
		return new Gson().fromJson(response, listType);
	}

	// Falta implementar o codigo
	public List<Docente> requestDocente() {
		String urlParameters = "{\"query\":\"{ disciplinas { codigo horario name carga_horaria } }\"}";
		api.request(urlParameters);

		String response = responseFormated(api.getLastContent().toString());
		System.out.println(response);
		Type listType = new TypeToken<ArrayList<Docente>>() {
		}.getType();
		return new Gson().fromJson(response, listType);
	}
	
	public List<String> requestTudo() {
		String urlParameters = "{\"query\":\"{ disciplinas { codigo horario name carga_horaria } }\"}";
		api.request(urlParameters);
		return null;
	}

}
