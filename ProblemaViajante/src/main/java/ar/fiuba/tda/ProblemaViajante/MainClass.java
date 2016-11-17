package ar.fiuba.tda.ProblemaViajante;

public class MainClass {
    public static void main(String[] args) {
	if (args.length != 1) {
	    System.err.println("Falta argumento con el archivo .tsp");
	    return;
	}
	try {
	    ProblemaViajante viajante = TspBuilder.crearProblemaViajante(args[0]);
	    System.out.println("Costo: " + String.valueOf(viajante.recorrer()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
