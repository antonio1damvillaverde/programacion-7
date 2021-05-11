package antonio.ficheros.binarios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		ejercicio1();
		ejercicio2();
		ejercicio3();
		ejercicio4();
		ejercicio5();
	}

	private static void ejercicio5() {

		double[][] data;
		DataInputStream in = null;
		try {
			
			File file = new File("D:\\martes.dat");
			FileInputStream fIn = new FileInputStream(file);
			BufferedInputStream bIn = new BufferedInputStream(fIn);
			in = new DataInputStream(bIn);
			int row = in.readInt();
			System.out.println("Filas: " + row);
			int col = in.readInt();
			System.out.println("Columnas: " + col);
			data = new double[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					data[i][j] = in.readDouble();
					String dato = "dato[" + i + "][" + j + "] = " + data[i][j];
					System.out.println(dato);
				}
			}
			fIn.close();
			bIn.close();
			in.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void ejercicio4() {

		double[][] matriz = { { 2.0, 3.0, 4.0 }, { -2.0, -3.0, -4.0 } };
		File f = new File("D:\\martes.dat");
		int row = matriz.length; // 2
		int col = matriz[0].length; // 3

		try {
			FileOutputStream fOut = new FileOutputStream(f);
			BufferedOutputStream bOut = new BufferedOutputStream(fOut);
			DataOutputStream dOut = new DataOutputStream(bOut);
			dOut.writeInt(row);
			dOut.writeInt(col);
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					dOut.writeDouble(matriz[i][j]);
				}
			}
			dOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void ejercicio3() {

		try {

			File file = new File("D:\\input.bin");
			FileInputStream fIn = new FileInputStream(file);
			FileOutputStream fOut = new FileOutputStream(file);
			DataInputStream dIn = new DataInputStream(fIn);
			DataOutputStream dOut = new DataOutputStream(fOut);
			String[] nombres = { "Luis", "Rosa", "Juan" };
			int[] edades = { 18, 19, 18 };
			for (int i = 0; i < 3; i++) {

				dOut.writeUTF(nombres[i]);
				dOut.writeInt(edades[i]);
			}
			dOut.close();
			String nombre;
			int edad;
			try {
				while (true) {
					nombre = dIn.readUTF();
					edad = dIn.readInt();
					System.out.println("Nombre: " + nombre + ", Edad: " + edad);
				}
			} catch (Exception e) {

			} finally {
				dIn.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void ejercicio1() {

		try {

			File file = new File("D:\\input.txt");
			FileInputStream fIn = new FileInputStream(file);
			FileOutputStream fOut = new FileOutputStream(file);
			int i;
			for (i = 1; i < 100; i++) {
				fOut.write(i);
			}
			fOut.close();
			while ((i = fIn.read()) != -1) {
				System.out.print((char) i);
			}
			fIn.close();
		}

		catch (Exception e) {
			e.getStackTrace();
		}
	}

	private static void ejercicio2() {

		try {

			File file = new File("D:\\input.txt");
			FileInputStream fIn = new FileInputStream(file);
			FileOutputStream fOut = new FileOutputStream(file);
			int letra;
			for (letra = 'a'; letra <= 'z'; letra++) {
				fOut.write(letra);
			}
			fOut.close();
			while ((letra = fIn.read()) != -1) {
				System.out.println("Byte: " + letra + ", Char: " + (char) letra);
			}
			fIn.close();
		}

		catch (Exception e) {
			e.getStackTrace();
		}

	}

}
