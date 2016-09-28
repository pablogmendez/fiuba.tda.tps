package ar.fiuba.tda.EstadisticoDeOrdenK;

import java.lang.reflect.Array;
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
			int candidato = Integer.parseInt(args[3]);
			boolean encontrado = false;
			int k = 0;
			while(k < intarray.length && !encontrado) {
				int estadistico = algoritmo.calcularEstadistico(intarray, k);
				encontrado = (candidato == estadistico);
				++k;
			}
			if(encontrado) {
				System.out.println("Candidato " + candidato + "encontrado");
				System.out.println("Orden estadistico " + (k-1));
			}
		}
		else if (args[0] == "os") {
			Algoritmos algoritmo = new OrdenarYseleccionar();
			int k = Integer.parseInt(args[3]);
			int estadistico = algoritmo.calcularEstadistico(intarray, k);
			System.out.println("Estadistico " + estadistico);
		}
		else if (args[0] == "ks") {
			Algoritmos algoritmo = new Kselecciones();
			int k = Integer.parseInt(args[3]);
			int estadistico = algoritmo.calcularEstadistico(intarray, k);
			System.out.println("Estadistico " + estadistico);	
		}
		else if (args[0] == "kh") {
			Algoritmos algoritmo = new Kheapsort();	
			int k = Integer.parseInt(args[3]);
			int estadistico = algoritmo.calcularEstadistico(intarray, k);
			System.out.println("Estadistico " + estadistico);	
		}
		else if (args[0] == "hs") {
			Algoritmos algoritmo = new HeapSelect();
			int k = Integer.parseInt(args[3]);
			int estadistico = algoritmo.calcularEstadistico(intarray, k);
			System.out.println("Estadistico " + estadistico);	
		}
		else if (args[0] == "qs") {
			Algoritmos algoritmo = new QuickSelect();
			int k = Integer.parseInt(args[3]);
			int estadistico = algoritmo.calcularEstadistico(intarray, k);
			System.out.println("Estadistico " + estadistico);	
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
