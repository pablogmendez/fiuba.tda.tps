package ar.fiuba.tda.RecorridoEnGrafos;

public class Heuristica {

	private class Coordenada {
		private int x, y;

		public Coordenada(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int X() {
			return x;
		}

		public int Y() {
			return y;
		}
	}

	private static final double MULTIPLIER = 1.3;
	private Heuristica.Coordenada[] nodos;

	public Heuristica(int numNodos) {
		nodos = new Heuristica.Coordenada[numNodos];
	}

	public void agregarNodo(int nodo, int x, int y) {
		nodos[nodo] = new Coordenada(x, y);
	}

	public int calcular(int src, int dst) {
		Heuristica.Coordenada cOri = nodos[src];
		Heuristica.Coordenada cDes = nodos[dst];

		/*
		 * Calcula distancia euclidea entre ambos vectores, agregando un 30%
		 * extra ya que es una mejor estimacion (porque si no estaria siempre
		 * estimando que los nodos a recorrer van a estar alineados en la recta
		 * que une src y dst)
		 */
		return (int) Math.round(MULTIPLIER * Math.sqrt(Math.pow(cDes.X() - cOri.X(), 2) + Math.pow(cDes.Y() - cOri.Y(), 2)));
	}
}
