package mathiasschoepke;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ReadWriteDataFile {

	private String filePath;
	private Gson gson = new Gson();

	public ReadWriteDataFile(String filePath) {
		this.filePath = filePath;
	}

	public void WriteToFile(Data objekt) {
		File dataFile = new File(filePath);
		try {
			if (dataFile.createNewFile()) {
				log("File created: " + dataFile.getName());
			} else {
				log("File already exists.");
			}
		} catch (IOException e) {
			log("Excepton Occured: " + e.toString());
		}

		try {
			FileWriter crunchifyWriter;
			crunchifyWriter = new FileWriter(dataFile.getAbsoluteFile(), false);

			BufferedWriter bufferWriter = new BufferedWriter(crunchifyWriter);
			bufferWriter.write(gson.toJson(objekt));
			bufferWriter.close();

			log("Data saved at file location: " + filePath);
		} catch (IOException e) {
			log("Error while saving data to file " + e.toString());
		}
	}

	public Data ReadFromFile() {
		File dataFile = new File(filePath);

		if (!dataFile.exists())
			log("File doesn't exist");

		InputStreamReader isReader;
		try {
			isReader = new InputStreamReader(new FileInputStream(dataFile), "UTF-8");

			JsonReader myReader = new JsonReader(isReader);
			Data data = gson.fromJson(myReader, Data.class);
			log("Data loaded");
			return data;

		} catch (Exception e) {
			log("error load cache from file " + e.toString());
		}
		return null;
	}

	private static void log(String string) {
		System.out.println(string);
	}
}
