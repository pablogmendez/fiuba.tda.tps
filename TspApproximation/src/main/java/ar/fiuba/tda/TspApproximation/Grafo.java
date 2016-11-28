package ar.fiuba.tda.TspApproximation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Grafo {

	private ArrayList<Arista>[] adjacents;
	private int E;

	/* Construye un grafo sin aristas de V vértices */
	@SuppressWarnings("unchecked")
	public Grafo(int V) {
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
		Arista[] aristas = new Arista[adjacents[v].size()];
		int i = 0;
		Iterator<Arista> it = adjacents[v].iterator();
		while (it.hasNext()) {
			aristas[i] = it.next();
			++i;
		}
		return aristas;
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
		adjacents[v].add(new Arista(v, u, peso));
		E++;
	}

	/* Genera arbol de tendido minimo */
	public Grafo generarArbolDeTendido(int inicio) {
		PriorityQueue<PrVertex> cola = new PriorityQueue<PrVertex>(V());

		/* Estructuras auxiliares con info de la cola para rapida consulta */
		boolean[] estaEnCola = new boolean[V()];
		int[] padre = new int[V()];
		int[] costo = new int[V()];

		/* Init */
		for (int v = 0; v < V(); v++) {
			estaEnCola[v] = true;
			padre[v] = -1;
			if (v != inicio) {
				costo[v] = Integer.MAX_VALUE;
			}
			else {
				costo[v] = 0;
			}
			cola.offer(new PrVertex(v, costo[v]));
		}

		while (!cola.isEmpty()) {
			PrVertex vConPeso = cola.poll();
			int v = vConPeso.vertice;
			estaEnCola[v] = false;

			for (Arista e : adj_e(v)) {
				int u = e.getDestino();
				if (estaEnCola[u] && costo[u] > e.getPeso()) {
					padre[u] = v;
					costo[u] = e.getPeso();
					// No se usa el costo para el remove
					// No tengo metodo update
					cola.remove(new PrVertex(u, 0));
					cola.offer(new PrVertex(u, costo[u]));
				}
			}
		}

		Grafo arbol = new Grafo(V());
		for (int v = 0; v < V(); ++v) {
			if (v != inicio) {
				arbol.add_edge(padre[v], v, costo[v]);
			}
		}
		return arbol;
	}

	private class PrVertex implements Comparable<PrVertex> {
		public int vertice, costo;

		public PrVertex(int v, int costo) {
			this.vertice = v;
			this.costo = costo;
		}

		@Override
		public int compareTo(PrVertex o) {
			return Integer.compare(this.costo, o.costo);
		}

		@Override
		public boolean equals(Object o) {
			PrVertex other = (PrVertex) o;
			return vertice == other.vertice;
		}
	}
}
