package ar.fiuba.tda.TspApproximation;

public class Arista {

	private int src, dst, weight;

	public Arista(int origen, int destino, int peso) {
		assert (src >= 0 && dst >= 0 && weight >= 0);

		src = origen;
		dst = destino;
		weight = peso;
	}

	public int getOrigen() {
		return src;
	}

	public int getDestino() {
		return dst;
	}

	public int getPeso() {
		return weight;
	}
}
