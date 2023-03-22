package clase4;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ej3 {

	public static void main (String[]args) throws Exception {
		String rutaEnc = "/home/bigmati/Documentos/GitHub/Eclipse/Clase3/src/clase4/encriptar.txt";
		String rutaDes = "/home/bigmati/Documentos/GitHub/Eclipse/Clase3/src/clase4/resultado.txt";
		String textoEncriptar = null;
		try {
			for (String linea : Files.readAllLines(Paths.get(rutaEnc))) {
				textoEncriptar=linea;
			}
		}catch (IOException e) {
			System.out.println("Error al cargar el archivo");
		}
		int desplazamiento = 1;
		char encriptado [] = textoEncriptar.toCharArray();
		char desencriptar [];
		for (int i=0;i<textoEncriptar.length();i++) {
			encriptado[i]=encriptar(encriptado[i],desplazamiento);
		}
		System.out.println("Se encripto el archivo correctamente");
		desencriptar=encriptado;
		for (int i=0;i<desencriptar.length;i++) {
			desencriptar[i]=encriptar(desencriptar[i], desplazamiento, true);
		}
		System.out.println("Se desencripto el archivo correctamente");
		FileWriter test = new FileWriter(rutaDes);
		test.write(desencriptar);
		test.close();
	}
	//No esta supervisado en caso de numeros negativos
	public static char encriptar(char letra, int desplazamiento) throws Exception {
		try {
			String abc = "abcdefghijklmnñopqrstuvwxyz"; //No estan contempladas las mayusculas
			char abecedario [] = abc.toCharArray();
			char resultado = 0;
			if(letra==' ')
				return '!';
			else {
				for (int i=0;i<abecedario.length;i++) {
					if(i>=26) //Fix por si la letra es Z
						return abecedario[0];
					else if(abecedario[i]==letra) {
						resultado=abecedario[i+desplazamiento];
						break;
					}
				}
			return resultado;
			}
		} catch (Exception e) {
			System.out.println("Error al encriptar el archivo: ");
			e.printStackTrace();
		}
		return letra;
	}
	public static char encriptar (char letra, int desplazamiento, boolean x) {
		try {
			String abc = "abcdefghijklmnñopqrstuvwxyz";
			char abecedario []=abc.toCharArray();
			char resultado=0;
			for (int i=0;i<abecedario.length;i++) {
				if(abecedario[i]==letra) {
					if ((i-desplazamiento)<0)
						return abecedario[abecedario.length-desplazamiento];
					resultado=abecedario[i-desplazamiento];
				}
			}
			if(letra=='!')
				return ' ';
			return resultado;
		} catch (Exception e) {
			System.out.println("Error al desencriptar el archivo: ");
			e.printStackTrace();
		}
		return letra;
	}
}
