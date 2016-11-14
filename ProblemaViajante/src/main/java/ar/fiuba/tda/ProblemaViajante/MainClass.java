package ar.fiuba.tda.ProblemaViajante;

public class MainClass {

	public static void main(String[] args) {
		ProblemaViajante viajanteClase = TspBuilder.crearProblemaViajante("clase.txt");
		
		ProblemaViajante.Tour resultado = viajanteClase.recorrer();
		
		System.out.println(resultado.toString());
	}
}
