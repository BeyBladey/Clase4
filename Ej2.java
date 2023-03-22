package clase4;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej2 {
	public static void main(String[]args) {
		String ruta = "/home/bigmati/Documentos/GitHub/Eclipse/Clase3numeros.txt"; //Carga de ruta en un string
		String [] numeros = null; //Inicializacion en null para suprimir un error
		try {
			for (String linea : Files.readAllLines(Paths.get(ruta))) {
				numeros=linea.split(" "); //Separa los numeros por espacios
			}
		}catch (IOException e) {
			e.printStackTrace();
		} //Ya paso la lectura del archivo y se guardo el resultado en un vector string
		System.out.println(summul(numeros,false)); //Resultado de la suma.
		//True = suma, false = multiplicacion
	}
	public static int summul (String x[],boolean suma) {
		int res =0;
		if(suma) {
			for(int i=0;i<x.length;i++) {
				res+=Integer.parseInt(x[i]);
			}
		}else {
			res=1; //Para evitar anular la multiplicación al multiplicar todo por 0
			for(int i=0;i<x.length;i++) {
				res*=Integer.parseInt(x[i]);
			}
		}
		return res;
	}
}
