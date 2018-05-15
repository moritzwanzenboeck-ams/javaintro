package GUI;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import data.Mensch;

public class JsonTest {

	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("C:\\temp\\output.json");
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		
		//
		Mensch p = new Mensch();
		Mensch p2 = new Mensch();
		ArrayList<Mensch> mensch = new ArrayList<>();
		
		p.setVorname("Moritz");
		p.setNachname("Wanzenböck");
		p.setOrt("Wien");
		p.setAdresse("Cobenzlgasse");
		p.setPlz(1190);
		mensch.add(p);
		
		p2.setVorname("Erica");
		p2.setNachname("Moin");
		p2.setOrt("Börlin");
		p2.setAdresse("Am Kurürstendarm 88");
		p2.setPlz(88);
		mensch.add(p2);
		
		gson.toJson(mensch, writer);
		
		writer.flush();
		writer.close();
		
		Reader f = new FileReader("C:\\temp\\output.json");
		ArrayList<Mensch> menschenRead = new ArrayList<>();
		Type listType = new TypeToken <ArrayList<Mensch>>(){}.getType();
		menschenRead =gson.fromJson(f, listType);
		for (int i = 0; i < menschenRead.size() ; i++)
			System.out.println(menschenRead.get(i));
		
		
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
