package ar.fiuba.tda.FlujoEnRedes;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class FlujoEnRedes {

	public static void main(String[] args) {
		
		  if(args.length > 1) {
			displayHelp();
			System.exit(0);
		  } 
		
	      File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (args[0]);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         int N=Integer.parseInt(br.readLine());
	         int M=Integer.parseInt(br.readLine());
	         
	         // # vértices
	         int V = N+M+2;
	         
	         // Creo la matriz de adyacencia
	         int graph[][] =new int[V][V];

	         // La inicializo a 0
	     	 for(int i = 0; i < V; ++i){ 
	    		for(int j = 0; j < V; ++j){
	    			graph[i][j] = 0;
	    		}
	    	 }
	         
	         // Cmpleto los Ai
	         for(int i = 0; i < N; ++i) {
	        	 graph[N+i][V-1] = Integer.parseInt(br.readLine());
	         }
	         
	         // Cmpleto los Pi y los requisitos
	         for(int i = 0; i < M; ++i) {
	        	 // Convierto el char array en un int array
	 	 		 StringTokenizer st = new StringTokenizer(br.readLine());
	 	 		 ArrayList<String> ls = new ArrayList<String>();		
	 	 		 while (st.hasMoreElements()) {
	 	 			ls.add(st.nextElement().toString());
	 	 		 }	 
	 	 		 // Seteo la ganancia de realizar el proyecto Pi
	 	 		 graph[0][i+1] = Integer.parseInt(ls.get(0));

	 	 		 // Seteo los requisitos de realizar el proyecto Pi
	 	 		 for(int j = 1; j < ls.size(); ++j) {
	 	 			graph[i+1][M+Integer.parseInt(ls.get(j))] = Integer.MAX_VALUE;	 
	 	 		 }	        	 
	          }
//	     	for(int i = 0; i < V; ++i){ 
//	    		for(int j = 0; j < V; ++j){
//	    			System.out.print(graph[i][j]);
//	    			System.out.print(" ");
//	    		}
//	    		System.out.println("");
//	    	}

	        // Instancio Ford-Fulkerson
	         FordFulkerson ff = new FordFulkerson(V);
	         System.out.println("El maximo flujo posible es " + ff.fordFulkerson(graph, 0, V-1));
	         System.out.println("");
//	     	for(int i = 0; i < V; ++i){ 
//	    		for(int j = 0; j < V; ++j){
//	    			System.out.print(ff.rGraph[i][j]);
//	    			System.out.print(" ");
//	    		}
//	    		System.out.println("");
//	    	}
	         boolean ok;
	         System.out.println("Proyectos a realizar y areas a contratar:");
	         System.out.println("-----------------------------------------");
	         System.out.println("");
	         String out;
	         for(int i = 1; i <= M; ++i) {
	        	 ok = true;
	        	 out = "Proyecto: P" + i + ". Areas: ";
	        	 for(int j = N; j < V; ++j) {	 
	        		if (graph[i][j] == Integer.MAX_VALUE) {
	        			if (ff.rGraph[j][V-1] != 0) {
	        				ok = false;
	        				break;
	        			}
	        			else {
	        				out += "A" + (j - M) + ", ";
	        			}
	        		}
	        	 }
	        	 if(ok)
	        		 System.out.println(out);
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}

	private static void displayHelp() {
		System.out.println("FlujoEnRedes");
		System.out.println("Uso:");
		System.out.println("	java -jar FlujoEnRedes.jar PATH");
		System.out.println(" ");
		System.out.println("Parametros:");
		System.out.println("	  PATH: Ruta del archivo con la instancia del problema a resolver");
		System.out.println(" ");
		System.out.println("Ejemplo ejecucion:");
		System.out.println("	java -jar FlujoEnRedes.jar C:\\Users\\asd\\ejemplo1.txt");
		System.out.println(" ");
		System.out.println("Formato archivo:");
		System.out.println("	N");
		System.out.println("	M");
		System.out.println("	c1");
		System.out.println("	c2");
		System.out.println("	...");
		System.out.println("	g1 r11 r12 ...");
		System.out.println("	...");
		System.out.println(" ");
		System.out.println("Archivo ejemplo:");
		System.out.println("	3");
		System.out.println("	2");
		System.out.println("	16");
		System.out.println("	13");
		System.out.println("	9");
		System.out.println("	20 1 2");
		System.out.println("	10 3");
	}
	
}
