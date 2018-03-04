package CriptografiaMetodos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Polybios {
	static char [][] matriz = {{' ','!','"','#','$','%','&',39,'(',')','*','+',',','-','.'},
			 				   {'/','0','1','2','3','4','5','6','7','8','9',':',';','<','='},
							   {'>','?','@','A','B','C','D','E','F','G','H','I','J','K','L'},
							   {'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','['},
  							   {92,']','^','_','`','a','b','c','d','e','f','g','h','i','j'},
							   {'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y'},
							   {'z','{','|','}','~','Ç','ü','é','â','ä','à','å','ç','ê','ë'},
							   {'è','ï','î','ì','Ä','Å','É','æ','Æ','ô','ö','ò','û','ù','ÿ'},
							   {'Ö','Ü','ø','£','Ø','×','ƒ','á','í','ó','ú','ñ','Ñ','ª','º'},
							   {'¿','®','¬','½','¼','¡','«','»','░','▒','▓','│','┤','Á','Â'},
							   {'À','©','╣','║','╗','╝','¢','¥','┐','└','┴','┬','├','─','┼'},
							   {'ã','Ã','╚','╔','╩','╦','╠','═','╬','¤','ð','Ð','Ê','Ë','È'},
							   {'ı','Í','Î','Ï','┘','┌','█','▄','¦','Ì','▀','Ó','ß','Ô','Ò'},
							   {'õ','Õ','µ','þ','Þ','Ú','Û','Ù','ý','Ý','¯','´','≡','±','‗'},
							   {'¾','¶','§','÷','¸','°','¨','·','¹','³','²','■',255}};
	
	static char [] fila = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ'};
	static char [] columna = {'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l'};
	static int bandera = 0;
	
//	public void llenaMatriz() {
//		int cadena;
//		FileReader f;
//		try {
//			f = new FileReader("./ascii.txt");
//			cadena = f.read();
//			for (int i= 0; i < 15; i++) {
//				for (int j = 0; j < 15; j++) {
//					if (cadena != 10) {
//						matriz[i][j] = (char)cadena;
//						if (cadena != -1) {
//							cadena = f.read();		
//						}
//					}
//				}
//			}
//			f.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public int buscaCaracter(char caracter){
		System.out.println("caracter "+caracter);
		int pos = -1;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(bandera == 0) {
					if(matriz[i][j] == caracter) {
						pos = i;
						return pos;
					}
				}else {
					if(matriz[i][j] == caracter) {
						pos = j;
						return pos;
					}
				}
			}
		}
		return pos;
	}
	
	public void Cifra(String ruta) {
		int cadena;
		int posicion;
		FileReader f;
		FileWriter fichero;
		PrintWriter pw;
		try {
			f = new FileReader(ruta);
			fichero = new FileWriter(ruta.substring(0, ruta.length() - 4) + "PC.txt");
			pw = new PrintWriter(fichero);
			
			cadena = f.read();
			System.out.println("cadena "+ cadena);
			while (cadena != -1) {
				posicion = buscaCaracter((char)cadena);
				if (posicion != -1) {
					pw.write(posicion);
					bandera = 1;
				}
				posicion = buscaCaracter((char)cadena);
				if (posicion != -1) {
					pw.write(posicion);
					bandera = 0;
				}
				cadena = f.read();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Descifra(String ruta) {
		int cadena1,cadena2;
		int p1 = 0,p2 = 0;
		FileReader f;
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ruta.substring(0, ruta.length() - 6) + "PD.txt");
			pw = new PrintWriter(fichero);
			f = new FileReader(ruta);
			cadena1 = f.read();
			cadena2 = f.read();
			while (cadena1 != -1 && cadena2 != -1) {
				for (int i = 0; i < fila.length; i++) {
					if (cadena1 == fila[i]) {
						p1 = i;
						break;
					}
				}
				for (int j = 0; j < columna.length; j++) {
					if (cadena2 == columna[j]) {
						p2 = j;
						break;
					}
				}
				pw.write(matriz[p1][p2]);
				cadena1 = f.read();
				cadena2 = f.read();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}