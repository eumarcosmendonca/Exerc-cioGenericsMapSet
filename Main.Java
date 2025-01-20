package Program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> map = new HashMap<>();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try {

			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);

			String line = bufferedReader.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);
				if (map.containsKey(name) == true) {
					Integer auxiliar = map.get(name);
					auxiliar = auxiliar + votes;
					map.put(name, auxiliar);
				}
				else {
					map.put(name, votes);
				}
				line = bufferedReader.readLine();

			}

			for (String obj : map.keySet()) {
				System.out.println(obj + ": " + map.get(obj));
			}

		}

		catch (IOException msg) {
			throw new IOException("Ocorreu um erro ao tentar ler o arquivo.");
		}

		finally {

			bufferedReader.close();
			fileReader.close();
			sc.close();

		}

	}

}
