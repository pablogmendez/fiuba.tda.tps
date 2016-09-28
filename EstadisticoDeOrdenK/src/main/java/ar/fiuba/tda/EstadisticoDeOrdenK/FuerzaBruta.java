package ar.fiuba.tda.EstadisticoDeOrdenK;

public final class FuerzaBruta extends Algoritmos {

	@Override
	public int calcularEstadistico(int[] array, int k) {
		int min = array[0];
		for(int i = 1; i < array.length; ++i) {
			if(min > array[i]) {
				min = array[i];
			}
		}
		for(int i = 1; i < k; ++i) {
			int nuevoMin = array[0];
			for(int j = 1; j < array.length; ++j) {
				if(min < array[j] && array[j] < nuevoMin) {
					nuevoMin = array[j];
				}
			}
			min = nuevoMin;
		}
	return min;
}

}
