package GUI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data.Mensch;

public class JsonTest {

	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("C:\\temp\\output.json");
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		gson.toJson("Hallo", writer);
		gson.toJson(12345, writer);
		//
		Mensch p = new Mensch();
		p.setVorname("Moritz");
		p.setNachname("Wanzenböck");
		p.setOrt("Wien");
		p.setAdresse("Cobenzlgasse");
		p.setPlz(1190);
		gson.toJson(p, writer);
		
		writer.flush();
		writer.close();
		
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
