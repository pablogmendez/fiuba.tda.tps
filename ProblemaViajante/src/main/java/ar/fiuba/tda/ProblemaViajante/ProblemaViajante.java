package ar.fiuba.tda.ProblemaViajante;

public class ProblemaViajante {

	private int[][] costos;
	private int V;
	private Tour tour = null;
	
	public ProblemaViajante(int numCiudades) {
		V = numCiudades;
		costos = new int[V][V];
	}
	
	public Tour recorrer() {
		tour = new Tour();
		
		return tour;
	}
	
	private void recorrerRecursivo(int[] ciudades, int ciudadOrigen) {
		
	}
}
