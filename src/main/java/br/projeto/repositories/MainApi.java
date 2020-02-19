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
import br.projeto.models.Docente;

public class MainApi {

	public static void main(String[] args) {
		APIConnect api = new APIConnect();
		APIRequest request = new APIRequest(api);
		List<Disciplina> disciplinas = request.requestDisciplina();
//		List<Docente> docentes = request.requestDocente(); // Falta implementar o codigo
		
		System.out.println(disciplinas);
//		System.out.println(docentes);
	}

}
