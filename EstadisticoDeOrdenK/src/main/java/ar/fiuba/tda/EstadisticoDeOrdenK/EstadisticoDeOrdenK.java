package ar.fiuba.tda.EstadisticoDeOrdenK;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EstadisticoDeOrdenK {

	public static void main(String[] args) {
		if(args.length < 1 || args.length > 4) {
			displayHelp();
			System.out.println("HOLA");
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
		
		for(int k = 0; k < intarray.length; ++k) {
			System.out.println(intarray[k]);	
		}
		
		
		if (args[0].compareTo("fb") == 0) {
			System.out.println("fb");
			Algoritmos algoritmo = new FuerzaBruta();
			int candidato = Integer.parseInt(args[1]);
			int estadistico = algoritmo.calcularEstadistico(intarray, candidato);
			System.out.println("Candidato " + candidato + " encontrado");
			System.out.println("Orden estadistico " + estadistico);
//			boolean encontrado = false;
//			int k = 0;
//			while(k < intarray.length && !encontrado) {
//				int estadistico = algoritmo.calcularEstadistico(intarray, k);
//				System.out.println(estadistico);
//				encontrado = (candidato == estadistico);
//				++k;
//			}
//			if(encontrado) {
//				System.out.println("Candidato " + candidato + " encontrado");
//				System.out.println("Orden estadistico " + (k-1));
//			}
		}
		else if (args[0].compareTo("os") == 0) {
			System.out.println("os");
			Algoritmos algoritmo = new OrdenarYseleccionar();
			int k = Integer.parseInt(args[1]);
			int estadistico = algoritmo.calcularEstadistico(intarray, k);
			System.out.println("Estadistico " + estadistico);
		}
		else if (args[0].compareTo("ks") == 0) {
			System.out.println("ks");
			Algoritmos algoritmo = new Kselecciones();
			int k = Integer.parseInt(args[1]);
			int estadistico = algoritmo.calcularEstadistico(intarray, k);
			System.out.println("Estadistico " + estadistico);	
		}
		else if (args[0].compareTo("kh") == 0) {
			System.out.println("kh");
			Algoritmos algoritmo = new Kheapsort();	
			int k = Integer.parseInt(args[1]);
			int estadistico = algoritmo.calcularEstadistico(intarray, k);
			System.out.println("Estadistico " + estadistico);	
		}
		else if (args[0].compareTo("hs") == 0) {
			System.out.println("hs");
			Algoritmos algoritmo = new HeapSelect();
			int k = Integer.parseInt(args[1]);
			int estadistico = algoritmo.calcularEstadistico(intarray, k);
			System.out.println("Estadistico " + estadistico);	
		}
		else if (args[0].compareTo("qs") == 0) {
			System.out.println("qs");
			Algoritmos algoritmo = new QuickSelect();
			int k = Integer.parseInt(args[1]);
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
		System.out.println("	K: Candidato (para fb) / Orden del algoritmo (para el resto)");
		System.out.println(" ");
		System.out.println("	VECTOR: Vector a aplicar el algoritmo");
		System.out.println(" ");
		System.out.println("Ejemplo:");
		System.out.println("	java -jar EstadisticoDeOrdenK.jar fb 0 \"3 5 89 55 164 42 0 77 911 22\"");
		System.out.println("	java -jar EstadisticoDeOrdenK.jar hs 4 \"3 5 89 55 164 42 0 77 911 22\"");
	}
}
