package ar.fiuba.tda.TspApproximation;

import java.util.Stack;

public class ProblemaViajante {
	private Grafo gOriginal;
	private int[][] distancias;
	private int origen;

	// Las ciudades se numeran de 1..N
	public ProblemaViajante(Grafo grafo, int ciudadOrigen, int[][] distancias) {
		assert (ciudadOrigen > 0 && ciudadOrigen <= grafo.V());
		gOriginal = grafo;
		this.distancias = distancias;
		origen = ciudadOrigen - 1; // Transf idCiudad a indice
	}

	public int getCantidadCiudades() {
		return gOriginal.V();
	}

	public Resultado recorrer() {
		Grafo arbolTendido = gOriginal.generarArbolDeTendido(origen);

		/* DFS del arbol */
		int camino[] = new int[arbolTendido.V() + 1];
		int index = 0;
		boolean etiquetado[] = new boolean[arbolTendido.V()];
		for (int i = 0; i < etiquetado.length; ++i) {
			etiquetado[i] = false;
		}

		Stack<Integer> pila = new Stack<Integer>();
		pila.push(origen);

		while (!pila.empty()) {
			int v = pila.pop();
			if (!etiquetado[v]) {
				etiquetado[v] = true;
				camino[index++] = v + 1; // Indice a idCiudad

				for (int u : arbolTendido.adj(v)) {
					pila.push(u);
				}
			}
		}
		camino[arbolTendido.V()] = origen + 1;

		/* Calculo costo total */
		int costo = 0;
		for (int i = 0; i < camino.length - 1; ++i) {
			// Resto uno a los vertices xq son id y no indices
			costo += distancias[camino[i] - 1][camino[i + 1] - 1];
		}

		return new Resultado(camino, costo);
	}

	public class Resultado {
		public int camino[];
		public int costo;

		Resultado(int camino[], int costo) {
			this.camino = camino;
			this.costo = costo;
		}

		@Override
		public String toString() {
			StringBuilder b = new StringBuilder("Camino: [");
			for (int v : camino) {
				b.append(String.valueOf(v) + ',');
			}
			b.setCharAt(b.length() - 1, ']');
			b.append(" - Costo: " + String.valueOf(costo));
			return b.toString();
		}
	}
}
