package ar.fiuba.tda.TspApproximation;

import java.util.concurrent.TimeUnit;

import ar.fiuba.tda.TspApproximation.ProblemaViajante.Resultado;

public class MainClass {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Falta argumento(s) con el/los archivo(s) .tsp");
			return;
		}
		for (String file : args) {
			try {
				ProblemaViajante viajante =
						TspBuilder.crearProblemaViajante(file);
				long starTime = System.nanoTime();
				Resultado res = viajante.recorrer();
				long endTime = System.nanoTime();
				System.out.println("Tsp con "
						+ String.valueOf(viajante.getCantidadCiudades())
						+ " ciudades - Resultado: "
						+ res.toString()
						+ " - Tiempo: "
						+ String.valueOf(TimeUnit.NANOSECONDS.toMillis(endTime
								- starTime)) + " ms");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
