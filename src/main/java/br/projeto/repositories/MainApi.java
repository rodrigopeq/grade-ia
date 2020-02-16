package br.projeto.repositories;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MainApi {

	public static void main(String[] args) {
		APIConnect api = new APIConnect();
		var urlParameters = "{\"query\":\"{ disciplinas { codigo horario nome carga_horaria } }\"}";
		api.request(urlParameters);
		System.out.println(api.getLastContent().toString());
	}

}
