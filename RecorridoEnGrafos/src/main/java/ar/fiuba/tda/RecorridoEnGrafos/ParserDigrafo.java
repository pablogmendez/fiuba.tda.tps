package ar.fiuba.tda.RecorridoEnGrafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParserDigrafo {

	private Digrafo grafo = null;
	private Heuristica heuristica = null;

	public ParserDigrafo(String filename) throws IOException {
		/*
		 * Parsear el archivo. Ni preocuparse por cosas como
		 * "que pasa si los nodos estan desordenados?". Formato: V:{9} ->
		 * primera linea, cantidad de nodos. Parsear numero entre llaves
		 * v0:(1,1) -> lineas con nodos (ordenados). Parsear lo que esta entre
		 * parentesis (coordenada, para la heuristica) v1:(3,0) ... e0:[0,1,2]
		 * -> lineas con aristas. Parsear lo que esta entre corchetes [src, dst,
		 * weight] e1:[0,2,2] ...
		 */

		FileReader input = new FileReader(filename);
		BufferedReader bufRead = new BufferedReader(input);

		// Parseo cantidad de nodos
		String myLine = bufRead.readLine();
		int V = Integer.parseInt(myLine.substring(myLine.indexOf('{') + 1, myLine.indexOf('}')));
		grafo = new Digrafo(V);
		heuristica = new Heuristica(V);

		// Parseo nodos
		for (int i = 0; i < V; ++i) {
			myLine = bufRead.readLine();
			String[] coordNode = myLine.substring(myLine.indexOf('(') + 1, myLine.indexOf(')')).split(",");
			heuristica.agregarNodo(i, Integer.parseInt(coordNode[0]), Integer.parseInt(coordNode[1]));
		}

		// Parseo aristas
		while ((myLine = bufRead.readLine()) != null) {
			String[] e = myLine.substring(myLine.indexOf('[') + 1, myLine.indexOf(']')).split(",");
			grafo.add_edge(Integer.parseInt(e[0]), Integer.parseInt(e[1]), Integer.parseInt(e[2]));
		}

		bufRead.close();
	}

	public Digrafo getDigrafo() {
		return grafo;
	}

	public Heuristica getHeuristica() {
		return heuristica;
	}
}
