package mathiasschoepke;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.gson.Gson;

public class ReadWriteDataFile {

	private String filePath;
	private Gson gson = new Gson();

	public ReadWriteDataFile(String filePath) {
		this.filePath = filePath;
	}

	public void WriteToFile(Data objekt) {
		try {
			Files.write(Paths.get(filePath), gson.toJson(objekt).getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			log("Error while saving data to file " + e.toString());
		}
	}

	public Data ReadFromFile() {
		try {
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			return gson.fromJson(content, Data.class);
		} catch (IOException e) {
			log("Error while loading data from file " + e.toString());
		}
		return null;
	}

	private static void log(String string) {
		System.out.println(string);
	}
}
