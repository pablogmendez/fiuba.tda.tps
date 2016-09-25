package estadisticoDeOrdenK;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class EstadisticoDeOrdenK {

	public static void main(String[] args) {
		if(args.length < 1 || args.length > 3) {
			displayHelp();
			System.exit(0);
		} 
		
		// Convierto el char array en un int array
		StringTokenizer st = new StringTokenizer(args[2]);
		ArrayList<String> ls = new ArrayList<String>();		
		while (st.hasMoreElements()) {
			ls.add(st.nextElement().toString());
		}
		int[] intarray = new int[ls.size()];
		int i=0;
		for(String numero:ls) {
			intarray[i]=Integer.parseInt(numero);
			i++;
		}
		
		if (args[0] == "fb") {
			Algoritmos algoritmo = new FuerzaBruta();
			if (args[1] == "min") {
				algoritmo.minimo(intarray);
			}
			else if (args[0] == "mid") {
				algoritmo.mediana(intarray);
			}
			else if (args[0] == "max") {
				algoritmo.maximo(intarray);
			}
			else {
				displayHelp();
				System.exit(0);
			}
		}
		else if (args[0] == "hs") {
			Algoritmos algoritmo = new FuerzaBruta();
			if (args[1] == "min") {
				algoritmo.minimo(intarray);
			}
			else if (args[0] == "mid") {
				algoritmo.mediana(intarray);
			}
			else if (args[0] == "max") {
				algoritmo.maximo(intarray);
			}
			else {
				displayHelp();
				System.exit(0);
			}			
		}
		else if (args[0] == "kh") {
			Algoritmos algoritmo = new Kheapsort();
			if (args[1] == "min") {
				algoritmo.minimo(intarray);
			}
			else if (args[0] == "mid") {
				algoritmo.mediana(intarray);
			}
			else if (args[0] == "max") {
				algoritmo.maximo(intarray);
			}
			else {
				displayHelp();
				System.exit(0);
			}			
		}
		else if (args[0] == "ks") {
			Algoritmos algoritmo = new Kselecciones();
			if (args[1] == "min") {
				algoritmo.minimo(intarray);
			}
			else if (args[0] == "mid") {
				algoritmo.mediana(intarray);
			}
			else if (args[0] == "max") {
				algoritmo.maximo(intarray);
			}
			else {
				displayHelp();
				System.exit(0);
			}			
		}
		else if (args[0] == "os") {
			Algoritmos algoritmo = new OrdenarYseleccionar();
			if (args[1] == "min") {
				algoritmo.minimo(intarray);
			}
			else if (args[0] == "mid") {
				algoritmo.mediana(intarray);
			}
			else if (args[0] == "max") {
				algoritmo.maximo(intarray);
			}
			else {
				displayHelp();
				System.exit(0);
			}			
		}
		else if (args[0] == "qs") {
			Algoritmos algoritmo = new QuickSelect();
			if (args[1] == "min") {
				algoritmo.minimo(intarray);
			}
			else if (args[0] == "mid") {
				algoritmo.mediana(intarray);
			}
			else if (args[0] == "max") {
				algoritmo.maximo(intarray);
			}
			else {
				displayHelp();
				System.exit(0);
			}			
		}
		else {
			displayHelp();
			System.exit(0);			
		}
	}

	
	private static void displayHelp() {
		System.out.println("Estadistico de Orden K");
		System.out.println("Uso:");
		System.out.println("	java -jar EstadisticoDeOrdenK.jar ALGORITMO K VECTOR");
		System.out.println(" ");
		System.out.println("Parametros:");
		System.out.println("	ALGORITMO: Algoritmo de ejecucion del estadistico");
		System.out.println("		fb: Fuerza Bruta");
		System.out.println("		hs: Heap Select");
		System.out.println("		kh: K Heapsort");
		System.out.println("		ks: K Selecciones");
		System.out.println("		os: Ordenar y Seleccionar");
		System.out.println("		qs: Quick Select");
		System.out.println(" ");
		System.out.println("	K: Orden del algoritmo");
		System.out.println("		min: Calcula el estadistico de orden 0");
		System.out.println("		mid: Calcula la mediana");
		System.out.println("		max: Calcula el estadistico de mayor orden");
		System.out.println(" ");
		System.out.println("	VECTOR: Vector a aplicar el algoritmo");
		System.out.println(" ");
		System.out.println("Ejemplo:");
		System.out.println("	java -jar EstadisticoDeOrdenK.jar fb min \"3 5 89 55 164 42 0 77 911 22\"");
	}
}
