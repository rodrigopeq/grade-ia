package br.projeto.repositories;

import java.io.FileInputStream;
import java.util.Properties;

public class Manipulator {

	private final Properties prop = new Properties();

	public Manipulator() {
		try {
			FileInputStream file = new FileInputStream("hasura.properties");
			prop.load(file);
		} catch (Exception ex) {
			System.out.println("Erro ao abrir arquivo de properties - Message: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	public String getUser() {
		return prop.getProperty("prop.server.login");
	}

	public String getUrl() {
		return prop.getProperty("prop.server.host");
	}

	public String getPassword() {
		return prop.getProperty("prop.server.password");
	}

}
