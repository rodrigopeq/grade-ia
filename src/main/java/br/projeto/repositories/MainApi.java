package br.projeto.repositories;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.projeto.models.Disciplina;

public class MainApi {

	public static void main(String[] args) {
		APIConnect api = new APIConnect();
		var urlParametersDisc = "{\"query\":\"{ disciplinas { codigo horario name carga_horaria } }\"}";
		var urlParametersDoc = "{\"query\":\"{ disciplinas { codigo horario name carga_horaria } }\"}";
		var urlParameterTudo = "{\"query\":\"{ disciplinas { codigo horario name carga_horaria } }\"}";
		api.request(urlParametersDoc);

		String response = responseFormated(api.getLastContent().toString());
		System.out.println(response);
		Type listType = new TypeToken<ArrayList<Disciplina>>() {
		}.getType();
		List<Disciplina> yourClassList = new Gson().fromJson(response, listType);
		System.out.println(yourClassList);
	}

	public static String responseFormated(String response) {
		int inicial = response.indexOf("[");
		int finale = response.indexOf("]") + 1;
		String sub = response.substring(inicial, finale);
		return sub;
	}

}
