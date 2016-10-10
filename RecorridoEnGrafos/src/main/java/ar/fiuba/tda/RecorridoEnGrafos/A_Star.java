package ar.fiuba.tda.RecorridoEnGrafos;

public class A_Star extends Camino {

	private double dist[]; // Inicializar a +∞.
	private double pred[];
	private boolean visited[];
	Heuristica h;

	public A_Star(Digrafo g, int origen, int destino, Heuristica h) {
		super(g, origen, destino);
		this.h = h;

		dist = new double[g.V()];
		pred = new double[g.V()];
		visited = new boolean[g.V()];
		edge = new Arista[g.V()];
		
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Double.POSITIVE_INFINITY;
		}

		dist[origen] = 0;

		for (int i = 0; i < dist.length; i++) {
			int next = minVertex(dist, visited);
			visited[next] = true;

			// The shortest path to next is dist[next] and via pred[next].

			int n[] = g.adj(next);
			for (int j = 0; j < n.length; j++) {
				int v = n[j];
				Arista[] as = g.adj_e(next);
				double d = 0;
				for (Arista a : as) {
					if (a.getOrigen() == next && a.getDestino() == v) {
						d = dist[next] + a.getPeso() + this.h.calcular(next, v);
						break;
					}
				}
				if (dist[v] > d) {
					dist[v] = d;
					pred[v] = next;
				}
			}
		}
		double i = destino;
		while(i != origen) {
			edge[(int)i] = new Arista((int)pred[(int) i], (int)i, (int)dist[(int)i]);
			i = pred[(int)i];
		}
	}

	private int minVertex(double[] dist2, boolean[] v) {
		double x = Double.POSITIVE_INFINITY;
		int y = -1; // graph not connected, or no unvisited vertices
		for (int i = 0; i < dist2.length; i++) {
			if (!v[i] && dist2[i] < x) {
				y = i;
				x = dist2[i];
			}
		}
		return y;
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
