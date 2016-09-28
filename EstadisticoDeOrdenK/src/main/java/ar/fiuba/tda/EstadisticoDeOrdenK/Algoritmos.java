package ar.fiuba.tda.EstadisticoDeOrdenK;

public abstract class Algoritmos {
	
    protected static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

	public abstract int calcularEstadistico(int[] array, int k);
}
