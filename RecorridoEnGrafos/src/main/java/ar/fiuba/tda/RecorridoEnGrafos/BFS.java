package ar.fiuba.tda.RecorridoEnGrafos;

import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Camino {

	private double dist[]; // Inicializar a +∞.
	private boolean marked[];

	public BFS(Digrafo g, int origen, int destino) {
		super(g, origen, destino);

		// Creo la cola
		Queue<Integer> q = new LinkedList<Integer>();

		// Inicializo las distancias a infinito
		dist = new double[g.V()];
		marked = new boolean[g.V()];
		for (int i = 0; i < dist.length; ++i)
			dist[i] = Double.POSITIVE_INFINITY;

		// Inicializo el vector de aristas
		edge = new Arista[g.V()];

		dist[origen] = 0;
		marked[origen] = true;
		q.add(origen);

		while (!q.isEmpty()) {
			int v = q.remove();
			int i = -1;
			int w = 0;
			int adj[] = g.adj(v);
			if(adj.length > 0) {
				do {
					++i;
					w = adj[i];
					edge[w] = new Arista(v, w, 1);
					dist[w] = distancia(v) + 1;
					marked[w] = true;
					q.add(w);
				} while (i < adj.length - 1 && w != destino);
			}
			if(w == destino)
				break;
		}
	}

	@Override
	public double distancia(int v) {
		return dist[v];
	}

	@Override
	protected Arista edge_to(int v) {
		return edge[v];
	}
}
