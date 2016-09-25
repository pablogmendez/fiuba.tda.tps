package ar.fiuba.tda.EstadisticoDeOrdenK;

public final class FuerzaBruta extends Algoritmos {

	@Override
	public int minimo(int[] array) {
		int min = array[0];
		for(int i = 1; i < array.length; ++i) {
			if(min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

	@Override
	public int maximo(int[] array) {
		int max = array[0];
		for(int i = 1; i < array.length; ++i) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

	@Override
	public int mediana(int[] array) {
		int max = maximo(array);
		int min = minimo(array);
		int lastMin=min;
		int k = array.length/2;
		int mid;
		
		for(int i = 0; i < k-1; ++i) {
			mid = max;
			for(int j = 0; j  < array.length; ++j) {
				if(lastMin < array[j] && array[j] < mid) {
					mid = array[j];
				}
			}
			lastMin = mid;
		}
		return lastMin;
	}
}
