package CriptografiaMetodos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Polybios {
	static char [][] matriz = new char [15][15];
	static char [] fila = new char [15];
	static char [] columna = new char [15];
	
	public void llenaMatriz() {
		int cadena,i = 0, j= 0;
		FileReader f;
		try {
			f = new FileReader("ascii.txt");
			cadena = f.read();
			while (cadena != -1) {
				if (cadena != 10) {
					matriz[i][j] = (char)cadena;
					i += 1;
					j += 1;
				}
				cadena = f.read();
			}
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fc() {
		
	}
}
