package CriptografiaMetodos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Escitala {

	static String msj;
	static int caras;
	static int largo;
	static int val = 0;
	static char[][] matriz;
	static char[][] matrizT;

	public double largoMensaje(String mensaje) {
		int cadena;
		double num = 0;
		FileReader f;
		try {
			f = new FileReader(mensaje);
			cadena = f.read();
			while (cadena != -1) {
				num += 1;
				cadena = f.read();
			}
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}

	public static void llenaMatriz(int filas, int columnas, String mensaje) {
		matriz = new char[filas][columnas];
		int cadena;
		FileReader f;
		try {
			f = new FileReader(mensaje);
			cadena = f.read();
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					if (cadena == -1) {
						matriz[i][j] = (char) 32;
					} else {
						matriz[i][j] = (char) cadena;
						cadena = f.read();
					}
				}
			}
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void transpuesta(char[][] mat) {
		if (val != 0) {
			matrizT = new char[largo][caras];
			for (int i = 0; i < mat[0].length; i++) {
				for (int j = 0; j < caras; j++) {
					matrizT[i][j] = mat[j][i];
				}
			}
		} else {
			matrizT = new char[caras][largo];
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < caras; j++) {
					matrizT[j][i] = mat[i][j];
				}
			}
		}

	}

	public void Cifrar(String dir, int numCaras) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		msj = dir;
		caras = numCaras;
		largo = (int) Math.ceil(largoMensaje(msj) / numCaras);
		llenaMatriz(largo, caras, msj);
		transpuesta(matriz);
		try {
			fichero = new FileWriter(msj.substring(0, msj.length() - 4) + "C.txt");
			pw = new PrintWriter(fichero);
			for (int i = 0; i < caras; i++) {
				for (int j = 0; j < largo; j++) {
					pw.write(matrizT[i][j]);
				}
			}
			fichero.close();
			matriz = null;
			matrizT = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Descifrar(String dir, int numCaras) {
		val = 1;
		FileWriter fichero = null;
		PrintWriter pw = null;
		msj = dir;
		caras = numCaras;
		largo = (int) Math.ceil(largoMensaje(msj) / numCaras);
		llenaMatriz(caras, largo, msj);
		transpuesta(matriz);
		try {
			fichero = new FileWriter(msj.substring(0, msj.length() - 5) + "D.txt");
			pw = new PrintWriter(fichero);
			for (int i = 0; i < matrizT.length; i++) {
				for (int j = 0; j < caras; j++) {
					pw.write(matrizT[i][j]);
				}
			}
			fichero.close();
			matriz = null;
			matrizT = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
