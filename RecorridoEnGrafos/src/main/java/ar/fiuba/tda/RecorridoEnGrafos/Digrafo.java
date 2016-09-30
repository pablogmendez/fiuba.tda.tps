package ar.fiuba.tda.RecorridoEnGrafos;

public class Digrafo {
	/*
	 * Grafo no dirigido con un número fijo de vértices
	 * 
	 * Los vértices son siempre números enteros no negativos. El primer vértice
	 * es 0 El grafo se crea vacío, se añaden las aristas con add_edge(). Una
	 * vez creadas, las aristas no se pueden eliminar, pero siempre se puede
	 * añadir nuevas aristas.
	 */

	/* Construye un grafo sin aristas de V vértices */
	public Digrafo(int V) {

	}

	/* Número de vértices en el grafo */
	public int V() {
		return 0;
	}

	/* Número de aristas en el grafo */
	public int E() {
		return 0;
	}

	/* Itera sobre los aristas incidentes _desde_ v */
	public void adj_e(int v) {
	}

	/* Itera sobre los vértices adyacentes a ‘v’ */
	public void adj(int v) {

	}

	/* Añade una arista al grafo */
	public void add_edge(int u, int v, int peso) {

	}

	/* Itera de 0 a V */
	public void __iter__() {
		// return iter(range(g.V()));
	}

	/* Itera sobre todas las aristas del grafo */
	public void iter_edges() {
	}
}
