package ar.fiuba.tda.RecorridoEnGrafos;

public class BusqConHeuristica extends Camino {

	private double dist[]; // Inicializar a +∞.
	private Arista edge[];
	private Heuristica h;

	public BusqConHeuristica(Digrafo g, int origen, int destino, Heuristica h) {
		super(g, origen, destino);
		this.h = h;

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
