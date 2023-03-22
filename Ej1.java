package clase4;
import java.util.Scanner;
public class Ej1 {
	public static void main (String[]args) {
		Scanner in = new Scanner (System.in);
		int c,b,a;
		char x;
		int []test1= orbe(9,99,33,'a'); //Llamando a la funcion con sus parametros
		int []test = orbe(c = in.nextInt(),b = in.nextInt(),a = in.nextInt(),x = in.next().charAt(0)); //Pidiendo datos por consola
		
	}
	public static int []orbe (int a, int b, int c, char x){
		int[]orbe = {a,b,c};
		boolean asc=true;
		if (x=='a' || x=='A')
			asc=true;
		else if(x=='d'||x=='D')
			asc=false;
		for (int i=0;i<orbe.length;i++) {
			for (int j=0;j<(orbe.length-1-i);j++) {
				if(asc) {
					if(orbe[j]>orbe[j+1]) {
						int aux=orbe[j];
						orbe[j]=orbe[j+1];
						orbe[j+1]=aux;
					}
				}else {
					if(orbe[j]<orbe[j+1]) {
						int aux = orbe[j];
						orbe[j]=orbe[j+1];
						orbe[j+1]=aux;
					}
				}
			}
		}
		return orbe;
		
	}
}