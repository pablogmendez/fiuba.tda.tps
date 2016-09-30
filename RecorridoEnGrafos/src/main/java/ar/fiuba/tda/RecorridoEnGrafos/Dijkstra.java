package ar.fiuba.tda.RecorridoEnGrafos;

public class Dijkstra extends Camino {

	private double dist[]; // Inicializar a +∞.
	private Arista edge[];

	public Dijkstra(Digrafo g, int origen, int destino) {
		super(g, origen, destino);

		// código del algoritmo, rellena "dist" y "edge".
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
