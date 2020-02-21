package br.projeto.repositories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.projeto.models.Disciplina;
import br.projeto.models.Docente;

public class APIRequest {

	private APIConnect api;

	public APIRequest(APIConnect api) {
		this.api = api;
	}

	public String responseFormated(String response) {
		int inicial = response.indexOf("[");
		int finale = response.indexOf("]") + 1;
		String sub = response.substring(inicial, finale);
		return sub;
	}

	public List<Disciplina> requestDisciplina() {
		List<Disciplina> result = new ArrayList<>();
		String urlParameters = "{\"query\":\"{ disciplinas(order_by: {codigo: asc}) { codigo name carga_horaria } }\"}";
		api.request(urlParameters);

		
		String response = api.getLastContent().toString();
		System.out.println(response);//+++++++++++++++++++++++++++++++++
		JSONObject obj = new JSONObject(response);
		JSONArray data = obj.getJSONObject("data").getJSONArray("disciplinas");
		for (var x : data) {
			JSONObject disciplina = (JSONObject) x;
			String cod = disciplina.getString("codigo");
			String name = disciplina.getString("name");
			int ch = disciplina.getInt("carga_horaria");
			result.add(new Disciplina(cod, name, ch, new ArrayList<>()));
			}
		return result;
	}

	public List<Docente> requestDocente() {
		List<Docente> result = new ArrayList<>();
		String urlParameters = "{\"query\":\"{ docentes(order_by: {nome: asc}) { nome preferencia { disciplina { name codigo carga_horaria } } } }\"}";
		api.request(urlParameters);
		String response = api.getLastContent().toString();
		JSONObject obj = new JSONObject(response);
		JSONArray data = obj.getJSONObject("data").getJSONArray("docentes");
		Docente novo;
		for (var x : data) {
			JSONObject docente = (JSONObject) x;
			novo = new Docente(docente.getString("nome"));
			JSONArray prefer = docente.getJSONArray("preferencia");
			for (var y : prefer) {
				JSONObject preferencias = (JSONObject) y;
				JSONObject disciplina = (JSONObject) preferencias.getJSONObject("disciplina");
				String cod = disciplina.getString("codigo");
				String name = disciplina.getString("name");
				int ch = disciplina.getInt("carga_horaria");
				novo.addPreferencias(new Disciplina(cod, name, ch, new ArrayList<>()));
			}
			result.add(novo);
		}

		return result;
	}

	public List<String> requestTudo() {
		String urlParameters = "{\"query\":\"{ docentes { nome preferencia { disciplina { codigo } } } disciplinas { name codigo carga_horaria } \"}";
		api.request(urlParameters);
		return null;
	}

}
