package ar.fiuba.tda.ProblemaViajante;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {
	if (args.length == 0) {
	    System.err.println("Falta argumento(s) con el/los archivo(s) .tsp");
	    return;
	}
	for (String file : args) {
	    try {
		ProblemaViajante viajante = TspBuilder.crearProblemaViajante(file);
		long starTime = System.nanoTime();
		int costo = viajante.recorrer();
		long endTime = System.nanoTime();
		System.out.println("Tsp con " + String.valueOf(viajante.getCantidadCiudades()) + " ciudades - Costo: "
			+ String.valueOf(costo) + " - Tiempo: "
			+ String.valueOf(TimeUnit.NANOSECONDS.toSeconds(endTime - starTime)) + " sec");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
}
