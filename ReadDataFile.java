package javaprograms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFile {

	public static void main(String a[]) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:\\internship\\java\\javaallprograms\\resources\\property.txt"));
			String  strline;
			
			while((strline =br.readLine())!=null){
				System.out.println(strline);
			}
		}
		catch (FileNotFoundException fe) {
			System.out.println(" file not found");
		} catch (IOException io) {
			System.out.println(" file not found");
		}
}

}
 
