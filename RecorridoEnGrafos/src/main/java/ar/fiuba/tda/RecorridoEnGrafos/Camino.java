package ar.fiuba.tda.RecorridoEnGrafos;

import java.util.ArrayList;
import java.util.List;

public abstract class Camino {
	private int src, dst;

	protected Camino(Digrafo g, int origen, int destino) {
		src = origen;
		dst = destino;
	}

	public abstract double distancia(int v);

	protected abstract Arista edge_to(int v);

	public boolean visitado(int v) {
		return distancia(v) < Double.POSITIVE_INFINITY;
	}

	public List<Arista> camino(int v) {
		/* ... */
		return new ArrayList<Arista>();
	}
}
