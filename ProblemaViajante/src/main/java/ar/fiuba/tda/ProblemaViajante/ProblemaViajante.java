package ar.fiuba.tda.ProblemaViajante;

import java.util.LinkedList;

public class ProblemaViajante {

    private int[][] costos;
    private int origen;

    // Las ciudades se numeran de 1..N
    public ProblemaViajante(int numCiudades, int ciudadOrigen, int[][] distancias) {
	assert (numCiudades > 0);
	assert (ciudadOrigen > 0 && ciudadOrigen <= numCiudades);
	assert (distancias.length == numCiudades && distancias[0].length == numCiudades);

	origen = ciudadOrigen - 1; // Transf idCiudad a indice
	costos = distancias;
    }
    
    public int getCantidadCiudades() {
	return costos.length;
    }

    /* Retorna costo final */
    public int recorrer() {
	LinkedList<Integer> noVisitados = new LinkedList<Integer>();
	for (int i = 0; i < costos.length; ++i) {
	    noVisitados.add(i);
	}
	noVisitados.remove(origen);
	return recorrerRecursivo(origen, noVisitados);
    }

    @SuppressWarnings("unchecked")
    private int recorrerRecursivo(int ciudadDesde, LinkedList<Integer> noVisitados) {
	if (noVisitados.isEmpty()) {
	    return costos[ciudadDesde][origen];
	}

	int costoMin = Integer.MAX_VALUE;
	for (int ciudad : noVisitados) {
	    LinkedList<Integer> noVisitadosRec = (LinkedList<Integer>) noVisitados.clone();
	    noVisitadosRec.remove(new Integer(ciudad));
	    int costo = recorrerRecursivo(ciudad, noVisitadosRec) + costos[ciudadDesde][ciudad];
	    if (costo < costoMin) {
		costoMin = costo;
	    }
	}
	return costoMin;
    }
}
