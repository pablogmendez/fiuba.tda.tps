package ar.fiuba.tda.RecorridoEnGrafos;

import java.util.ArrayList;

public class Digrafo {
	/*
	 * Grafo dirigido con un número fijo de vértices
	 * 
	 * Los vértices son siempre números enteros no negativos. El primer vértice
	 * es 0 El grafo se crea vacío, se añaden las aristas con add_edge(). Una
	 * vez creadas, las aristas no se pueden eliminar, pero siempre se puede
	 * añadir nuevas aristas.
	 */

	private ArrayList<Arista>[] adjacents;
	private int E;

	/* Construye un grafo sin aristas de V vértices */
	@SuppressWarnings("unchecked")
	public Digrafo(int V) {
		assert (V > 0);
		adjacents = (ArrayList<Arista>[]) (new ArrayList[V]);
		for (int i = 0; i < adjacents.length; i++) {
			adjacents[i] = new ArrayList<Arista>();
		}
		this.E = 0;
	}

	/* Número de vértices en el grafo */
	public int V() {
		return adjacents.length;
	}

	/* Número de aristas en el grafo */
	public int E() {
		return E;
	}

	/* Itera sobre los aristas incidentes _desde_ v */
	public Arista[] adj_e(int v) {
		assert (v >= 0 && v < adjacents.length);
		return (Arista[]) adjacents[v].toArray();
	}

	/* Itera sobre los vértices adyacentes a ‘v’ */
	public int[] adj(int v) {
		assert (v >= 0 && v < adjacents.length);
		int[] adjList = new int[adjacents[v].size()];
		for (int i = 0; i < adjacents[v].size(); i++) {
			adjList[i] = adjacents[v].get(i).getDestino();
		}
		return adjList;
	}

	/* Añade una arista al grafo */
	public void add_edge(int u, int v, int peso) {
		adjacents[u].add(new Arista(u, v, peso));
		E++;
	}
}
