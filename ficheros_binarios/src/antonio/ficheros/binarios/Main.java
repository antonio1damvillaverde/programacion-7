package antonio.ficheros.binarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

	public static void main(String[] args) {

		ejercicio1();
//		ejercicio2();
	}

	private static void ejercicio1() {

		try {
			
			File file = new File("C:\\Users\\Antonio\\Documents\\DAM\\input.txt");
			FileInputStream fIn = new FileInputStream(file);
			FileOutputStream fOut = new FileOutputStream(file);
			int i;
			for (i = 1; i < 100; i++) {
				fOut.write(i);
			}
			fOut.close();
			while ((i = fIn.read()) != -1) {
				System.out.println(i);
			}
			fIn.close();
		}

		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private static void ejercicio2() {

		try {
			
			File file = new File("C:\\Users\\Antonio\\Documents\\DAM\\input.txt");
			FileInputStream fIn = new FileInputStream(file);
			FileOutputStream fOut = new FileOutputStream(file);
			int letra;
			for (letra = 'a'; letra <= 'z'; letra++) {
				System.out.println("Byte: " + letra);
				fOut.write(letra);
			}
			fOut.close();
			while ((letra = fIn.read()) != -1) {
				System.out.println((char) letra);
			}
			fIn.close();
		}

		catch (Exception e) {
			e.getStackTrace();
		}
		
	}

}
