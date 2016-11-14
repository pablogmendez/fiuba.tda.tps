package ar.fiuba.tda.ProblemaViajante;

import java.util.LinkedList;

public class ProblemaViajante {

	private int[][] costos;
	private int origen;
	private int[] camino;

	// Las ciudades se numeran de 1..N
	public ProblemaViajante(int numCiudades, int ciudadOrigen, int[][] distancias) {
		assert (numCiudades > 0);
		assert (ciudadOrigen > 0 && ciudadOrigen <= numCiudades);
		assert (distancias.length == numCiudades && distancias[0].length == numCiudades);
		
		origen = ciudadOrigen - 1;	// Transf idCiudad a indice
		costos = distancias;
		camino = new int[numCiudades + 1];
		camino[0] = camino[numCiudades] = ciudadOrigen;
	}

	public Tour recorrer() {
		LinkedList<Integer> noVisitados = new LinkedList<Integer>();
		for (int i = 0; i < costos.length; ++i) {
			noVisitados.add(i);
		}
		noVisitados.remove(origen);
		int costoFinal = recorrerRecursivo(origen, noVisitados, 1);
		return new Tour(camino, costoFinal);
	}

	@SuppressWarnings("unchecked")
	private int recorrerRecursivo(int ciudadDesde, LinkedList<Integer> noVisitados, int profundidad) {
		if (noVisitados.isEmpty()) {
			return costos[ciudadDesde][origen];
		}

		int costoMin = 999999999;
		int ciudadElegida = -1;
		for (int ciudad : noVisitados) {
			LinkedList<Integer> noVisitadosRec = (LinkedList<Integer>) noVisitados.clone();
			noVisitadosRec.remove(new Integer(ciudad));
			int costo = recorrerRecursivo(ciudad, noVisitadosRec, profundidad + 1) + costos[ciudadDesde][ciudad];
			if (costo < costoMin) {
				costoMin = costo;
				ciudadElegida = ciudad + 1; // Transf indice a idCiudad
			}
		}
		camino[profundidad] = ciudadElegida;
		return costoMin;
	}
	
	public class Tour {
		private int[] camino;
		private int costo;

		private Tour(int[] camino, int costo) {
			this.camino = camino;
			this.costo = costo;
		}
		
		public int[] getCamino() {
			return camino;
		}
		
		public int getCosto() {
			return costo;
		}

		public String toString() {
			StringBuilder builder = new StringBuilder(200);
			builder.append("Camino: ");
			builder.append('[');
			for(int ciudad : camino) {
				builder.append(String.valueOf(ciudad) + ',');
			}
			builder.setCharAt(builder.length() - 1, ']');
			builder.append(" - Costo: " + String.valueOf(costo));
			return builder.toString();
		}
	}
}
