package lbi.iq.usp.br.mgbl.mgbl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;

public class JsonReader {
	
	
	
	private static final String BREAK_LINE = "\\n";

	public JsonReader(String filePath) throws FileNotFoundException {
		load(filePath);
	}

	private void load(String filePath) throws FileNotFoundException {
		
		Gson gson = new Gson();
		Scanner scanner = new Scanner(new FileReader(filePath));
		scanner.useDelimiter(BREAK_LINE);
		while (scanner.hasNext()) {
			String next = scanner.next();
			Contig contig = gson.fromJson(next, Contig.class);
			System.out.println(contig);
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		JsonReader jsonReader = new JsonReader("/home/gianluca/git/mgbl/teste.json");
		
	}

}
