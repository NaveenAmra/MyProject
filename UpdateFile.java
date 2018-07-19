package javaprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpdateFile {
	public static void main(String args[]) {

		String fileLoc = "C:\\Users\\home\\Desktop\\newdata.csv";
		BufferedReader buffread = null;

		try {
			System.out.println("enter student id to update the data");
			Scanner scanner = new Scanner(System.in);
			String studentId = scanner.nextLine();
			FileReader fileread = new FileReader(fileLoc);
			buffread = new BufferedReader(fileread);
			String record = null;
			// StringBuilder fileContent = new StringBuilder();
			while ((record = buffread.readLine()) != null) {
				String[] parameters = record.split(",");
				String idFromFile = parameters[0];

				if (idFromFile.equals(studentId)) {
					System.out.println("The details are: ");
					for (int i = 0; i < parameters.length; i++) {

						System.out.println(parameters[i]);

						if (parameters[0].equals(studentId)) {
							parameters[1] = "kalyan";
							parameters[2] = "250";
							String newLine = parameters[0] + "," + parameters[1] + "," + parameters[2] + ",";
							FileWriter filewrite = new FileWriter(fileLoc, true);
							BufferedWriter buferwrite = new BufferedWriter(filewrite);
							buferwrite.write(newLine);
							buferwrite.newLine();
							buferwrite.flush();
							System.out.println("data stored into file");
							buferwrite.close();

						}

						else {
							System.out.println("data not modified");
						}
					}
				}

			}

		} catch (IOException e) {
			System.out.println("There was a problem: " + e);
			e.printStackTrace();

		} finally {
			try {
				buffread.close();
			} catch (Exception e) {
			}
		}
	}
}