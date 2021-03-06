package ar.fiuba.tda.RecorridoEnGrafos;

public class Dijkstra extends Camino {

    private double dist[]; // Inicializar a +∞.
    private double pred[];
    private boolean visited[];

    public Dijkstra(Digrafo g, int origen, int destino) {
	super(g, origen, destino);

	dist = new double[g.V()];
	pred = new double[g.V()];
	visited = new boolean[g.V()];
	edge = new Arista[g.V()];

	for (int i = 0; i < dist.length; i++) {
	    dist[i] = Double.POSITIVE_INFINITY;
	    visited[i] = false;
	    pred[i] = -1;
	}

	dist[origen] = 0;

	for (int i = 0; i < dist.length; i++) {
	    int next = minVertex(dist, visited);
	    if (next == destino) {
		// solo me interesa el camino hasta destino. corto el algoritmo
		break;
	    }
	    visited[next] = true;

	    Arista[] as = g.adj_e(next);
	    for (Arista a : as) {
		int v = a.getDestino();
		if (!visited[v]) {
		    double d = dist[next] + a.getPeso();
		    if (dist[v] > d) {
			dist[v] = d;
			pred[v] = next;
		    }
		}
	    }
	}

	double i = destino;
	while (i != origen) {
	    edge[(int) i] = new Arista((int) pred[(int) i], (int) i, (int) dist[(int) i]);
	    i = pred[(int) i];
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