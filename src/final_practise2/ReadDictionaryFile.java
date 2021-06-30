package final_practise2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadDictionaryFile {

	public boolean doesFileExist(String Path) {
		boolean b = true;
		try {
			File f = new File(Path);
			FileReader fd = new FileReader(f);
		} catch (FileNotFoundException e) {
			b = false;
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	public void readFile(String path) {
		try {
			File f = new File(path);
			FileReader fd = new FileReader(f);
			BufferedReader br = new BufferedReader(fd);
			ArrayList<String> al = new ArrayList<String>();
			String line;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				al.add(line);
				String[] word = line.split("-");
				System.out.println(word[0]);
				String[] meaning = word[1].split(",");
				for (int i = 0; i < meaning.length; i++) {
					System.out.println(meaning[i]);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ReadDictionaryFile rdf = new ReadDictionaryFile();
		String path = "src/final_Practise2/dictionary";
		boolean exist = rdf.doesFileExist(path);
		if (exist) {
			rdf.readFile(path);
		} else {
			System.out.println("file does not exist");
		}

	}
}
