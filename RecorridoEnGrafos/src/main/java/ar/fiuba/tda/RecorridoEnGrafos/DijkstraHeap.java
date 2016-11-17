package ar.fiuba.tda.RecorridoEnGrafos;

import java.util.PriorityQueue;

public class DijkstraHeap extends Camino {

    private double dist[]; // Inicializar a +∞.
    private double pred[];
    private boolean visited[];

    public DijkstraHeap(Digrafo g, int origen, int destino) {
	super(g, origen, destino);

	dist = new double[g.V()];
	pred = new double[g.V()];
	visited = new boolean[g.V()];
	edge = new Arista[g.V()];

	PriorityQueue<PrVertex> minPrQueue = new PriorityQueue<PrVertex>(g.V());

	dist[origen] = 0;
	minPrQueue.add(new PrVertex(origen, 0));

	for (int i = 0; i < dist.length; i++) {
	    if (i != origen) {
		dist[i] = Double.POSITIVE_INFINITY;
	    }
	    visited[i] = false;
	    pred[i] = -1;
	}

	while (minPrQueue.size() > 0) {
	    int next = minPrQueue.poll().getVertex();
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
			/* Cambio valores y prioridad en la cola */
			PrVertex newV = new PrVertex(v, dist[v]);
			minPrQueue.remove(newV);
			dist[v] = d;
			pred[v] = next;
			newV.setDistance(d);
			minPrQueue.add(newV);
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

    private class PrVertex implements Comparable<PrVertex> {
	private int v;
	private double distance;

	public PrVertex(int v, double distance) {
	    this.v = v;
	    this.distance = distance;
	}

	int getVertex() {
	    return v;
	}

	void setDistance(double distance) {
	    this.distance = distance;
	}

	@Override
	public int compareTo(PrVertex o) {
	    return Double.compare(this.distance, o.distance);
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