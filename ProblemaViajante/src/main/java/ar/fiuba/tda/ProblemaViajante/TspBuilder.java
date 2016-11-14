package ar.fiuba.tda.ProblemaViajante;

public class TspBuilder {

	public static ProblemaViajante crearProblemaViajante(String tspFile) {
		// Harcodeo temporal para test
		int numCiudades = 4;
		int[][] distancias = new int[numCiudades][numCiudades];
		for (int i = 0; i < numCiudades; ++i) {
			distancias[i][i] = 0;
		}
		distancias[0][1] = 1;
		distancias[0][2] = 15;
		distancias[0][3] = 6;
		distancias[1][0] = 2;
		distancias[1][2] = 7;
		distancias[1][3] = 3;
		distancias[2][0] = 9;
		distancias[2][1] = 6;
		distancias[2][3] = 12;
		distancias[3][0] = 10;
		distancias[3][1] = 4;
		distancias[3][2] = 8;

		return new ProblemaViajante(numCiudades, 1, distancias);
	}

	// http://stackoverflow.com/questions/7159259/optimized-tsp-algorithms
	
	// private class TspParser {
	//
	// private int numCiudades, dimension;
	//
	// public TspParser(String filename) throws IOException {
	// FileReader input = new FileReader(filename);
	// BufferedReader bufRead = new BufferedReader(input);
	//
	// String myLine = bufRead.readLine();
	// int V = Integer.parseInt(myLine.substring(myLine.indexOf('{') + 1,
	// myLine.indexOf('}')));
	// grafo = new Digrafo(V);
	// heuristica = new Heuristica(V);
	//
	// // Parseo nodos
	// for (int i = 0; i < V; ++i) {
	// myLine = bufRead.readLine();
	// String[] coordNode = myLine.substring(myLine.indexOf('(') + 1,
	// myLine.indexOf(')')).split(",");
	// heuristica.agregarNodo(i, Integer.parseInt(coordNode[0]),
	// Integer.parseInt(coordNode[1]));
	// }
	//
	// // Parseo aristas
	// while ((myLine = bufRead.readLine()) != null) {
	// String[] e = myLine.substring(myLine.indexOf('[') + 1,
	// myLine.indexOf(']')).split(",");
	// grafo.add_edge(Integer.parseInt(e[0]), Integer.parseInt(e[1]),
	// Integer.parseInt(e[2]));
	// }
	//
	// bufRead.close();
	// }
	//
	// public Digrafo getDigrafo() {
	// return grafo;
	// }
	//
	// public Heuristica getHeuristica() {
	// return heuristica;
	// }
	// }
}
