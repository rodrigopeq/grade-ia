package br.projeto.repositories;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class APIConnect {

	private static HttpURLConnection con;
	private StringBuilder lastContent;
	private byte[] postData;

	public APIConnect() {
		Manipulator mn = new Manipulator();
		try {
			var myurl = new URL(mn.getUrl());
			con = (HttpURLConnection) myurl.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Java client");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty(mn.getUser(), mn.getPassword());
		} catch (Exception ex) {
			System.out.println("Não foi possivel conectar - Message: " + ex.getMessage());
			ex.printStackTrace();
			con.disconnect();
		}
	}

	public void request(String urlParameters) {
		setPostData(urlParameters);
		try (var wr = new DataOutputStream(con.getOutputStream())) {
			wr.write(postData);
		} catch (Exception ex) {
			System.out.println("Erro nos dados - Message: " + ex.getMessage());
			ex.printStackTrace();
		}

		try (var br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

			String line;
			lastContent = new StringBuilder();

			while ((line = br.readLine()) != null) {
				lastContent.append(line);
				lastContent.append(System.lineSeparator());
			}
		} catch (Exception ex) {
			System.out.println("Erro na resposta - Message: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	private void setPostData(String urlParameters) {
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		this.postData = postData;
	}

	public void disconnect() {
		con.disconnect();
	}

	public StringBuilder getLastContent() {
		return lastContent;
	}
}
