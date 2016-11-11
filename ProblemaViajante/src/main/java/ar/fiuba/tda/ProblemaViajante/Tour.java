package ar.fiuba.tda.ProblemaViajante;

import java.util.ArrayList;

public class Tour {
	private ArrayList<Integer> camino = new ArrayList<Integer>();
	private int costo = 0;

	public void agregarCiudad(int ciudad, int costo) {
		camino.add(ciudad);
		this.costo += costo;
	}

	public ArrayList<Integer> obtenerCamino() {
		return camino;
	}

	public int obtenerCosto() {
		return costo;
	}
}
