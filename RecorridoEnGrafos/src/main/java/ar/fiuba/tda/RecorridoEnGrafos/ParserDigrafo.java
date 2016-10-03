package ar.fiuba.tda.RecorridoEnGrafos;

public class ParserDigrafo {

	private Digrafo grafo = null;
	private Heuristica heuristica = null;
	
	public ParserDigrafo(String filename) {
		/* Parsear el archivo. Ni preocuparse por cosas como "que pasa si los nodos estan desordenados?". Formato:
		 * V:{9} -> primera linea, cantidad de nodos. Parsear numero entre llaves
		 * v0:(1,1) -> lineas con nodos (ordenados). Parsear lo que esta entre parentesis (coordenada, para la heuristica)
		 * v1:(3,0)
		 * ...
		 * e0:[0,1,2] -> lineas con aristas. Parsear lo que esta entre corchetes [src, dst, weight]
		 * e1:[0,2,2]
		 * ... 
		 * */
	}
	
	public Digrafo getDigrafo() {
		return grafo;
	}
	
	public Heuristica getHeuristica() {
		return heuristica;
	}
}
