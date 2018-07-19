package javaprograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DeleteFile {

	public static void main(String args[]) {
		
		String fileLoc = "C:\\Users\\home\\Desktop\\newdata.csv";
		BufferedReader buffread = null;

		try {
			System.out.println("enter student id to delete the data");
			Scanner scanner = new Scanner(System.in);
			String studentId = scanner.nextLine();
			
			/*System.out.println("enter line to delete");
			//String lineToRemove = scanner.nextLine();
*/			
			File inFile = new File(fileLoc);
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
			BufferedReader br = new BufferedReader(new FileReader(fileLoc));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			String record = null;
			while ((record = br.readLine()) != null) 
			{
				String[] parameters = record.split(",");
				String idFromFile = parameters[0];
				if (idFromFile.equals(studentId)) {
					//System.out.println("The details are: ");
					for (int i = 0; i < parameters.length; i++) {
						System.out.println(parameters[i]);
						
						/*if (parameters[0].equals(studentId)) {

							if (!record.trim().equals(studentId)) {
								pw.println(record);
								pw.flush();
							} else {
								System.out.println("data not modified");
							}
						}*/
					}
					}
					pw.close();
					br.close();
					if (!inFile.delete()) {
						System.out.println("Could not delete file");
						return;
					}

					if (!tempFile.renameTo(inFile))
						System.out.println("Could not rename file");
				}
			}
		

		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				buffread.close();
			} catch (Exception e) {

			}

		}
	}

}
