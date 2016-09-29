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
		if(min == k) {
			return 0;
		}
		
		for(int i = 1; i < array.length; ++i) {
			int nuevoMin;
			if(array[0] == min) {
				nuevoMin = array[1];
			}
			else {
				nuevoMin = array[0];
			}
			for(int j = 1; j < array.length; ++j) {
				if(min < array[j] && array[j] < nuevoMin) {
					nuevoMin = array[j];
				}
			}
			min = nuevoMin;
			if(k == min) {
				return i;
			}
		}
		return -1;
	}
}
