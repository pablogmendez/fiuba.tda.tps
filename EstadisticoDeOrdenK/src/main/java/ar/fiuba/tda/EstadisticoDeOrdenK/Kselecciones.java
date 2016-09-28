package ar.fiuba.tda.EstadisticoDeOrdenK;

public class Kselecciones extends Algoritmos {

	@Override
	public int calcularEstadistico(int[] array, int k) {
		for(int i = 0; i < k + 1; ++i) {
			int min = i;
			for(int j = i + 1; j < array.length; ++j) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			swap(i, min, array);
		}
		return array[k];
	}
	
}
